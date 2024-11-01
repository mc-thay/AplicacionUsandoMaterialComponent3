package com.aguilar.appuns

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aguilar.appuns.databinding.ItemBecaCardBinding

class BecasAdapter(private val becas: List<Beca>) : RecyclerView.Adapter<BecasAdapter.BecasViewHolder>() {

    class BecasViewHolder(private val binding: ItemBecaCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(beca: Beca) {
            binding.nombreBeca.text = beca.nombre
            binding.descripcionBeca.text = beca.descripcion
            binding.imagenBeca.setImageResource(beca.imagenResId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BecasViewHolder {
        val binding = ItemBecaCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BecasViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BecasViewHolder, position: Int) {
        holder.bind(becas[position])
    }

    override fun getItemCount(): Int {
        return becas.size
    }
}
