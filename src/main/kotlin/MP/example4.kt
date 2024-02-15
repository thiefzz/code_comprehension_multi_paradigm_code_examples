package MP

import kotlin.math.pow

/**
 * What does this class represent and what is printed on line 16?
 */
class A(private val listA: List<Double>) {

    fun funcA(a: Double): Double {
        return listA
            .mapIndexed { i, c -> c * a.pow(i.toDouble()) }
            .sum()
    }
}

fun main() {
    val varA = A(listOf(3.0, 0.0, -2.0, 1.5))
    println(varA.funcA(2.0))
}