package ir.ayantech.ayanhook.presentation.ui.util

import ayanhook.composeapp.generated.resources.Res
import ir.ayantech.ayanhook.presentation.ui.theme.AppStrings
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
suspend fun loadJsonFile(name: String): String {
    val bytes = Res.readBytes("files/$name.json")
    return bytes.decodeToString()
}

fun formatPrice(price: Long): String {
    val str = price.toString()
    val sb = StringBuilder()
    var count = 0

    for (i in str.length - 1 downTo 0) {
        sb.append(str[i])
        count++
        if (count % 3 == 0 && i != 0) {
            sb.append(',')
        }
    }

    return sb.reverse().toString() + AppStrings.rial.current
}

fun parseSimpleHtml(html: String): String {
    return html
        .replace("<html dir=\"rtl\">", "")
        .replace("</html>", "")
        .replace("<p>", "")
        .replace("</p>", "\n")
        .replace("&nbsp;", " ")
        .replace("&lt;", "<")
        .replace("&gt;", ">")
        .replace("&amp;", "&")
        .trim()
}