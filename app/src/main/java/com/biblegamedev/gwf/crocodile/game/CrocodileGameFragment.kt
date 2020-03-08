package com.biblegamedev.gwf.crocodile.game

import com.biblegamedev.gwf.common.mvvm.BaseDialogFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class CrocodileGameFragment : BaseDialogFragment<CrocodileGameViewModel>() {

    override val viewModel: CrocodileGameViewModel by viewModel()

}