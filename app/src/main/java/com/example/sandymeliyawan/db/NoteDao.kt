package com.example.sandymeliyawan.db


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.sandymeliyawan.model.Note

@Dao
interface NoteDao {

    @Insert
    fun insert(note: Note)

    @Update
    fun update(note: Note)

    @Delete
    fun delete(note: Note)

    @Query("SELECT * FROM notes")
    fun getAll() : List<Note>

    @Query("SELECT * FROM notes WHERE id = :id")
    fun getById(id:Int): List<Note>
}