package com.ganesh.unitconverterjetpack

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ganesh.unitconverterjetpack.data.ConverterRepository

class ConverterViewModelFactory(private val repository: ConverterRepository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ConverterViewModel(repository) as T
    }
}