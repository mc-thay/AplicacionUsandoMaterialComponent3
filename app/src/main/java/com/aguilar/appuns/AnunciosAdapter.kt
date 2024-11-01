package com.aguilar.appuns

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AnunciosAdapter(private val anuncios: List<Anuncio>, private val onClick: (Anuncio) -> Unit) :
    RecyclerView.Adapter<AnunciosAdapter.AnuncioViewHolder>() {

    class AnuncioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titulo: TextView = itemView.findViewById(R.id.tvTituloAnuncio)
        val descripcion: TextView = itemView.findViewById(R.id.tvDescripcionAnuncio)
        val fecha: TextView = itemView.findViewById(R.id.tvFechaAnuncio)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnuncioViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_anuncio, parent, false)
        return AnuncioViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnuncioViewHolder, position: Int) {
        val anuncio = anuncios[position]
        holder.titulo.text = anuncio.titulo
        holder.descripcion.text = anuncio.descripcion
        holder.fecha.text = anuncio.fecha

        holder.itemView.setOnClickListener {
            onClick(anuncio)
        }
    }

    override fun getItemCount(): Int = anuncios.size
}
