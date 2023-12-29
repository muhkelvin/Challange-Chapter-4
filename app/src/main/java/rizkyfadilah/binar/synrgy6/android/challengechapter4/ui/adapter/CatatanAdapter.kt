package rizkyfadilah.binar.synrgy6.android.challengechapter4.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import rizkyfadilah.binar.synrgy6.android.challengechapter4.data.model.CatatanEntity
import rizkyfadilah.binar.synrgy6.android.challengechapter4.data.viewmodel.CatatanViewModel
import rizkyfadilah.binar.synrgy6.android.challengechapter4.databinding.DeleteDialogBinding
import rizkyfadilah.binar.synrgy6.android.challengechapter4.databinding.ItemListBinding
import rizkyfadilah.binar.synrgy6.android.challengechapter4.databinding.UpdateDialogBinding

class CatatanAdapter(private val dataList: List<CatatanEntity>) :
    RecyclerView.Adapter<CatatanAdapter.CatatanViewHolder>() {

    inner class CatatanViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(catatan: CatatanEntity) {
            binding.textItem.text = catatan.title
            binding.btnUpdate.setOnClickListener {
                // Membuat tampilan custom untuk dialog menggunakan View Binding
                val dialogBinding =
                    UpdateDialogBinding.inflate(LayoutInflater.from(binding.root.context))

                // Inisialisasi elemen-elemen di dalam dialog
                val editTextUpdate = dialogBinding.editTextUpdate
                val btnUpdateDialog = dialogBinding.btnUpdate

                // Mengatur teks EditText sesuai dengan data saat ini
                editTextUpdate.setText(catatan.title)

                // Membuat dialog
                val builder = AlertDialog.Builder(binding.root.context)
                builder.setView(dialogBinding.root)
                val dialog = builder.create()

                // Menangani klik tombol "Update" di dalam dialog
                btnUpdateDialog.setOnClickListener {
                    // Lakukan sesuatu dengan nilai yang diubah
                    val updatedText = editTextUpdate.text.toString()
                    // Lakukan aksi update atau tampilkan pesan, sesuai dengan kebutuhan
                    Toast.makeText(
                        binding.root.context,
                        "Data diupdate menjadi: $updatedText",
                        Toast.LENGTH_SHORT
                    ).show()
                    // Tutup dialog
                    dialog.dismiss()
                }

                // Menampilkan dialog
                dialog.show()
            }
            binding.btnDelete.setOnClickListener {
                // Membuat tampilan custom untuk dialog menggunakan View Binding
                val dialogBinding = DeleteDialogBinding.inflate(LayoutInflater.from(binding.root.context))

                // Inisialisasi elemen-elemen di dalam dialog
                val btnNo = dialogBinding.btnNo
                val btnYes = dialogBinding.btnYes

                // Membuat dialog
                val builder = AlertDialog.Builder(binding.root.context)
                builder.setView(dialogBinding.root)
                val dialog = builder.create()

                // Menangani klik tombol "Tidak" di dalam dialog
                btnNo.setOnClickListener {
                    // Lakukan sesuatu jika tombol "Tidak" diklik
                    // Misalnya, tutup dialog
                    dialog.dismiss()
                }

                // Menangani klik tombol "Ya" di dalam dialog
                btnYes.setOnClickListener {
                    // Mendapatkan ID catatan yang akan dihapus
                    val catatanId = catatan.id

                    // Mendapatkan instance CatatanViewModel
                    val catatanViewModel: CatatanViewModel = ViewModelProvider(binding.root.context as FragmentActivity).get(CatatanViewModel::class.java)

                    // Memanggil metode deleteCatatan di ViewModel
                    catatanViewModel.deleteCatatanById(catatanId)

                    // Tampilkan pesan sukses
                    Toast.makeText(binding.root.context, "Data berhasil dihapus", Toast.LENGTH_SHORT).show()

                    dialog.dismiss()
                }

                // Menampilkan dialog
                dialog.show()
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatatanViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListBinding.inflate(inflater, parent, false)
        return CatatanViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CatatanViewHolder, position: Int) {
        val catatan = dataList[position]
        holder.bind(catatan)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}
