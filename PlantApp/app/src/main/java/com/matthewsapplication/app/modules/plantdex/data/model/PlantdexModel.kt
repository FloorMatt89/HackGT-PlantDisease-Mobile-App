package com.matthewsapplication.app.modules.plantdex.`data`.model

import com.matthewsapplication.app.R
import com.matthewsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class PlantdexModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtGardenText: String? = MyApp.getInstance().resources.getString(R.string.lbl_your_garden)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDescriptionText: String? =
      MyApp.getInstance().resources.getString(R.string.msg_when_you_scan_y)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPlantCollection: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_your_plants)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPlantHealth: String? = MyApp.getInstance().resources.getString(R.string.lbl_health_status)

)
