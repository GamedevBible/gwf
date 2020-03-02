package com.biblegamedev.gwf.common.settings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.biblegamedev.gwf.R
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        initViews()
    }

    private fun initViews() {
        dayNightModeClickLayout.setOnClickListener {
            val mDayNightMode = if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO)
                AppCompatDelegate.MODE_NIGHT_YES
            else
                AppCompatDelegate.MODE_NIGHT_NO
            AppCompatDelegate.setDefaultNightMode(mDayNightMode)
            delegate.applyDayNight()
        }

        //TODO сделать всплывашку снизу с выбором режима + прикрутить к этой логике SharedPreferences
        /*dayNightModeClickLayout.setOnClickListener {
            val themeFragment = DayNightBottomSheetFragment.newInstance()
            themeFragment.show(supportFragmentManager, themeFragment.tag)
        }*/
    }
}