package com.ganesh.unitconverterjetpack.compose

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ganesh.unitconverterjetpack.ConverterViewModel
import com.ganesh.unitconverterjetpack.ConverterViewModelFactory
import com.ganesh.unitconverterjetpack.compose.converter.TopScreen
import com.ganesh.unitconverterjetpack.compose.history.HistoryScreen

@Composable
fun BaseScreen(
    factory: ConverterViewModelFactory,
    modifier: Modifier = Modifier,
    converterViewModel: ConverterViewModel = viewModel(factory = factory)
) {
    val list = converterViewModel.getConversions()
    val historyList = converterViewModel.resultList.collectAsState(initial = emptyList())

    val configuration = LocalConfiguration.current
    var isLandscape by remember { mutableStateOf(false) }

    when(configuration.orientation) {

        Configuration.ORIENTATION_LANDSCAPE -> {
            isLandscape = true
            Row(
                modifier = modifier.padding(30.dp).fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Spacer(modifier = modifier.height(20.dp))
                TopScreen(
                    list,
                    converterViewModel.selectedConversion,
                    converterViewModel.inputText,
                    converterViewModel.typedValue,
                    isLandscape
                ){ messageOne, messageTwo ->
                    converterViewModel.addResult(messageOne, messageTwo)
                }
                Spacer(modifier = modifier.height(20.dp))
                HistoryScreen(
                    historyList,
                    { item ->
                        converterViewModel.removeResult(item)
                    },
                    {
                        converterViewModel.deleteAll()
                    }
                )
            }
        }
        else -> {
            isLandscape = false
            Column(
                modifier = modifier.padding(30.dp)
            ) {
                Spacer(modifier = modifier.height(20.dp))
                TopScreen(
                    list,
                    converterViewModel.selectedConversion,
                    converterViewModel.inputText,
                    converterViewModel.typedValue,
                    isLandscape
                ){ messageOne, messageTwo ->
                    converterViewModel.addResult(messageOne, messageTwo)
                }
                Spacer(modifier = modifier.height(20.dp))
                HistoryScreen(
                    historyList,
                    { item ->
                        converterViewModel.removeResult(item)
                    },
                    {
                        converterViewModel.deleteAll()
                    }
                )
            }
        }
    }


}