package org.example.evangelhistory.configs;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.annotation.PostConstruct;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

@Service
@Getter
public class WebpackManifestService {

    private static final Logger log = LoggerFactory.getLogger(WebpackManifestService.class);
    private Map<String, String> manifest = Collections.emptyMap();

    @PostConstruct
    public void init() {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream is = getClass().getResourceAsStream("/static/dist/manifest.json")) {
            if (is != null) {
                manifest = mapper.readValue(is, new TypeReference<Map<String, String>>() {});
                log.info("Webpack manifest loaded successfully with {} entries", manifest.size());
            } else {
                log.warn("manifest.json not found in /static/dist/");
            }
        } catch (IOException e) {
            log.error("Error reading manifest.json", e);
        }
    }
}