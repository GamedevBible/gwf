package com.biblegamedev.gwf.common.mvvm

import androidx.fragment.app.DialogFragment

abstract class BaseDialogFragment<TViewModel> : DialogFragment() where TViewModel: BaseViewModel {

    protected abstract val viewModel: TViewModel
}