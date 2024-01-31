package com.github.brookl.android.template.generator.mvvm

import com.github.brookl.android.template.util.firstUppercase

fun activityLayoutTemp(classPackageName: String,bizName: String): String {
    return """
    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        tools:context="$classPackageName.${bizName.firstUppercase()}Activity">

    </LinearLayout>
    """
}

