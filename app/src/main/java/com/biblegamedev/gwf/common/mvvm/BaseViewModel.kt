package com.biblegamedev.gwf.common.mvvm

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel

abstract class BaseViewModel(application: Application)
    : AndroidViewModel(application) {

    protected val context: Context by lazy { getApplication<Application>() }
}