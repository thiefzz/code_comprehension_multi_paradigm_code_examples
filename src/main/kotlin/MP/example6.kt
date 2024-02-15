package MP
/**
 * This class has a matrix as its variable
 * The result on line 53 is [2,4,8] but this is not entirely correct why and what is missing?
 */
class C(val valA: List<List<Int>>) {
    fun funcA(): C {
        val valB = valA.size
        val valC = if (valB > 0) valA[0].size else 0

        return C(List(valC) { a ->
            List(valB) { b -> valA[b][a] }
        })
    }

    fun funcB(
        lambA: (List<List<Int>>, (List<Int>) -> List<Int>) -> List<List<Int>>,
        lambB: (Int) -> Boolean
    ): C {
        return C(lambA(valA) { a -> funcC(a, lambB) })
    }

    private fun funcC(a: List<Int>, lambA: (Int) -> Boolean): List<Int> {
        return a.filter { lambA(it) }
    }
}

fun main() {
    val varA = listOf(
        listOf(1, 2, 3),
        listOf(4, 5, 6),
        listOf(7, 8, 9)
    )
    val varB = C(varA)
    val lambA: (List<List<Int>>, (List<Int>) -> List<Int>) -> List<List<Int>> = { a, lambB ->
        a.map { b -> lambB(b) }
    }
    val result = varB.funcB(lambA) { a -> a % 2 == 0 }
    result.funcA().valA.forEach { a -> println(a) }
}
