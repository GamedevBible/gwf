package com.biblegamedev.gwf.common.main

import com.biblegamedev.gwf.common.mvvm.BaseDialogFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainDialogFragment : BaseDialogFragment<MainViewModel>() {

    override val viewModel: MainViewModel by viewModel()

}