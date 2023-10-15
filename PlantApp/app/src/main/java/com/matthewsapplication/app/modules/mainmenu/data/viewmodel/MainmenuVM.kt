package com.matthewsapplication.app.modules.mainmenu.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.matthewsapplication.app.modules.mainmenu.`data`.model.MainmenuModel
import org.koin.core.KoinComponent

class MainmenuVM : ViewModel(), KoinComponent {
  val mainmenuModel: MutableLiveData<MainmenuModel> = MutableLiveData(MainmenuModel())

  var navArguments: Bundle? = null
}
