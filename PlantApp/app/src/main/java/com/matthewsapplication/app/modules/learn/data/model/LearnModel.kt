package com.matthewsapplication.app.modules.learn.`data`.model

import com.matthewsapplication.app.R
import com.matthewsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class LearnModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtLearnTextHead: String? = MyApp.getInstance().resources.getString(R.string.lbl_learn)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLearnTextPara: String? =
      MyApp.getInstance().resources.getString(R.string.msg_learn_about_the)

)
