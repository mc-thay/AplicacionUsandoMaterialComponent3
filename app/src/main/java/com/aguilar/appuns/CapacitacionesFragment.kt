package com.aguilar.appuns

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aguilar.appuns.databinding.FragmentCapacitacionesBinding
class CapacitacionesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CapacitacionesAdapter
    private lateinit var temas: List<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_capacitaciones, container, false)

        // Inicializa la lista de temas
        temas = listOf(
            "Introducción a la Programación en Java",
            "Desarrollo de Aplicaciones Móviles con Kotlin",
            "Diseño de Interfaces de Usuario",
            "Fundamentos de Bases de Datos",
            "Desarrollo Web con HTML, CSS y JavaScript",
            "Algoritmos y Estructuras de Datos",
            "Introducción a la Inteligencia Artificial",
            "Desarrollo de Software Ágil",
            "Fundamentos de Ciberseguridad",
            "Programación de Sistemas Embebidos",
            "Introducción al Desarrollo de Juegos",
            "Análisis de Datos con Python",
            "Gestión de Proyectos de Software",
            "Desarrollo de Aplicaciones en la Nube",
            "Introducción a la Ciencia de Datos"
        )

        // Configura el RecyclerView
        recyclerView = view.findViewById(R.id.recyclerViewCapacitaciones)
        recyclerView.layoutManager = LinearLayoutManager(context)

        adapter = CapacitacionesAdapter(temas) { tema ->
            // Aquí puedes manejar el clic en el item, como navegar a otro fragmento o actividad
            Toast.makeText(context, "Seleccionaste: $tema", Toast.LENGTH_SHORT).show()
            // Puedes usar un NavController para navegar a otro fragmento si lo deseas
            // val action = CapacitacionesFragmentDirections.actionCapacitacionesToDetalles(tema)
            // findNavController().navigate(action)
        }

        recyclerView.adapter = adapter

        return view
    }
}

