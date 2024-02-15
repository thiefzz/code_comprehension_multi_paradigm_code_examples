package MP
/**
 * What is the result of the function call on line 17?
 */
fun f(x: List<Int>): Int {
    var y = 0
    x.forEach { z ->
        if (z + y < 10)
            y += z
        else
            y -= z
    }
    return y
}

fun main() {
    val a = listOf(1, 2, 3, 4, 5)
    println(f(a))
}

