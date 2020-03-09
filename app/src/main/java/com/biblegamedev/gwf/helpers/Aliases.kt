package com.biblegamedev.gwf.helpers

import androidx.lifecycle.MutableLiveData

typealias Text = MutableLiveData<String>
typealias Visible = MutableLiveData<Boolean>
typealias Checkable = MutableLiveData<Boolean>
typealias Enabled = MutableLiveData<Boolean>
typealias Command = LiveEvent
typealias TCommand<T> = SingleLiveEvent<T>
typealias Data<T> = MutableLiveData<T>
typealias DataList<T> = MutableLiveData<List<T>>
typealias Progress = MutableLiveData<Float>