package com.ganesh.unitconverterjetpack.data

data class Conversion (
    val id: Int,
    val description: String,
    val convertForm: String,
    val convertTo: String,
    val multiplyBy: Double
)