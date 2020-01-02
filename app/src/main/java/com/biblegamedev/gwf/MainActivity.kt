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

        var mDayNightMode = AppCompatDelegate.getDefaultNightMode();

        aliasClickLayout.setOnClickListener {
            mDayNightMode = if (mDayNightMode == AppCompatDelegate.MODE_NIGHT_NO)
                AppCompatDelegate.MODE_NIGHT_YES
            else
                AppCompatDelegate.MODE_NIGHT_NO
            AppCompatDelegate.setDefaultNightMode(mDayNightMode)
            delegate.applyDayNight()
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

        val crocodileAnimY = ObjectAnimator.ofFloat(crocodileLayout, View.TRANSLATION_Y, -100f, 0f)
        val crocodileAnimFade = ObjectAnimator.ofFloat(crocodileLayout, View.ALPHA, 0f, 1f)
        crocodileAnimY.duration = 200
        crocodileAnimFade.duration = 200
        val animSetCrocodile = AnimatorSet()
        animSetCrocodile.playTogether(crocodileAnimY, crocodileAnimFade)

        val aliasAnimY = ObjectAnimator.ofFloat(aliasLayout, View.TRANSLATION_Y, -100f, 0f)
        val aliasAnimFade = ObjectAnimator.ofFloat(aliasLayout, View.ALPHA, 0f, 1f)
        aliasAnimY.duration = 200
        aliasAnimFade.duration = 200
        val animSetAlias = AnimatorSet()
        animSetAlias.playTogether(aliasAnimY, aliasAnimFade)
        animSetAlias.doOnEnd {
            animSetCrocodile.start()
            crocodileLayout.visibility = View.VISIBLE
        }

        val boomAnimY = ObjectAnimator.ofFloat(boomLayout, View.TRANSLATION_Y, -100f, 0f)
        val boomAnimFade = ObjectAnimator.ofFloat(boomLayout, View.ALPHA, 0f, 1f)
        boomAnimY.duration = 200
        boomAnimFade.duration = 200
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
