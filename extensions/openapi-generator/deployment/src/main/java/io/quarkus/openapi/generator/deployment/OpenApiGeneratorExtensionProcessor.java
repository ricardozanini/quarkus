package io.quarkus.openapi.generator.deployment;

import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;

class OpenApiGeneratorExtensionProcessor {

    // TODO: add to Feature Enum io.quarkus.deployment.Feature.OPENAPI
    private static final String FEATURE = "openapi-generator-extension";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }
}
