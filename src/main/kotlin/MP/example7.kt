package MP
/**
 * What does funcA do and what is the result of the function call on line 52.
 */
class E {
    fun funcA(a: String, b: String): List<Int> {
        val varA = funcB(b)
        return funcD(a, b, 0, 0, varA, mutableListOf())
    }

    private fun funcB(a: String): IntArray {
        fun funcC(b: Int, c: Int, d: IntArray): IntArray {
            return when {
                b == a.length -> d
                a[b] == a[c] -> {
                    d[b] = c + 1
                    funcC(b + 1, c + 1, d)
                }

                c != 0 -> funcC(b, d[c - 1], d)
                else -> {
                    d[b] = 0
                    funcC(b + 1, 0, d)
                }
            }
        }

        return funcC(1, 0, IntArray(a.length))
    }

    private fun funcD(a: String, b: String, c: Int, d: Int, e: IntArray, result: MutableList<Int>): List<Int> {
        return when {
            c == a.length -> result
            a[c] == b[d] -> {
                if (d == b.length - 1) {
                    result.add(c - d)
                    funcD(a, b, c + 1, e[d], e, result)
                } else {
                    funcD(a, b, c + 1, d + 1, e, result)
                }
            }

            d != 0 -> funcD(a, b, c, e[d - 1], e, result)
            else -> funcD(a, b, c + 1, d, e, result)
        }
    }
}

fun main() {
    val varA = E().funcA("ABABDABACDABABCABAB", "ABA")

    if (varA.isNotEmpty()) {
        println(varA)
    } else {
        println("Empty")
    }
}