package com.aguilar.appuns

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.aguilar.appuns.databinding.FragmentBecasBinding

class BecasFragment : Fragment() {

    private var _binding: FragmentBecasBinding? = null
    private val binding get() = _binding!!

    private lateinit var becasAdapter: BecasAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBecasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configurar el RecyclerView
        becasAdapter = BecasAdapter(obtenerBecas())
        binding.recyclerViewBecas.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = becasAdapter
            // No es necesario establecer visibility aquí, ya que el ScrollView lo maneja
        }
    }

    // Usando la lista de becas que ya tienes
    private fun obtenerBecas(): List<Beca> {
        return listOf(
            Beca("Beca Nacional de Excelencia", "Beca para estudiantes destacados del país.", R.drawable.beca1),
            Beca("Beca de Desarrollo Social", "Apoyo para estudiantes de áreas rurales.", R.drawable.beca2),
            Beca("Beca de Investigación", "Financiamiento para proyectos de investigación.", R.drawable.beca3)
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
