package io.quarkus.openapi.generator.deployment.template;

import java.io.IOException;
import java.util.Map;

import org.openapitools.codegen.api.AbstractTemplatingEngineAdapter;
import org.openapitools.codegen.api.TemplatingExecutor;

import io.quarkus.qute.Engine;
import io.quarkus.qute.Template;

public class QuteTemplatingEngineAdapter extends AbstractTemplatingEngineAdapter {

    public static final String IDENTIFIER = "qute";

    public final Engine engine;

    public QuteTemplatingEngineAdapter() {
        this.engine = Engine.builder()
                .addDefaults()
                .removeStandaloneLines(true)
                .build();
    }

    @Override
    public String getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public String[] getFileExtensions() {
        return new String[] { IDENTIFIER };
    }

    @Override
    public String compileTemplate(TemplatingExecutor executor, Map<String, Object> bundle, String templateFile)
            throws IOException {
        Template template = engine.getTemplate(templateFile);
        if (template == null) {
            template = engine.parse(executor.getFullTemplateContents(templateFile));
            engine.putTemplate(templateFile, template);
        }
        return template.data(bundle).render();
    }
}
