package com.matthewsapplication.app.modules.learn.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.matthewsapplication.app.modules.learn.`data`.model.LearnModel
import org.koin.core.KoinComponent

class LearnVM : ViewModel(), KoinComponent {
  val learnModel: MutableLiveData<LearnModel> = MutableLiveData(LearnModel())

  var navArguments: Bundle? = null
}
