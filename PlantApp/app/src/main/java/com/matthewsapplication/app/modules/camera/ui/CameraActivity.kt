package com.matthewsapplication.app.modules.camera.ui

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap // Import the Bitmap class
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.viewModels
import android.widget.Button
import com.matthewsapplication.app.R
import com.matthewsapplication.app.appcomponents.base.BaseActivity
import com.matthewsapplication.app.databinding.ActivityCameraBinding
import com.matthewsapplication.app.modules.camera.data.viewmodel.CameraVM
import com.matthewsapplication.app.modules.mainmenu.ui.MainmenuActivity

class CameraActivity : BaseActivity<ActivityCameraBinding>(R.layout.activity_camera) {
  private val viewModel: CameraVM by this.viewModels<CameraVM>()

  private val REQUEST_CODE = 22 // Replaced the static constant with a property

  override fun onInitialized() {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val cameraVM: CameraVM = viewModel
    val btnScanPlant: Button
    btnScanPlant = findViewById(R.id.btnScanPlant)

    val imageview1: ImageView = findViewById(R.id.imageview1)
  }

  override fun setUpClicks() {
    binding.txtCameraButton.setOnClickListener {
      val destIntent = MainmenuActivity.getIntent(this, null)
      startActivity(destIntent)
    }

    binding.btnScanPlant.setOnClickListener {
      val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
      startActivityForResult(cameraIntent, REQUEST_CODE)
    }
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    if (requestCode == REQUEST_CODE && resultCode == android.app.Activity.RESULT_OK) {
      val photo: Bitmap? = data?.extras?.get("data") as? Bitmap // Added a safe cast
      binding.imageview1.setImageBitmap(photo)
    } else {
      Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show()
      super.onActivityResult(requestCode, resultCode, data)
    }
  }

  companion object {
    const val TAG: String = "CAMERA_ACTIVITY"

    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, CameraActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
