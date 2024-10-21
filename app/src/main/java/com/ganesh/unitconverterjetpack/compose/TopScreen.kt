package com.ganesh.unitconverterjetpack.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.ganesh.unitconverterjetpack.data.Conversion
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun TopScreen(list: List<Conversion>) {

    val selectedConversion: MutableState<Conversion?> = remember { mutableStateOf(null) }
    val inputText: MutableState<String> = remember { mutableStateOf("") }
    var typedValue = remember { mutableStateOf("0.0") }

    ConversionMenu(list = list){
        selectedConversion.value = it
    }

    selectedConversion.value?.let {
        InputBlock(conversion = it, inputText = inputText) {input ->
            typedValue.value = input
        }
    }

    if (typedValue.value != "0.0"){
        val input = typedValue.value.toDouble()
        val multiply = selectedConversion.value!!.multiplyBy
        val result = input * multiply

        //rounding off the result to four decimal places
        val format = DecimalFormat("#.####")
        format.roundingMode = RoundingMode.DOWN
        val roundedResult = format.format(result)

        val messageOne = "${typedValue.value} ${selectedConversion.value!!.convertForm} is equal to"
        val messageTwo = "$roundedResult ${selectedConversion.value!!.convertTo}"
        ResultBlock(messageOne = messageOne, messageTwo = messageTwo)
    }

}