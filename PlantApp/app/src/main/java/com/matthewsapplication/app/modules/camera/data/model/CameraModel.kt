package com.matthewsapplication.app.modules.camera.`data`.model

import com.matthewsapplication.app.R
import com.matthewsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class CameraModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtCameraButton: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_return_to_menu)

)
