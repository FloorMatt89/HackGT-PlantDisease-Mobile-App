package com.matthewsapplication.app.modules.missionstatement.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.matthewsapplication.app.modules.missionstatement.`data`.model.MissionstatementModel
import org.koin.core.KoinComponent

class MissionstatementVM : ViewModel(), KoinComponent {
  val missionstatementModel: MutableLiveData<MissionstatementModel> =
      MutableLiveData(MissionstatementModel())

  var navArguments: Bundle? = null
}
