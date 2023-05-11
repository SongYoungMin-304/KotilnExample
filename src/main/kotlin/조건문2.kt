import java.lang.Integer.parseInt

fun main() {

    var x: Int = 2
    var s: String = "2"
    val validNumbers: Array<Int> = arrayOf(1,2,3)

    when (x) {
        0, 1 -> print("x == 0 or x == 1")
        else -> print("otherwise")
    }

    when (x) {
        parseInt(s) -> print("s encodes x")
        else -> print("s does not encode x")
    }

    when (x) {
        in 1..10 -> print("x is in the range")
        in validNumbers -> print("x is valid")
        !in 10..20 -> print("x is outside the range")
        else -> print("none of the above")
    }
}