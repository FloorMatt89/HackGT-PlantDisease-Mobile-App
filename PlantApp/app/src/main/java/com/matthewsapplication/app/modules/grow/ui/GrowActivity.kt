package com.matthewsapplication.app.modules.grow.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.matthewsapplication.app.R
import com.matthewsapplication.app.appcomponents.base.BaseActivity
import com.matthewsapplication.app.databinding.ActivityGrowBinding
import com.matthewsapplication.app.modules.grow.`data`.viewmodel.GrowVM
import com.matthewsapplication.app.modules.mainmenu.ui.MainmenuActivity
import kotlin.String
import kotlin.Unit

class GrowActivity : BaseActivity<ActivityGrowBinding>(R.layout.activity_grow) {
  private val viewModel: GrowVM by viewModels<GrowVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.growVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnContinueToMainMenu.setOnClickListener {
      val destIntent = MainmenuActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "GROW_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, GrowActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
