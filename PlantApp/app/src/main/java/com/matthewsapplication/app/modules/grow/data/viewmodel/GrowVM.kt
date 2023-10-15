package com.matthewsapplication.app.modules.grow.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.matthewsapplication.app.modules.grow.`data`.model.GrowModel
import org.koin.core.KoinComponent

class GrowVM : ViewModel(), KoinComponent {
  val growModel: MutableLiveData<GrowModel> = MutableLiveData(GrowModel())

  var navArguments: Bundle? = null
}
