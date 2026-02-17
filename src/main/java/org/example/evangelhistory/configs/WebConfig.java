package org.example.evangelhistory.configs;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.ContentVersionStrategy;
import org.springframework.web.servlet.resource.VersionResourceResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(@NotNull ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login").setViewName("login");
    }

    @Override
    public void addResourceHandlers(org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry registry) {
        org.springframework.web.servlet.resource.VersionResourceResolver versionResolver =
                new org.springframework.web.servlet.resource.VersionResourceResolver()
                        .addVersionStrategy(new org.springframework.web.servlet.resource.ContentVersionStrategy(), "/**");

        // Явно прописываем папки, чтобы Spring не путался
        registry.addResourceHandler("/css/**", "/js/**", "/img/**", "/uploads/**")
                .addResourceLocations("classpath:/static/css/", "classpath:/static/js/", "classpath:/static/img/", "classpath:/static/uploads/")
                .setCachePeriod(3600) // Кэш на час для надежности
                .resourceChain(true)
                .addResolver(versionResolver)
                .addResolver(new org.springframework.web.servlet.resource.PathResourceResolver());
    }
}
