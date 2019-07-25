package com.guilherme.arsampleapplication.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.guilherme.arsampleapplication.components.SpacesItemDecoration
import com.guilherme.arsampleapplication.databinding.FragmentObjectsBinding
import com.guilherme.arsampleapplication.models.ObjAR
import com.guilherme.arsampleapplication.viewmodels.ObjectsARViewModel
import com.guilherme.arsampleapplication.views.adapters.ObjARAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class ObjARFragment : Fragment() {
    private val objectsViewModel: ObjectsARViewModel by viewModel()

    companion object {
        fun newInstance(): ObjARFragment {
            return ObjARFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentObjectsBinding = FragmentObjectsBinding.inflate(inflater, container, false)

        binding.viewModel = objectsViewModel
        binding.lifecycleOwner = this

        binding.rvObjects.layoutManager = GridLayoutManager(activity, 2)
        binding.rvObjects.addItemDecoration(SpacesItemDecoration(2, 40))

        objectsViewModel.objAR.observe(this,
            Observer { response ->
                binding.rvObjects.adapter = ObjARAdapter(response as ArrayList<ObjAR>)
            }
        )

        objectsViewModel.listObjects()

        return binding.root
    }
}