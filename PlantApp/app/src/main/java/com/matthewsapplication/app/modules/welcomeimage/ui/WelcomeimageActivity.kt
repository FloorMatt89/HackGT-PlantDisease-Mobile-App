package com.matthewsapplication.app.modules.welcomeimage.ui

import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import com.matthewsapplication.app.R
import com.matthewsapplication.app.appcomponents.base.BaseActivity
import com.matthewsapplication.app.databinding.ActivityWelcomeimageBinding
import com.matthewsapplication.app.modules.missionstatement.ui.MissionstatementActivity
import com.matthewsapplication.app.modules.welcomeimage.`data`.viewmodel.WelcomeimageVM
import kotlin.String
import kotlin.Unit

class WelcomeimageActivity :
    BaseActivity<ActivityWelcomeimageBinding>(R.layout.activity_welcomeimage) {
  private val viewModel: WelcomeimageVM by viewModels<WelcomeimageVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.welcomeimageVM = viewModel
    Handler(Looper.getMainLooper()).postDelayed( {
      val destIntent = MissionstatementActivity.getIntent(this, null)
      startActivity(destIntent)
      finish()
      }, 3000)
    }

    override fun setUpClicks(): Unit {
      binding.btnNext.setOnClickListener {
        val destIntent = MissionstatementActivity.getIntent(this, null)
        startActivity(destIntent)
      }
    }

    companion object {
      const val TAG: String = "WELCOMEIMAGE_ACTIVITY"

    }
  }
