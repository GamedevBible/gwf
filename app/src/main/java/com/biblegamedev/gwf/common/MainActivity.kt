package com.biblegamedev.gwf.common

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.animation.doOnEnd
import com.biblegamedev.gwf.R
import com.biblegamedev.gwf.common.settings.SettingsActivity
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("ConstantConditionIf")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        settingsClickLayout.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()

        if (Config.buttonsAnimationEnabled) {
            animateButtonsIn()
        }
    }

    private fun animateButtonsIn() {

        boomLayout.visibility = View.INVISIBLE
        crocodileLayout.visibility = View.INVISIBLE
        aliasLayout.visibility = View.INVISIBLE
        settingsLayout.visibility = View.INVISIBLE

        val settingsAnimY = ObjectAnimator.ofFloat(settingsLayout, View.TRANSLATION_Y, -100f, 0f).apply { duration = Config.mainActivityButtonsInAnimDuration }
        val settingsAnimFade = ObjectAnimator.ofFloat(settingsLayout, View.ALPHA, 0f, 1f).apply { duration = Config.mainActivityButtonsInAnimDuration }
        val animSetSettings = AnimatorSet()
        animSetSettings.playTogether(settingsAnimY, settingsAnimFade)

        val crocodileAnimY = ObjectAnimator.ofFloat(crocodileLayout, View.TRANSLATION_Y, -100f, 0f).apply { duration = Config.mainActivityButtonsInAnimDuration }
        val crocodileAnimFade = ObjectAnimator.ofFloat(crocodileLayout, View.ALPHA, 0f, 1f).apply { duration = Config.mainActivityButtonsInAnimDuration }
        val animSetCrocodile = AnimatorSet()
        animSetCrocodile.playTogether(crocodileAnimY, crocodileAnimFade)
        animSetCrocodile.doOnEnd {
            animSetSettings.start()
            settingsLayout.visibility = View.VISIBLE
        }

        val aliasAnimY = ObjectAnimator.ofFloat(aliasLayout, View.TRANSLATION_Y, -100f, 0f).apply { duration = Config.mainActivityButtonsInAnimDuration }
        val aliasAnimFade = ObjectAnimator.ofFloat(aliasLayout, View.ALPHA, 0f, 1f).apply { duration = Config.mainActivityButtonsInAnimDuration }
        val animSetAlias = AnimatorSet()
        animSetAlias.playTogether(aliasAnimY, aliasAnimFade)
        animSetAlias.doOnEnd {
            animSetCrocodile.start()
            crocodileLayout.visibility = View.VISIBLE
        }

        val boomAnimY = ObjectAnimator.ofFloat(boomLayout, View.TRANSLATION_Y, -100f, 0f).apply { duration = Config.mainActivityButtonsInAnimDuration }
        val boomAnimFade = ObjectAnimator.ofFloat(boomLayout, View.ALPHA, 0f, 1f).apply { duration = Config.mainActivityButtonsInAnimDuration }
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
