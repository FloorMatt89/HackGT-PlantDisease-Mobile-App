package com.matthewsapplication.app.modules.mainmenu.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.matthewsapplication.app.R
import com.matthewsapplication.app.appcomponents.base.BaseActivity
import com.matthewsapplication.app.databinding.ActivityMainmenuBinding
import com.matthewsapplication.app.modules.camera.ui.CameraActivity
import com.matthewsapplication.app.modules.mainmenu.`data`.viewmodel.MainmenuVM
import com.matthewsapplication.app.modules.plantdex.ui.PlantdexActivity
import kotlin.String
import kotlin.Unit

class MainmenuActivity : BaseActivity<ActivityMainmenuBinding>(R.layout.activity_mainmenu) {
  private val viewModel: MainmenuVM by viewModels<MainmenuVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.mainmenuVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnYourGarden.setOnClickListener {
      val destIntent = PlantdexActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.txtLanguage.setOnClickListener {
      val destIntent = CameraActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearDiseaseButton.setOnClickListener {
      val destIntent = CameraActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "MAINMENU_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, MainmenuActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
