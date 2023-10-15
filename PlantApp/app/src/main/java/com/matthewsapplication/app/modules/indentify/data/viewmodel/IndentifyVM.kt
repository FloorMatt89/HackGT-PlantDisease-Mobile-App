package com.matthewsapplication.app.modules.indentify.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.matthewsapplication.app.modules.indentify.`data`.model.IndentifyModel
import org.koin.core.KoinComponent

class IndentifyVM : ViewModel(), KoinComponent {
  val indentifyModel: MutableLiveData<IndentifyModel> = MutableLiveData(IndentifyModel())

  var navArguments: Bundle? = null
}
