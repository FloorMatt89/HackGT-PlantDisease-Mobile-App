package com.matthewsapplication.app.modules.missionstatement.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.matthewsapplication.app.R
import com.matthewsapplication.app.appcomponents.base.BaseActivity
import com.matthewsapplication.app.databinding.ActivityMissionstatementBinding
import com.matthewsapplication.app.modules.indentify.ui.IndentifyActivity
import com.matthewsapplication.app.modules.missionstatement.`data`.viewmodel.MissionstatementVM
import kotlin.String
import kotlin.Unit

class MissionstatementActivity :
    BaseActivity<ActivityMissionstatementBinding>(R.layout.activity_missionstatement) {
  private val viewModel: MissionstatementVM by viewModels<MissionstatementVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.missionstatementVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnNext.setOnClickListener {
      val destIntent = IndentifyActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "MISSIONSTATEMENT_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, MissionstatementActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
