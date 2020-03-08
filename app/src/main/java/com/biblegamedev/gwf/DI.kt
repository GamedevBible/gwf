package com.biblegamedev.gwf

import android.content.Context
import com.biblegamedev.gwf.common.main.MainViewModel
import com.biblegamedev.gwf.common.settings.SettingsViewModel
import com.biblegamedev.gwf.crocodile.CrocodileGameService
import com.biblegamedev.gwf.crocodile.game.CrocodileGameViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.experimental.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.koin.experimental.builder.single

fun initDI(context: Context) {
    startKoin {
        androidContext(context)
        modules(module {
            single<CrocodileGameService>()

            viewModel<MainViewModel>()
            viewModel<SettingsViewModel>()
            viewModel<CrocodileGameViewModel>()
        })
    }
}