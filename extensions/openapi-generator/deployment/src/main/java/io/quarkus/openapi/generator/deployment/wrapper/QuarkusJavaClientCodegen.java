package io.quarkus.openapi.generator.deployment.wrapper;

import org.openapitools.codegen.languages.JavaClientCodegen;

public class QuarkusJavaClientCodegen extends JavaClientCodegen {

    public QuarkusJavaClientCodegen() {
        // TODO: immutable properties
        this.setDateLibrary(JavaClientCodegen.JAVA8_MODE);
        this.setTemplateDir("templates");
    }

    @Override
    public String getName() {
        return "quarkus";
    }

    @Override
    public void processOpts() {
        super.processOpts();
        // TODO: review / add or remove what we need/support
        supportingFiles.clear();
        apiTemplateFiles.clear();
        apiTemplateFiles.put("api.qute", ".java");
        modelTemplateFiles.clear();
        modelTemplateFiles.put("model.qute", ".java");
    }
}
