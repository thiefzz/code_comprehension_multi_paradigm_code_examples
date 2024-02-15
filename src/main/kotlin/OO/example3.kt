package OO
/**
 * What is the output of line 14 and 15
 * and what does funcA and funcB do
 */
fun funcA(valA: Int): Boolean {
    if(valA<2) return false
    for (i in 2..valA/2) {
        if (valA % i == 0) {
            return false
        }
    }
    return true
}
fun funcB(valA: Int, valB: Int): Int {
    var varA = valA
    var varB = valB
    while (varB != 0) {
        val varC = varB
        varB = varA % varB
        varA = varC
    }
    return varA
}

fun main() {
    println(funcB(12,16))
    println(funcA(15))
}