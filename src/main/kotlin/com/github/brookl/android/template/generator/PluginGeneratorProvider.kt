package com.github.brookl.android.template.generator

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import com.github.brookll.brooklandroidtemplate.generator.mvvm.jlMvvmGenerator


class PluginGeneratorProvider : WizardTemplateProvider() {

    override fun getTemplates(): List<Template> = listOf(
        jlMvvmGenerator(),
    )
}
