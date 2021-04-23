import java.io.File
import java.io.FileWriter

class CsvGenerator : AutoCloseable{
    private lateinit var fileWriter: FileWriter

    fun write(filename: String, function: Function, start: Double, end: Double, stepBy: Double) {
        val file = File(filename)
        if (!file.exists()) {
            if (!file.createNewFile()) {
                throw IllegalArgumentException("Не удалось создать файл по указанному пути")
            }
        }
        fileWriter = FileWriter(file)

        fileWriter.write("X,Y\n")

        var cur = start
        while (cur < end) {
            try {
                val res = function(cur)
                fileWriter.write("$cur,$res\n")
            } catch(e: Exception) {
                fileWriter.write("$cur,exception\n")
            }
            cur += stepBy
        }
        fileWriter.flush()
    }


    override fun close() {
        fileWriter.close()
    }
}