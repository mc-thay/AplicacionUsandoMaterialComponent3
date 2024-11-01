package com.aguilar.appuns

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.aguilar.appuns.databinding.FragmentAnunciosBinding
import com.aguilar.appuns.databinding.FragmentBecasBinding
import com.aguilar.appuns.databinding.FragmentConcursosBinding

class AnunciosFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AnunciosAdapter
    private lateinit var anuncios: List<Anuncio>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_anuncios, container, false)

        // Inicializa la lista de anuncios (deberías cargar esto de tu fuente de datos)
        anuncios = listOf(
            Anuncio("Convocatoria de Becas", "Abiertas las inscripciones para becas 2024.", "01/11/2024"),
            Anuncio("Taller de Programación", "Participa en nuestro taller gratuito de programación.", "02/11/2024"),
            Anuncio("Charla sobre Innovación", "No te pierdas la charla sobre innovación tecnológica.", "03/11/2024"),
            Anuncio("Concurso de Proyectos", "Inscríbete en el concurso de proyectos estudiantiles.", "04/11/2024"),
            Anuncio("Feria de Empleo", "Ven a nuestra feria de empleo el próximo viernes.", "05/11/2024"),
            Anuncio("Curso de Inglés", "Inscríbete en el curso de inglés para estudiantes.", "06/11/2024"),
            Anuncio("Evento Cultural", "Asiste al evento cultural este sábado en el auditorio.", "07/11/2024")
        )

        // Configura el RecyclerView
        recyclerView = view.findViewById(R.id.recyclerViewAnuncios)
        recyclerView.layoutManager = LinearLayoutManager(context)

        adapter = AnunciosAdapter(anuncios) { anuncio ->
            // Aquí puedes manejar el clic en el anuncio
            Toast.makeText(context, "Seleccionaste: ${anuncio.titulo}", Toast.LENGTH_SHORT).show()
        }

        recyclerView.adapter = adapter

        // Configura el botón de contacto con DEDA
        view.findViewById<Button>(R.id.btnContactDEDA).setOnClickListener {
            // Maneja la acción de contacto con DEDA
            Toast.makeText(context, "Contactando a DEDA...", Toast.LENGTH_SHORT).show()
            // Aquí puedes lanzar un intent para enviar un correo o abrir un chat, etc.
        }

        return view
    }
}

// Modelo de datos para el anuncio
data class Anuncio(val titulo: String, val descripcion: String, val fecha: String)
