package MP
/**
 * What is the functionality of funcA, and what does funcB do?
 */
fun funcA(listA: List<Int>): List<Int> {
    if (listA.size <= 1) {
        return listA
    }
    val varA = listA.size / 2
    val listB = listA.subList(0, varA)
    val listC = listA.subList(varA, listA.size)
    return funcB(funcA(listB), funcA(listC))
}

fun funcB(listA: List<Int>, listB: List<Int>): List<Int> {
    return when {
        listA.isEmpty() -> listB
        listB.isEmpty() -> listA
        listA.first() < listB.first() -> {
            listOf(listA.first()) + funcB(listA.drop(1), listB)
        }

        else -> {
            listOf(listB.first()) + funcB(listA, listB.drop(1))

        }
    }
}