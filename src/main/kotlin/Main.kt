import com.google.gson.Gson
import java.io.File
import java.io.FileInputStream
import java.util.Scanner

fun main(args: Array<String>) {
    val gson = Gson()
    val json = File("src\\main\\resources\\json\\languages.json")
    val input= FileInputStream(json)
    val scanner = Scanner(input)
    val buffer = StringBuffer();
    while(scanner.hasNextLine()){
        buffer.append(scanner.nextLine())
    }
    val j = buffer.toString()
    input.close()
    scanner.close()
    val language = gson.fromJson(j,Language::class.java)
    println("all size is ${language.compact.size}")


}


data class Language(
    val compact: Map<String,Nation>
)

data class Nation(
    val name: String,
    val nativeName: String,
    val dir: String,
    val scripts: List<Script>?,
    val translation: Boolean?,
    val speech: Boolean?,
    val truetext: Boolean?,
    val conversationalSpeech: Boolean?,
    val customizableSpeech: Boolean?,
    val speechCode: String?,
    val dictionaries: List<Dictionary>?,
    val voices: List<Voice>?,
    val speechRegions: List<SpeechRegion>?
)

data class Script(
    val code: String,
    val name: String,
    val nativeName: String,
    val dir: String,
    val toScripts: List<ToScript>
)

data class ToScript(
    val code: String,
    val name: String,
    val nativeName: String,
    val dir: String
)

data class Dictionary(
    val name: String,
    val nativeName: String,
    val dir: String,
    val code: String
)

data class Voice(
    val gender: String,
    val locale: String,
    val displayName: String,
    val regionName: String,
    val region: String,
    val nativeRegionName: String,
    val voice: String,
    val shortName: String
)

data class SpeechRegion(
    val code: String,
    val name: String,
    val nativeName: String
)