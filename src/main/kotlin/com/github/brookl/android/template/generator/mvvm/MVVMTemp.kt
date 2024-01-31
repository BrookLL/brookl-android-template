package com.github.brookl.android.template.generator.mvvm

import com.github.brookl.android.template.util.firstUppercase


/**
 * 生成XxActivity文件的内容，你的项目里是啥，就是啥，不要用我这个模板
 */
fun mvvmActivityTemp(
    modulePackageName: String,
    classPackageName: String,
    bizName: String
): String {
    return """
    package $classPackageName
    
    import com.best.android.base.BaseActivity
    import com.best.android.base.manager.createViewBinding
    import com.best.android.base.manager.createViewModel
    import com.best.android.common.databinding.Activity${bizName}Binding
    import ${modulePackageName}.R

    class ${bizName.firstUppercase()}Activity : BaseActivity() {
        private lateinit var mBinding: Activity${bizName.firstUppercase()}Binding
        private lateinit var mViewModel: ${bizName.firstUppercase()}ViewModel
        override fun initView() {
            mBinding = createViewBinding()
            mViewModel = createViewModel()
            
             //以下示例用不到可以删除
            mViewModel.example.observe(this) { example ->
                // 更新UI
            }
        }

    }
""".trimIndent()
}

fun mvvmViewModelTemp(
    classPackageName: String,
    bizName: String
): String {
    return """
    package $classPackageName
    
    import com.best.android.base.BaseApplication
    import com.best.android.base.BaseViewModel

    class ${bizName.firstUppercase()}ViewModel(application: BaseApplication) : BaseViewModel(application) {
    
         //以下示例用不到可以删除
        val example = MutableLiveData<String>()
    
        init {
            load()//ViewModel初始化时调用
        }
    
        fun load(){
            showProgress()
            launcher {
                example.value = "http or db Data"
            }
        }
    }
""".trimIndent()
}



