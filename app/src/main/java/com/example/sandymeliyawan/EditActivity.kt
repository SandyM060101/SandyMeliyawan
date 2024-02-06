package com.example.sandymeliyawan


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.sandymeliyawan.databinding.ActivityEditBinding
import com.example.sandymeliyawan.db.NoteDao
import com.example.sandymeliyawan.db.NoteRoomDatabase
import com.example.sandymeliyawan.model.Note

@Suppress("DEPRECATION")
class EditActivity : AppCompatActivity() {

    val EDIT_NOTE_EXTRA = "edit_note_extra"
    private lateinit var note: Note
    private var isUpdate = false
    private lateinit var database: NoteRoomDatabase
    private lateinit var dao: NoteDao


    private lateinit var binding: ActivityEditBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        database = NoteRoomDatabase.getDatabase(applicationContext)
        dao = database.getNoteDao()


        if (intent.getParcelableExtra<Note>(EDIT_NOTE_EXTRA) != null) {
            binding.buttonDelete.visibility = View.VISIBLE
            isUpdate = true
            note = intent.getParcelableExtra(EDIT_NOTE_EXTRA)!!
            binding.editTextNpm.setText(note.npm)
            binding.editTextNama.setText(note.nama)
            binding.editTextNilai.setText(note.nilai)
            binding.editTextKeterangan.setText(note.keterangan)
            binding.editTextJumlahsks.setText(note.jumlahsks)
            binding.editTextHargasks.setText(note.hargasks)

            binding.editTextNpm.setSelection(note.npm.length)

        }

        binding.buttonSave.setOnClickListener {
            val npm = binding.editTextNpm.text.toString()
            val nama = binding.editTextNama.text.toString()
            val nilai = binding.editTextNilai.text.toString()
            val keterangan = binding.editTextKeterangan.text.toString()
            val jumlahsks = binding.editTextJumlahsks.text.toString()
            val hargasks = binding.editTextHargasks.text.toString()

            if (title.isEmpty() && nama.isEmpty()) {
                Toast.makeText(applicationContext, "Note cannot be empty", Toast.LENGTH_SHORT)
                    .show()
            } else {
                if (isUpdate) {
                    saveNote(
                        Note(
                            id = note.id,
                            npm = npm,
                            nama = nama,
                            nilai = nilai,
                            keterangan = keterangan,
                            jumlahsks = jumlahsks,
                            hargasks = hargasks
                        )
                    )
                } else {
                    saveNote(
                        Note(
                            npm = npm,
                            nama = nama,
                            nilai = nilai,
                            keterangan = keterangan,
                            jumlahsks = jumlahsks,
                            hargasks = hargasks
                        )
                    )
                }
            }

            finish()
        }

        binding.buttonDelete.setOnClickListener {
            deleteNote(note)
            finish()
        }
    }

    private fun saveNote(note: Note) {

        if (isUpdate) {
            dao.update(note)
        } else {
            dao.insert(note)
        }

        Toast.makeText(applicationContext, "Note Saved", Toast.LENGTH_SHORT).show()
    }

    private fun deleteNote(note: Note) {
        dao.delete(note)
        Toast.makeText(applicationContext, "Note Remove", Toast.LENGTH_SHORT).show()
    }
}