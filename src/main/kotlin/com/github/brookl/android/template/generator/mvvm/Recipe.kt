package com.github.brookl.android.template.generator.mvvm


import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest
import com.github.brookl.android.template.util.activityLayoutName
import com.github.brookl.android.template.util.firstUppercase

/**
 * 模板代码文件的创建与保存
 *
 * 这里有几个变量需要注意下：
 * ```
 * //当前批量生成类文件所在目录 com.example.x.y
 * classPackageName：
 *
 * //模块名，例如 user
 * val moduleName = moduleData.rootDir.name.toLowerCaseAsciiOnly()
 *
 * //模块包名，例如com.example.user , 在模块AndroidManifest.xml中配置的那个，一定要注意
 * val modulePackageName = projectData.applicationPackage
 * ```
 */
fun RecipeExecutor.mvvmRecipe(
    moduleData: ModuleTemplateData,
    bizName: String,
    classPackageName: String,
) {
    val (projectData, srcOut, resOut) = moduleData
    val modulePackageName = projectData.applicationPackage ?: ""

    save(
        mvvmActivityTemp(modulePackageName, classPackageName, bizName),
        srcOut.resolve("${bizName}/${bizName.firstUppercase()}Activity.kt")
    )
//        插入Manifest
    generateManifest(
        moduleData = moduleData,
        activityClass = "${bizName.firstUppercase()}Activity",
        packageName = "${classPackageName}.${bizName}.ui",
        isLauncher = false,
        hasNoActionBar = false,
        isNewModule = false,
        isLibrary = false,
        generateActivityTitle = false
    )

    save(
        mvvmViewModelTemp(classPackageName, bizName),
        srcOut.resolve("${bizName}/${bizName.firstUppercase()}ViewModel.kt")
    )
    save(
        activityLayoutTemp(classPackageName, bizName),
        resOut.resolve("layout/${activityLayoutName("", bizName)}.xml")
    )

}