package com.matthewsapplication.app.modules.indentify.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.matthewsapplication.app.R
import com.matthewsapplication.app.appcomponents.base.BaseActivity
import com.matthewsapplication.app.databinding.ActivityIndentifyBinding
import com.matthewsapplication.app.modules.indentify.`data`.viewmodel.IndentifyVM
import com.matthewsapplication.app.modules.learn.ui.LearnActivity
import kotlin.String
import kotlin.Unit

class IndentifyActivity : BaseActivity<ActivityIndentifyBinding>(R.layout.activity_indentify) {
  private val viewModel: IndentifyVM by viewModels<IndentifyVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.indentifyVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnNext.setOnClickListener {
      val destIntent = LearnActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "INDENTIFY_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, IndentifyActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
