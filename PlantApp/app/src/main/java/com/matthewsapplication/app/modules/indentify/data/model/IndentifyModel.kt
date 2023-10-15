package com.matthewsapplication.app.modules.indentify.`data`.model

import com.matthewsapplication.app.R
import com.matthewsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class IndentifyModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtIndentifyTextHe: String? = MyApp.getInstance().resources.getString(R.string.lbl_identify)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtIdentifyTextPar: String? =
      MyApp.getInstance().resources.getString(R.string.msg_identify_the_pl)

)
