package com.example.sandymeliyawan


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.sandymeliyawan.model.Note

class NoteAdapter(
    private val listItems: ArrayList<Note>,
    private val listener: NoteListener
): RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    class NoteViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var textViewNPM = itemView.findViewById<TextView>(R.id.text_view_npm)
        var textViewNama = itemView.findViewById<TextView>(R.id.text_view_nama)
        var textViewNilai = itemView.findViewById<TextView>(R.id.text_view_nilai)
        var textViewKeterangan = itemView.findViewById<TextView>(R.id.text_view_keterangan)
        var textViewJumlahSKS = itemView.findViewById<TextView>(R.id.text_view_jumlahsks)
        var textViewHargaSKS = itemView.findViewById<TextView>(R.id.text_view_hargasks)
        var textViewTotal = itemView.findViewById<TextView>(R.id.text_view_total)

    }

    interface NoteListener{
        fun OnItemClicked(note: Note)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteAdapter.NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent,false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteAdapter.NoteViewHolder, position: Int) {
        val item = listItems[position]
        holder.textViewNPM.text = "NPM : ${item.npm}"
        holder.textViewNama.text = "Nama : ${item.nama}"
        holder.textViewNilai.text = "Nilai : ${item.nilai}"
        holder.textViewKeterangan.text = "Ketarangan : ${item.keterangan}"
        holder.textViewJumlahSKS.text = "Jumlah SKS : ${item.jumlahsks}"
        holder.textViewHargaSKS.text = "Harga SKS : ${item.hargasks}"

        val jumlahsks = item.jumlahsks.toDoubleOrNull() ?: 0.0

        val hargasks = item.hargasks.toDoubleOrNull() ?: 0.0
        val result = jumlahsks * hargasks

        holder.textViewTotal.text = "Total: Rp. $result"

        holder.itemView.setOnClickListener {
            listener.OnItemClicked(item)
        }
    }

    override fun getItemCount(): Int {
        return listItems.size
    }
}