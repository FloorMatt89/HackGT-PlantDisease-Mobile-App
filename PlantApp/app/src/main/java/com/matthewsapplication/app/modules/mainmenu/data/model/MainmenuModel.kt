package com.matthewsapplication.app.modules.mainmenu.`data`.model

import com.matthewsapplication.app.R
import com.matthewsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class MainmenuModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtLeafLogoText: String? = MyApp.getInstance().resources.getString(R.string.lbl_lant_md)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.msg_check_for_plant)

)
