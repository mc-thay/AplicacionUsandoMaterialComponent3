import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.aguilar.appuns.Concurso
import com.aguilar.appuns.R

class ConcursosAdapter(
    private val concursos: List<Concurso>,
    private val onClick: (Concurso) -> Unit
) : RecyclerView.Adapter<ConcursosAdapter.ConcursoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConcursoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_concurso, parent, false)
        return ConcursoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ConcursoViewHolder, position: Int) {
        val concurso = concursos[position]
        holder.bind(concurso)
        holder.itemView.setOnClickListener { onClick(concurso) }
    }

    override fun getItemCount(): Int {
        return concursos.size
    }

    inner class ConcursoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.tvConcursoTitle)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.tvConcursoDescription)
        private val dateTextView: TextView = itemView.findViewById(R.id.tvConcursoDate)

        fun bind(concurso: Concurso) {
            titleTextView.text = concurso.titulo
            descriptionTextView.text = concurso.descripcion
            dateTextView.text = concurso.fecha
        }
    }
}
