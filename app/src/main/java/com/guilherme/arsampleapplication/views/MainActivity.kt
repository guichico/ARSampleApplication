package com.guilherme.arsampleapplication.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.guilherme.arsampleapplication.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(
            R.id.content_frame,
            ObjARFragment.newInstance()
        ).commit()
    }
}
