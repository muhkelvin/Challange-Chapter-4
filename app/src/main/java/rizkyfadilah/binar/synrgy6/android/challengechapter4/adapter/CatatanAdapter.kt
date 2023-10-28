package rizkyfadilah.binar.synrgy6.android.challengechapter4.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import rizkyfadilah.binar.synrgy6.android.challengechapter4.model.CatatanEntity
import rizkyfadilah.binar.synrgy6.android.challengechapter4.databinding.ItemCrudBinding
class CatatanAdapter(private var catatanList: List<CatatanEntity>) :
    RecyclerView.Adapter<CatatanAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCrudBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val catatan = catatanList[position]
        holder.bind(catatan)
    }

    override fun getItemCount(): Int {
        return catatanList.size
    }

    fun setData(catatanList: List<CatatanEntity>) {
        this.catatanList = catatanList
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemCrudBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(catatan: CatatanEntity) {
//            binding.tvTitle.text = catatan.title
        }
    }
}

