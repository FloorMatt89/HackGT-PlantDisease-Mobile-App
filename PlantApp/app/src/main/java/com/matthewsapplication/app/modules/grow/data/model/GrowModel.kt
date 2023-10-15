package com.matthewsapplication.app.modules.grow.`data`.model

import com.matthewsapplication.app.R
import com.matthewsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class GrowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtGrowTextHead: String? = MyApp.getInstance().resources.getString(R.string.lbl_grow)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGrowTextPara: String? =
      MyApp.getInstance().resources.getString(R.string.msg_grow_and_keep_t)

)
