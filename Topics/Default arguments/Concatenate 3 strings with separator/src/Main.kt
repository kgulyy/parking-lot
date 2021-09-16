import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    val s1 = scanner.nextLine()
    val s2 = scanner.nextLine()
    val s3 = scanner.nextLine()
    val separator = scanner.nextLine()

    println(
        if (separator == "NO SEPARATOR") {
            concat(s1, s2, s3)
        } else {
            concat(s1, s2, s3, separator)
        }
    )
}

fun concat(s1: String, s2: String, s3: String, separator: String = " ") =
    arrayOf(s1, s2, s3).joinToString(separator)