package com.matthewsapplication.app.modules.welcomeimage.`data`.model

import com.matthewsapplication.app.R
import com.matthewsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class WelcomeimageModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtLogoText: String? = MyApp.getInstance().resources.getString(R.string.lbl_lant_md)

)
