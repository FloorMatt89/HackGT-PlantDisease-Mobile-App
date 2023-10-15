package com.matthewsapplication.app.modules.learn.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.matthewsapplication.app.R
import com.matthewsapplication.app.appcomponents.base.BaseActivity
import com.matthewsapplication.app.databinding.ActivityLearnBinding
import com.matthewsapplication.app.modules.grow.ui.GrowActivity
import com.matthewsapplication.app.modules.learn.`data`.viewmodel.LearnVM
import kotlin.String
import kotlin.Unit

class LearnActivity : BaseActivity<ActivityLearnBinding>(R.layout.activity_learn) {
  private val viewModel: LearnVM by viewModels<LearnVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.learnVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnNext.setOnClickListener {
      val destIntent = GrowActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "LEARN_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, LearnActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
