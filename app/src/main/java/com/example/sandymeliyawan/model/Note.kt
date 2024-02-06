package com.example.sandymeliyawan.model

import android.icu.text.CaseMap.Title
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "notes")
@Parcelize
data class Note (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "NPM")
    var npm: String = "",

    @ColumnInfo(name = "Nama")
    var nama: String = "",

    @ColumnInfo(name = "Nilai")
    var nilai: String = "",

    @ColumnInfo(name = "Keterangan")
    var keterangan : String = "",

    @ColumnInfo(name = "Jumlah SKS")
    var jumlahsks : String = "",

    @ColumnInfo(name = "Harga SKS")
    var hargasks : String = ""

):Parcelable