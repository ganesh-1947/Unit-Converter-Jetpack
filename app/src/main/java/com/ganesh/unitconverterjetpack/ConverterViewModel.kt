package com.ganesh.unitconverterjetpack

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ganesh.unitconverterjetpack.data.Conversion
import com.ganesh.unitconverterjetpack.data.ConversionResult
import com.ganesh.unitconverterjetpack.data.ConverterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ConverterViewModel(private val repository: ConverterRepository): ViewModel() {

    fun getConversions() = listOf(
        Conversion(1, "Pounds to Kilograms", "lbs", "kg", 0.453592),
        Conversion(2, "Kilograms to Pounds", "kg", "lbs", 2.20462),
        Conversion(3, "Yards to Meters", "yd", "m", 0.9144),
        Conversion(4, "Meters to Yards", "m", "yd", 1.09361),
        Conversion(5, "Miles to Kilometers", "mi", "km", 1.60934),
        Conversion(6, "Kilometers to Miles", "km", "mi", 0.621371),
    )

    val resultList = repository.getSavedResults()

    fun addResult(messageOne: String, messageTwo: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertResult(ConversionResult(0, messageOne, messageTwo))
        }
    }

    fun removeResult(result: ConversionResult) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteResult(result)
        }
    }

    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllResults()
        }
    }


}