package com.biblegamedev.gwf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mDayNightMode = AppCompatDelegate.getDefaultNightMode();

        aliasButton.setOnClickListener {
            mDayNightMode = if (mDayNightMode == AppCompatDelegate.MODE_NIGHT_NO)
                AppCompatDelegate.MODE_NIGHT_YES
            else
                AppCompatDelegate.MODE_NIGHT_NO
            AppCompatDelegate.setDefaultNightMode(mDayNightMode)
            delegate.applyDayNight()
        }
    }
}
