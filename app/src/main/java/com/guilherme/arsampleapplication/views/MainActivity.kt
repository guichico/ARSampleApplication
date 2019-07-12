package com.guilherme.arsampleapplication.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
