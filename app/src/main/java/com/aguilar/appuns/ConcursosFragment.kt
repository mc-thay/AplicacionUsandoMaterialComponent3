package com.aguilar.appuns

import ConcursosAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.aguilar.appuns.databinding.FragmentCapacitacionesBinding
import com.aguilar.appuns.databinding.FragmentConcursosBinding
import androidx.recyclerview.widget.RecyclerView

class ConcursosFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ConcursosAdapter
    private lateinit var concursos: List<Concurso>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_concursos, container, false)

        // Inicializa la lista de concursos (deberías cargar esto de tu fuente de datos)
        concursos = listOf(
            Concurso("Concurso de Innovación", "Presenta tu proyecto innovador y gana premios.", "09/11/2024"),
            Concurso("Hackathon 2024", "Participa en nuestra Hackathon y demuestra tus habilidades.", "10/11/2024"),
            Concurso("Certamen Literario", "Envía tu relato y compite por un gran premio.", "11/11/2024"),
            Concurso("Concurso de Fotografía", "Muestra tu talento fotográfico y gana.", "12/11/2024"),
            Concurso("Desafío Emprendedor", "Comparte tu idea de negocio y gana financiamiento.", "13/11/2024"),
            Concurso("Competencia de Programación", "Demuestra tus habilidades de programación.", "14/11/2024"),
            Concurso("Torneo Deportivo Universitario", "Inscríbete en el torneo de deportes de la universidad.", "15/11/2024")
        )

        // Configura el RecyclerView
        recyclerView = view.findViewById(R.id.recyclerViewConcursos)
        recyclerView.layoutManager = LinearLayoutManager(context)

        adapter = ConcursosAdapter(concursos) { concurso ->
            // Aquí puedes manejar el clic en el concurso
            Toast.makeText(context, "Seleccionaste: ${concurso.titulo}", Toast.LENGTH_SHORT).show()
        }

        recyclerView.adapter = adapter

        // Configura el botón de más información
        view.findViewById<Button>(R.id.btnMoreInfo).setOnClickListener {
            // Maneja la acción para más información sobre los concursos
            Toast.makeText(context, "Buscando más información...", Toast.LENGTH_SHORT).show()
            // Aquí puedes lanzar un intent para abrir un enlace o mostrar un diálogo, etc.
        }

        return view
    }
}

// Modelo de datos para el concurso
data class Concurso(val titulo: String, val descripcion: String, val fecha: String)
