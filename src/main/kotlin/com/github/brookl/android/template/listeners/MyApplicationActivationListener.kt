package com.github.brookl.android.template.listeners

import com.github.brookl.android.template.services.MyProjectService
import com.intellij.openapi.application.ApplicationActivationListener
import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.openapi.wm.IdeFrame
import com.intellij.openapi.project.Project


internal class MyApplicationActivationListener : ApplicationActivationListener {
    companion object {
        var p: Project? = null
    }

    override fun applicationActivated(ideFrame: IdeFrame) {
        thisLogger().warn("Don't forget to remove all non-needed sample code files with their corresponding registration entries in `plugin.xml`.")
        super.applicationActivated(ideFrame)
        p = ideFrame.project
        p?.getService(MyProjectService::class.java)
    }

    override fun applicationDeactivated(ideFrame: IdeFrame) {
        super.applicationDeactivated(ideFrame)
        p = null
    }
}
