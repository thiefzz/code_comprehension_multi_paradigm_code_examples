package OO
/**
 * What does funcA do and what is the result of the function call on line 64.
 */
class D {
    fun funcA(a: String, b: String): List<Int> {
        val varA = a.length
        val varB = b.length
        val result = mutableListOf<Int>()

        val varC = funcB(b)

        var i = 0
        var varE = 0

        while (i < varA) {
            if (b[varE] == a[i]) {
                i++
                varE++
            }

            if (varE == varB) {
                result.add(i - varE)
                varE = varC[varE - 1]
            } else if (i < varA && b[varE] != a[i]) {
                if (varE != 0) {
                    varE = varC[varE - 1]
                } else {
                    i++
                }
            }
        }

        return result
    }

    private fun funcB(a: String): IntArray {
        val varA = a.length
        val result = IntArray(varA)
        var varC = 0
        var varD = 1

        while (varD < varA) {
            if (a[varD] == a[varC]) {
                varC++
                result[varD] = varC
                varD++
            } else {
                if (varC != 0) {
                    varC = result[varC - 1]
                } else {
                    result[varD] = 0
                    varD++
                }
            }
        }

        return result
    }
}

fun main() {
    val varB = D().funcA("ABABDABACDABABCABAB", "ABA")
    if (varB.isNotEmpty()) {
        println(varB)
    } else {
        println("Empty")
    }
}
