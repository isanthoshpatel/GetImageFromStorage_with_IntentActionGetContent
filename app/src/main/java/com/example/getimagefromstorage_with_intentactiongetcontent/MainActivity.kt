package com.example.getimagefromstorage_with_intentactiongetcontent

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {

            uri = data!!.data

            iv_1.setImageURI(uri)
        }
    }


}
