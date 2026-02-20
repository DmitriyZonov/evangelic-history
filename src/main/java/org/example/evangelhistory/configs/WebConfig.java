package org.example.evangelhistory.configs;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.ResourceUrlEncodingFilter;
import org.springframework.web.servlet.resource.VersionResourceResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(@NotNull ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login").setViewName("login");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**") // Любой запрос, начинающийся с /css/, /js/ и т.д.
                .addResourceLocations("classpath:/static/") // Искать в корне папки static
                .setCachePeriod(3600)
                .resourceChain(true)
                .addResolver(new VersionResourceResolver()
                        .addContentVersionStrategy("/**"));
    }
    @Bean
    public static ResourceUrlEncodingFilter resourceUrlEncodingFilter() {
        return new ResourceUrlEncodingFilter();
    }
}
