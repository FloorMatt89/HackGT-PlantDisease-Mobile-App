package com.matthewsapplication.app.modules.plantdex.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.matthewsapplication.app.modules.plantdex.`data`.model.PlantdexModel
import org.koin.core.KoinComponent

class PlantdexVM : ViewModel(), KoinComponent {
  val plantdexModel: MutableLiveData<PlantdexModel> = MutableLiveData(PlantdexModel())

  var navArguments: Bundle? = null
}
