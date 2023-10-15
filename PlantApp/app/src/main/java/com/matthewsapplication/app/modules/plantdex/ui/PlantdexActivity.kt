package com.matthewsapplication.app.modules.plantdex.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.matthewsapplication.app.R
import com.matthewsapplication.app.appcomponents.base.BaseActivity
import com.matthewsapplication.app.databinding.ActivityPlantdexBinding
import com.matthewsapplication.app.modules.mainmenu.ui.MainmenuActivity
import com.matthewsapplication.app.modules.plantdex.`data`.viewmodel.PlantdexVM
import kotlin.String
import kotlin.Unit

class PlantdexActivity : BaseActivity<ActivityPlantdexBinding>(R.layout.activity_plantdex) {
  private val viewModel: PlantdexVM by viewModels<PlantdexVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.plantdexVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnReturnToMenu.setOnClickListener {
      val destIntent = MainmenuActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "PLANTDEX_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, PlantdexActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
