package com.aguilar.appuns

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class CapacitacionesAdapter(private val temas: List<String>, private val onClick: (String) -> Unit) :
    RecyclerView.Adapter<CapacitacionesAdapter.TemaViewHolder>() {

    class TemaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.tvTema)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TemaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_capacitacion, parent, false)
        return TemaViewHolder(view)
    }

    override fun onBindViewHolder(holder: TemaViewHolder, position: Int) {
        val tema = temas[position]
        holder.textView.text = tema

        holder.itemView.setOnClickListener {
            onClick(tema) // Llama al callback cuando se hace clic en el item
        }
    }

    override fun getItemCount(): Int = temas.size
}
