package com.biblegamedev.gwf.common.settings

import android.app.Application
import com.biblegamedev.gwf.common.mvvm.BaseViewModel
import com.biblegamedev.gwf.helpers.Command

class SettingsViewModel(application: Application) : BaseViewModel(application) {

    val showDayNightDialogCommand = Command()

    fun dayNightSettingClicked() {
        showDayNightDialogCommand.call()
    }
}