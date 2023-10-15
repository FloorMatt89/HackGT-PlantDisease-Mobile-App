package com.matthewsapplication.app.modules.camera.ui

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap // Import the Bitmap class
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.viewModels
import android.widget.Button
import java.io.FileOutputStream
import java.io.IOException
import com.matthewsapplication.app.R
import com.matthewsapplication.app.appcomponents.base.BaseActivity
import com.matthewsapplication.app.databinding.ActivityCameraBinding
import com.matthewsapplication.app.modules.camera.data.viewmodel.CameraVM
import com.matthewsapplication.app.modules.mainmenu.ui.MainmenuActivity
import java.io.File

class CameraActivity : BaseActivity<ActivityCameraBinding>(R.layout.activity_camera) {
  private val viewModel: CameraVM by this.viewModels<CameraVM>()

  private val REQUEST_CODE = 22 // Replaced the static constant with a property
  fun saveBitmapAsJPEG(bitmap: Bitmap, filePath: String){
    val file = File(filePath)
    try{
      val stream = FileOutputStream(file)
      bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream)
      stream.flush()
      stream.close()
    }catch(e:IOException){
      e.printStackTrace()
    }
  }
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




// ...

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    if (requestCode == REQUEST_CODE && resultCode == android.app.Activity.RESULT_OK) {
      val photo = data?.extras?.get("data") as? Bitmap
      binding.imageview1.setImageBitmap(photo)

      // Get the external storage directory
      val externalStorageDirectory = Environment.getExternalStorageDirectory()

      // Create a relative path within the external storage directory
      val relativePath = "/Users/matthewsegura/Downloads/output" // Replace with your desired directory name
      val myDir = File(externalStorageDirectory, relativePath)
      myDir.mkdirs()

      // Create a file for the image
      val file = File(myDir, "photo.jpg")

      try {
        val stream = FileOutputStream(file)
        photo?.compress(Bitmap.CompressFormat.JPEG, 100, stream)
        stream.flush()
        stream.close()

        val successMessage = "Image saved to ${file.absolutePath}"
        Toast.makeText(this, successMessage, Toast.LENGTH_SHORT).show()

        // Log the success message
        Log.d("CameraActivity", successMessage)
      } catch (e: IOException) {
        e.printStackTrace()
        val errorMessage = "Failed to save image"
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()

        // Log the error message
        Log.e("CameraActivity", errorMessage)
      }
    } else {
      val cancelledMessage = "Cancelled"
      Toast.makeText(this, cancelledMessage, Toast.LENGTH_SHORT).show()

      // Log the cancellation message
      Log.d("CameraActivity", cancelledMessage)

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
