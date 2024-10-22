package com.ganesh.unitconverterjetpack.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
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
    Column(
        modifier = modifier.padding(30.dp)
    ) {
        Spacer(modifier = modifier.height(20.dp))
        TopScreen(list){ messageOne, messageTwo ->
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