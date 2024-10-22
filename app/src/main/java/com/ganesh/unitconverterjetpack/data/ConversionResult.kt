package com.ganesh.unitconverterjetpack.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "result_table")
data class ConversionResult (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "result_id")
    val id: Int,
    @ColumnInfo(name = "result_messageOne")
    val messageOne: String,
    @ColumnInfo(name = "result_messageTwo")
    val messageTwo: String
)