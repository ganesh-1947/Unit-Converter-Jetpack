import androidx.compose.runtime.Composable
import com.ganesh.unitconverterjetpack.Conversion

@Composable
fun TopScreen(list: List<Conversion>) {
    ConversionMenu(list = list)

}