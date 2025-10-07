package org.example.evangelhistory.configs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix ="app.media")
@Getter
@Setter
public class MediaProperties {
    private String uploadDir = "./uploads";
}
