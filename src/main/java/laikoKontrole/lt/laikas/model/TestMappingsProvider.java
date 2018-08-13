package laikoKontrole.lt.laikas.model;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
@ConditionalOnProperty("test.mappings-provider-enabled")
@EnableConfigurationProperties({ServerProperties.class, CharonProperties.class})
public class TestMappingsProvider extends MappingsProvider {

    private final MappingsRepository mappingsRepository;

    public TestMappingsProvider(ServerProperties server, CharonProperties charon, MappingsCorrector mappingsCorrector, HttpClientProvider httpClientProvider, MappingsRepository mappingsRepository) {
        super(server, charon, mappingsCorrector, httpClientProvider);
        this.mappingsRepository = mappingsRepository;
    }

    @Override
    protected boolean shouldUpdateMappings(HttpServletRequest request) {
        return true;
    }

    @Override
    protected List<MappingProperties> retrieveMappings() {
        return mappingsRepository.getMappings();
    }
}