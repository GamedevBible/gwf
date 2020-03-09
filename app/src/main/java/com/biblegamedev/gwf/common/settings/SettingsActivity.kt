package com.biblegamedev.gwf.common.settings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.biblegamedev.gwf.R
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        initViews()
    }

    fun applyDayNightMode() {
        delegate.applyDayNight()
    }

    private fun initViews() {
        dayNightModeClickLayout.setOnClickListener {
            DayNightBottomSheetFragment.showInsideBottomSheet(supportFragmentManager)
        }
    }
}