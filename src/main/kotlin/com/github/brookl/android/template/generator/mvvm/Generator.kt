package com.github.brookll.brooklandroidtemplate.generator.mvvm


import com.android.tools.idea.wizard.template.Category
import com.android.tools.idea.wizard.template.Constraint
import com.android.tools.idea.wizard.template.FormFactor
import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.TextFieldWidget
import com.android.tools.idea.wizard.template.WizardUiContext
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import com.android.tools.idea.wizard.template.stringParameter
import com.android.tools.idea.wizard.template.template
import com.github.brookl.android.template.generator.mvvm.mvvmRecipe


/**
 * 模板配置需要的参数，根据你的需要，在这里添加
 */
fun jlMvvmGenerator(): Template {

    return template {
        name = "WMS MVVM Business"
        description =
            "生成一套WMS MVVM模式业务代码，包括：package、Activity、layout(ViewBinding)、ViewModel"
        minApi = MIN_API

        category = Category.Other
        formFactor = FormFactor.Mobile
        screens = listOf(
            WizardUiContext.ActivityGallery,
            WizardUiContext.MenuEntry,
            WizardUiContext.NewProject,
            WizardUiContext.NewModule
        )

        //业务名称
        val bizNameParameter = stringParameter {
            name = "Business Name：英文，小驼峰命名，可以多单词"
            default = ""
            help = "业务名称：英文，小驼峰命名，可以多单词，生成对应业务的package、Activity、layout文件、ViewModel"
            constraints = listOf(Constraint.NONEMPTY)
        }


        val classPackageNameParameter = stringParameter {
            name = "Class Package Name: 建议不要修改"
            help = "文件名称：业务文件名称"
            default = ""
            constraints = listOf(Constraint.PACKAGE)
            suggest = { packageName }
        }

        widgets(
            TextFieldWidget(bizNameParameter),
            TextFieldWidget(classPackageNameParameter)
        )

        recipe = {
            mvvmRecipe(
                it as ModuleTemplateData,
                bizNameParameter.value,
                classPackageNameParameter.value
            )
        }
    }
}