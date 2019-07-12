package com.guilherme.arsampleapplication.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.guilherme.arsampleapplication.R
import com.guilherme.arsampleapplication.databinding.ActivityObjarBinding
import com.guilherme.arsampleapplication.models.ObjAR
import com.guilherme.arsampleapplication.viewmodels.ObjARViewModel
import com.guilherme.arsampleapplication.views.adapters.ViewPagerAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class ObjARActivity : AppCompatActivity() {

    private val objectARViewModel: ObjARViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityObjarBinding = DataBindingUtil.setContentView(this, R.layout.activity_objar);
        val objAR = intent.getSerializableExtra("objAR") as ObjAR

        binding.viewModel = objectARViewModel
        binding.objAR = objAR
        binding.lifecycleOwner = this

        binding.viewPager.adapter = ViewPagerAdapter(this, objAR.images)

        binding.btnTryObjAR.setOnClickListener {
            if (objectARViewModel.tryObjEnable.value!!)
                startActivity(Intent(this, ArActivity::class.java))
        }

        objectARViewModel.mayEnableArButton()

        binding.executePendingBindings()
    }
}