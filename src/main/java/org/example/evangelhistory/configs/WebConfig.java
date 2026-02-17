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
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 1. Создаем стратегию хэширования содержимого (Fingerprinting)
        org.springframework.web.servlet.resource.VersionResourceResolver versionResolver =
                new org.springframework.web.servlet.resource.VersionResourceResolver()
                        .addVersionStrategy(new org.springframework.web.servlet.resource.ContentVersionStrategy(), "/**");

        // 2. Регистрируем обработчик для всей статики
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/")
                .resourceChain(true) // Включаем цепочку ресурсов
                .addResolver(versionResolver) // Сначала ищем версию (хэш)
                .addResolver(new org.springframework.web.servlet.resource.PathResourceResolver()); // Затем ищем физический файл
    }
}
