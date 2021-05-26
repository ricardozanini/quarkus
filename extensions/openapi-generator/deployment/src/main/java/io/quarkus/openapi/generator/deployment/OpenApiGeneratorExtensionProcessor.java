package io.quarkus.openapi.generator.deployment;

import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;

class OpenApiGeneratorExtensionProcessor {

    private static final String FEATURE = "openapi-generator-extension";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

}
