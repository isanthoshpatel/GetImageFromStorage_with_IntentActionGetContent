package com.example.getimagefromstorage_with_intentactiongetcontent

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import androidx.annotation.RequiresApi
import androidx.core.graphics.drawable.toDrawable
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.lang.Exception
import java.util.*

class MainActivity : AppCompatActivity() {
    var uri: Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_getContent.setOnClickListener {
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type = "*/*"
                startActivityForResult(it, 1)
            }
        }

    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            var uri = data!!.data!!

            if (uri.toString().toLowerCase().contains("image")) {
                videoview.setVideoURI(null)
                iv.setImageURI(uri)
            } else {
                iv.setImageURI(null)
                videoview.setBackgroundColor(Color.TRANSPARENT)
                videoview.setVideoURI(uri)
                var mediaController = MediaController(this)
                videoview.setMediaController(mediaController)
                mediaController.setAnchorView(videoview)
                mediaController.isPressed=true
            }
        }


    }

}
