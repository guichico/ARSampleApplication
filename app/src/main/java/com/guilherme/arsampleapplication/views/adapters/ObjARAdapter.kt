package com.guilherme.arsampleapplication.views.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.guilherme.arsampleapplication.databinding.RowObjarBinding
import com.guilherme.arsampleapplication.models.ObjAR
import com.guilherme.arsampleapplication.views.ObjARActivity
import com.squareup.picasso.Picasso

class ObjARAdapter(var items: List<ObjAR>) : RecyclerView.Adapter<ObjARAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: RowObjarBinding = RowObjarBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class ViewHolder(private val binding: RowObjarBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(objAR: ObjAR) {
            Picasso.get()
                .load(objAR.images[0])
                .into(binding.imgObjAR)

            binding.root.setOnClickListener {
                val context = binding.root.context

                val intent = Intent(context, ObjARActivity::class.java)
                intent.putExtra("objAR", objAR)

                context.startActivity(intent)
            }

            binding.objAR = objAR
            binding.executePendingBindings()
        }
    }
}