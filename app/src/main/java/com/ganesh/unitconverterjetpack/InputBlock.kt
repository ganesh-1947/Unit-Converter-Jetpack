import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ganesh.unitconverterjetpack.Conversion

@Composable
fun InputBlock(
    conversion: Conversion,
    inputText: MutableState<String>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(top = 20.dp)) {
        Row(modifier.fillMaxWidth()) {
            TextField(
                value = inputText.value,
                onValueChange = { inputText.value = it},
                modifier = modifier.fillMaxWidth(0.65F),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    autoCorrect = true,
                    keyboardType = KeyboardType.Number
                ),
                /*colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    containerColor = Color.LightGray,            // Background color in Material3
                    cursorColor = Color.Blue,
                    focusedIndicatorColor = Color.Green,
                    unfocusedIndicatorColor = Color.Red
                ),*/
                textStyle = TextStyle(color = Color.DarkGray, fontSize = 30.sp)
            )
            Text(text = conversion.convertForm,
                fontSize = 24.sp,
                modifier = modifier.padding(start = 10.dp, top = 30.dp).fillMaxWidth(0.35f))
        }

    }

}