import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import com.ganesh.unitconverterjetpack.compose.history.HistoryItem
import com.ganesh.unitconverterjetpack.data.ConversionResult

@Composable
fun HistoryList(
    list: State<List<ConversionResult>>,
    onCloseTask: (ConversionResult) -> Unit,
    modifier: Modifier = Modifier
) {

    LazyColumn {
        items(items = list.value, key = { item -> item.id}) { item ->
            HistoryItem(
                messageOne = item.messageOne,
                messageTwo = item.messageTwo,
                onClose = { onCloseTask(item) })
        }

    }

}