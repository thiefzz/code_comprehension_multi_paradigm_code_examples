package OO
/**
 * This class has a matrix as its variable
 * The result on line 53 is [2,4,8] but this is not entirely correct why and what is missing?
 */
class C(val valA: List<List<Int>>) {
    fun funcA(): C {
        if (valA.isEmpty()) {
            return C(emptyList())
        }

        val varA = valA.size
        val varB = if (varA > 0) valA[0].size else 0

        val listA = mutableListOf<MutableList<Int>>()
        for (i in 0 until varB) {
            val listB = mutableListOf<Int>()
            for (j in 0 until varA) {
                listB.add(valA[j][i])
            }
            listA.add(listB)
        }

        return C(listA)
    }

    fun funcB(): C {
        val listA = mutableListOf<List<Int>>()
        for (varA in valA) {
            val listB = mutableListOf<Int>()
            for (varB in varA) {
                if (funcC(varB)) {
                    listB.add(varB)
                }
            }
            listA.add(listB)
        }
        return C(listA)
    }
    private fun funcC(varA: Int) : Boolean {
        return varA % 2 == 0
    }
}

fun main() {
    val varA = listOf(
        listOf(1, 2, 3),
        listOf(4, 5, 6),
        listOf(7, 8, 9)
    )
    val varB = C(varA)
    val result = varB.funcB()
    result.funcA().valA.forEach { a -> println(a) }
}
