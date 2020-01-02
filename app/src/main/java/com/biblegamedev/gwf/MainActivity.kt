package com.biblegamedev.gwf

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.animation.doOnEnd
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mDayNightMode = AppCompatDelegate.getDefaultNightMode()

        aliasClickLayout.setOnClickListener {
            mDayNightMode = if (mDayNightMode == AppCompatDelegate.MODE_NIGHT_NO)
                AppCompatDelegate.MODE_NIGHT_YES
            else
                AppCompatDelegate.MODE_NIGHT_NO
            AppCompatDelegate.setDefaultNightMode(mDayNightMode)
            delegate.applyDayNight()
        }

        settingsClickLayout.setOnClickListener {
            val settingsAnimX = ObjectAnimator.ofFloat(settingsLayout, View.TRANSLATION_X, 0f, ((-1 * this.resources.displayMetrics.widthPixels) / 2 + 100).toFloat()).apply { duration = 500 }
            val settingsAnimY = ObjectAnimator.ofFloat(settingsLayout, View.TRANSLATION_Y, 0f, (this.resources.displayMetrics.heightPixels / 2 - 100).toFloat()).apply { duration = 500 }
            val settingsAnimFade = ObjectAnimator.ofFloat(settingsLayout, View.ALPHA, 1f, 0f).apply { duration = 500 }
            val settingsAnimScaleX = ObjectAnimator.ofFloat(settingsLayout, View.SCALE_X, 1f, 5f).apply { duration = 500 }
            val settingsAnimScaleY = ObjectAnimator.ofFloat(settingsLayout, View.SCALE_Y, 1f, 5f).apply { duration = 500 }
            val animSetSettings = AnimatorSet()
            animSetSettings.playTogether(settingsAnimX, settingsAnimY, settingsAnimFade, settingsAnimScaleX, settingsAnimScaleY)
            animSetSettings.start()
        }
    }

    override fun onResume() {
        super.onResume()

        AnimateButtonsIn()
    }

    private fun AnimateButtonsIn() {

        boomLayout.visibility = View.INVISIBLE
        crocodileLayout.visibility = View.INVISIBLE
        aliasLayout.visibility = View.INVISIBLE
        settingsLayout.visibility = View.INVISIBLE

        val settingsAnimY = ObjectAnimator.ofFloat(settingsLayout, View.TRANSLATION_Y, -100f, 0f).apply { duration = 200 }
        val settingsAnimFade = ObjectAnimator.ofFloat(settingsLayout, View.ALPHA, 0f, 1f).apply { duration = 200 }
        val animSetSettings = AnimatorSet()
        animSetSettings.playTogether(settingsAnimY, settingsAnimFade)

        val crocodileAnimY = ObjectAnimator.ofFloat(crocodileLayout, View.TRANSLATION_Y, -100f, 0f).apply { duration = 200 }
        val crocodileAnimFade = ObjectAnimator.ofFloat(crocodileLayout, View.ALPHA, 0f, 1f).apply { duration = 200 }
        val animSetCrocodile = AnimatorSet()
        animSetCrocodile.playTogether(crocodileAnimY, crocodileAnimFade)
        animSetCrocodile.doOnEnd {
            animSetSettings.start()
            settingsLayout.visibility = View.VISIBLE
        }

        val aliasAnimY = ObjectAnimator.ofFloat(aliasLayout, View.TRANSLATION_Y, -100f, 0f).apply { duration = 200 }
        val aliasAnimFade = ObjectAnimator.ofFloat(aliasLayout, View.ALPHA, 0f, 1f).apply { duration = 200 }
        val animSetAlias = AnimatorSet()
        animSetAlias.playTogether(aliasAnimY, aliasAnimFade)
        animSetAlias.doOnEnd {
            animSetCrocodile.start()
            crocodileLayout.visibility = View.VISIBLE
        }

        val boomAnimY = ObjectAnimator.ofFloat(boomLayout, View.TRANSLATION_Y, -100f, 0f).apply { duration = 200 }
        val boomAnimFade = ObjectAnimator.ofFloat(boomLayout, View.ALPHA, 0f, 1f).apply { duration = 200 }
        val animSetBoom = AnimatorSet()
        animSetBoom.playTogether(boomAnimY, boomAnimFade)
        animSetBoom.doOnEnd {
            animSetAlias.start()
            aliasLayout.visibility = View.VISIBLE
        }

        animSetBoom.start()
        boomLayout.visibility = View.VISIBLE
    }
}
