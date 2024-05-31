package m.l.wsb_mobile_app.model

import androidx.compose.ui.graphics.Color
import com.squareup.moshi.JsonClass
import java.io.Serializable
import java.util.UUID

@JsonClass(generateAdapter = true)
data class Task(
    val title: String,
    val description: String,
    val colorType: ColorType,
    val id: String = UUID.randomUUID().toString()
) : Serializable

enum class ColorType(val color: Color){
    CYAN(Color.Cyan),
    YELLOW(Color.Yellow),
    RED(Color.Red),
    MAGENTA(Color.Magenta),
}