package io.quarkus.openapi.generator.deployment;

import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.CombinedIndexBuildItem;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import io.quarkus.deployment.builditem.nativeimage.NativeImageConfigBuildItem;
import io.quarkus.deployment.builditem.nativeimage.NativeImageSystemPropertyBuildItem;
import io.quarkus.deployment.builditem.nativeimage.ReflectiveClassBuildItem;

class OpenApiGeneratorProcessor {

    // TODO: add to Feature Enum io.quarkus.deployment.Feature.OPENAPI
    private static final String FEATURE = "openapi-generator-extension";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

    @BuildStep
    public void buildGeneratedCode(CombinedIndexBuildItem indexBuildItem,
            BuildProducer<ReflectiveClassBuildItem> reflectiveClass,
            BuildProducer<NativeImageSystemPropertyBuildItem> sys,
            BuildProducer<NativeImageConfigBuildItem> conf) {
        // TODO: placeholder, build generated classes, register clients, mark model to reflection
    }
}
