package OO

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

    val listD = funcA(listB)
    val listE = funcA(listC)

    return funcB(listD, listE)
}

private fun funcB(listA: List<Int>, listB: List<Int>): List<Int> {
    var i = 0
    var j = 0
    val listC = mutableListOf<Int>()

    while (i < listA.size && j < listB.size) {
        if (listA[i] < listB[j]) {
            listC.add(listA[i])
            i++
        } else {
            listC.add(listB[j])
            j++
        }
    }

    while (i < listA.size) {
        listC.add(listA[i])
        i++
    }

    while (j < listB.size) {
        listC.add(listB[j])
        j++
    }

    return listC
}
