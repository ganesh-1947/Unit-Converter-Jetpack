package com.ganesh.unitconverterjetpack.compose.converter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.ganesh.unitconverterjetpack.data.Conversion
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun TopScreen(
    list: List<Conversion>,
    selectedConversion: MutableState<Conversion?>,
    inputText: MutableState<String>,
    typedValue: MutableState<String>,
    isLandscape: Boolean,
    save: (String, String) -> Unit
) {

    var toSave by remember {
        mutableStateOf(false)
    }

    Column (modifier = Modifier.verticalScroll(rememberScrollState())){
        ConversionMenu(list = list, isLandscape){
            selectedConversion.value = it
            typedValue.value = "0.0"
        }

        selectedConversion.value?.let {
            InputBlock(conversion = it, inputText = inputText, isLandscape) {input ->
                typedValue.value = input
                toSave = true
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

            if (toSave) {
                save(messageOne, messageTwo)
                toSave = false
            }

            ResultBlock(messageOne = messageOne, messageTwo = messageTwo)
        }
    }

}