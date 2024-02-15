package MP
/**
 * What is the output of line 14 and 15
 * and what does funcA and funcB do
 */
fun funcA(a: Int): Boolean {
    return (a > 1) && (2 until a).none { a % it == 0 }
}

fun funcB(a: Int, b: Int): Int {
    return if (b == 0) a else funcB(b, a % b)
}

fun main() {
    println(funcB(12,16))
    println(funcA(15))
}
