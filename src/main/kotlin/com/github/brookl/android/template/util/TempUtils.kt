package com.github.brookl.android.template.util

import com.android.tools.idea.wizard.template.camelCaseToUnderlines
import com.android.tools.idea.wizard.template.underscoreToCamelCase
import org.jetbrains.kotlin.util.capitalizeDecapitalize.toLowerCaseAsciiOnly

fun activityLayoutName(moduleName: String, bizName: String): String {
    return "activity_${layoutPrefix(moduleName,bizName)}"
}

fun fragmentLayoutName(moduleName: String, bizName: String): String {
    return "${layoutPrefix(moduleName,bizName)}_fragment"
}

fun itemFirstLayoutName(moduleName: String, bizName: String): String {
    return "${layoutPrefix(moduleName,bizName)}_item_first"
}

fun fragmentClassName(bizName: String): String {
    return "${bizName.firstUppercase()}Fragment"
}


/**
 *  moduleName 可能出现的形式  user、 User 、 UserCenter 、User_Center 、 UserCenter_kkk
 *  因为要作为布局文件名的前缀，必须都转成小写
 */
fun fragmentDataBindingName(moduleName: String, bizName: String): String {
    val layoutPrefix = layoutPrefix(moduleName, bizName)
    //sd_te --> SdTe
    var camelCaseName = underscoreToCamelCase(layoutPrefix)
    return "${camelCaseName}FragmentBinding"
}

/**
 * 形式 ab_cd_ef 必须都是小写，以下划线连接
 */
fun layoutPrefix(moduleName: String, bizName: String): String {
    return if (moduleName.isNullOrBlank()){
        camelCaseToUnderlines(bizName).toLowerCaseAsciiOnly()
    }else{
        "${moduleName.toLowerCaseAsciiOnly()}_${camelCaseToUnderlines(bizName).toLowerCaseAsciiOnly()}"
    }

}

fun String.firstUppercase(): String {
    return this.replaceFirstChar { it.uppercase() }
}
