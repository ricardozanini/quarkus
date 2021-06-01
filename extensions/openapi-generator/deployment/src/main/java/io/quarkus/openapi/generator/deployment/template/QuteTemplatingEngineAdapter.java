package io.quarkus.openapi.generator.deployment.template;

import java.io.IOException;
import java.util.Map;

import io.quarkus.qute.Engine;
import io.quarkus.qute.ReflectionValueResolver;
import io.quarkus.qute.Template;
import org.openapitools.codegen.api.AbstractTemplatingEngineAdapter;
import org.openapitools.codegen.api.TemplatingExecutor;

public class QuteTemplatingEngineAdapter extends AbstractTemplatingEngineAdapter {

    public static final String IDENTIFIER = "qute";
    public static final String[] INCLUDE_TEMPLATES = {
            "pathParams.qute",
            "queryParams.qute",
            "bodyParams.qute",
            "formParams.qute",
            "headerParams.qute",
            "beanValidationCore.qute",
            "beanValidationHeaderParams.qute"
    };
    public final Engine engine;

    public QuteTemplatingEngineAdapter() {
        // TODO: inject from qute buildStep
        this.engine = Engine.builder()
                .addDefaults()
                .addValueResolver(new ReflectionValueResolver())
                .removeStandaloneLines(true)
                .build();
    }

    @Override
    public String getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public String[] getFileExtensions() {
        return new String[]{IDENTIFIER};
    }

    @Override
    public String compileTemplate(TemplatingExecutor executor, Map<String, Object> bundle, String templateFile)
            throws IOException {
        // TODO: won't be necessary once we retrieve the engine from the BuildStep
        this.cacheTemplates(executor);
        Template template = engine.getTemplate(templateFile);
        if (template == null) {
            template = engine.parse(executor.getFullTemplateContents(templateFile));
            engine.putTemplate(templateFile, template);
        }
        return template.data(bundle).render();
    }

    // TODO: remove it once we have the Engine reference from BuildStep, which should cache all the templates automatically
    public void cacheTemplates(TemplatingExecutor executor) {
        for (String templateId : INCLUDE_TEMPLATES) {
            Template incTemplate = engine.getTemplate(templateId);
            if (incTemplate == null) {
                incTemplate = engine.parse(executor.getFullTemplateContents(templateId));
                engine.putTemplate(templateId, incTemplate);
            }
        }
    }
}
