package org.example.evangelhistory.aspects;

import org.example.evangelhistory.configs.WebpackManifestService;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Map;

@ControllerAdvice
public class GlobalModelAttributes {

    private final WebpackManifestService manifestService;

    public GlobalModelAttributes(WebpackManifestService manifestService) {
        this.manifestService = manifestService;
    }

    @ModelAttribute("manifest")
    @NonNull
    public Map<String, String> addManifest() {
        // Возвращаем готовую мапу с манифестом, всегда не null
        return manifestService.getManifest();
    }
}