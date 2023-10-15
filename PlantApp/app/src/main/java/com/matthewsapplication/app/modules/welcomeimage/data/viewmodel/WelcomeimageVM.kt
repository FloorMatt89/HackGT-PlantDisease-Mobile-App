package com.matthewsapplication.app.modules.welcomeimage.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.matthewsapplication.app.modules.welcomeimage.`data`.model.WelcomeimageModel
import org.koin.core.KoinComponent

class WelcomeimageVM : ViewModel(), KoinComponent {
  val welcomeimageModel: MutableLiveData<WelcomeimageModel> = MutableLiveData(WelcomeimageModel())

  var navArguments: Bundle? = null
}
