package com.biblegamedev.gwf.common.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.biblegamedev.gwf.R
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_settings_daynight_bottom_sheet.*

class DayNightBottomSheetFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_settings_daynight_bottom_sheet, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews() {
        autoModeClickLayout.setOnClickListener {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
            (activity as SettingsActivity).applyDayNightMode()
        }
        dayModeClickLayout.setOnClickListener {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            (activity as SettingsActivity).applyDayNightMode()
        }
        nightModeClickLayout.setOnClickListener {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            (activity as SettingsActivity).applyDayNightMode()
        }
    }

    companion object {
        fun newInstance() = DayNightBottomSheetFragment()

        fun showInsideBottomSheet(fragmentManager: FragmentManager) {
            DayNightBottomSheetFragment()
                .show(fragmentManager, DayNightBottomSheetFragment::class.java.name)
        }
    }
}