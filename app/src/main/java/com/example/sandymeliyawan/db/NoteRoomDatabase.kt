package com.example.sandymeliyawan.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.sandymeliyawan.model.Note

@Database(entities = [Note::class], version = 2, exportSchema = false)
abstract class NoteRoomDatabase : RoomDatabase() {

    companion object{

        private var INSTANCE : NoteRoomDatabase? =null

        fun getDatabase(context: Context): NoteRoomDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext, NoteRoomDatabase::class.java,
                    "note_db"
                ).allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }

    abstract fun getNoteDao():NoteDao
}