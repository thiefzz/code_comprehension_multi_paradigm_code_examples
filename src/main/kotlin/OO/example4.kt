/**
 * What does this class represent and what is printed on line 16?
 */
class A(private val listA: List<Double>) {
    fun funcA(a: Double): Double {
        var varA = 0.0
        for (i in listA.indices) {
            varA += listA[i] * Math.pow(a, i.toDouble())
        }
        return varA
    }
}

fun main() {
    val varA = A(listOf(3.0, 0.0, -2.0, 1.5))
    println(varA.funcA(2.0))
}


