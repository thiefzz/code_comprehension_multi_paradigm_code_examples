package OO

/**
 * What is the result of the function call on line 17?
 */
fun g(x: List<Int>): Int {
    var y = 0
    for (z in x) {
        if (z + y < 10)
            y += z
        else
            y -= z
    }
    return y
}

fun main() {
    val a = listOf(1, 2, 3, 4, 5)
    println(g(a))
}
