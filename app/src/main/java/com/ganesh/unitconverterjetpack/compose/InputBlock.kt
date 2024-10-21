package com.ganesh.unitconverterjetpack.compose

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ganesh.unitconverterjetpack.data.Conversion

@Composable
fun InputBlock(
    conversion: Conversion,
    inputText: MutableState<String>,
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current,
    calculate: (String) -> Unit
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
                modifier = modifier
                    .padding(start = 10.dp, top = 30.dp)
                    .fillMaxWidth(0.35f))
        }

        Spacer(modifier = modifier.height(20.dp))

        OutlinedButton(onClick = {
            if (inputText.value != ""){
                calculate(inputText.value)
            } else {
                Toast.makeText(context, "Please enter your value", Toast.LENGTH_SHORT).show()
            }
        },
            modifier = modifier.fillMaxWidth(1f)) {

            Text(text = "Convert", fontSize = 36.sp, fontWeight = FontWeight.Bold, color = Color.Blue)

        }

    }

}