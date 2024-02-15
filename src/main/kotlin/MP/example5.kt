package MP
/**
 * you have been given a data class edge and node
 * and within the class graph there are 2 to be identified functions.
 * What does funcA do and what does it return?
 */
data class Edge(val source: Node, val destination: Node, val weight: Int)
data class Node(val name: String)
class Graph(val nodes: List<Node>, val edges: List<Edge>) {
    // this is a list with all neighbours of each Node
    private val adjacencyList: Map<Node, List<Edge>> = nodes.associateWith { node ->
        edges.filter { it.source == node }
    }

    fun funcA(nodeA: Node, nodeB: Node): Pair<Int, List<Node>>? {
        val (listA, mapA) = nodes.fold(
            emptyList<Node>() to mapOf(nodeA to Pair(0, listOf(nodeA)))
        ) { (listB, mapB), _ ->
            if (listB.isEmpty() || listB.last() != nodeB) {
                val currentNode = mapB
                    .filterKeys { it !in listB }
                    .minByOrNull { it.value.first }

                val pairBnodeB = mapB[nodeB]
                if (pairBnodeB != null && (currentNode == null || currentNode.key == nodeB)) {
                    pairBnodeB.second to mapB
                } else {
                    val varA = checkNotNull(mapB[currentNode?.key]?.first)
                    val listC = mapB[currentNode?.key]?.second ?: emptyList()
                    val listD = adjacencyList[currentNode?.key] ?: emptyList()

                    val mapB = funcB(listD, nodeA, mapB, varA, listC)

                    val listE = if (currentNode?.key != nodeA) listB + currentNode!!.key else listOf(currentNode.key)
                    listE to mapB
                }
            } else {
                listB to mapB
            }
        }
        return if (listA.isNotEmpty() && listA.last() == nodeB) mapA[nodeB] else null
    }

    private fun funcB(
        listEdge: List<Edge>,
        nodeA: Node,
        mapA: Map<Node, Pair<Int, List<Node>>>,
        a: Int,
        listNode: List<Node>
    ): Map<Node, Pair<Int, List<Node>>> {
        return listEdge.fold(mapA.toMutableMap()) { mapB, edge ->
            val varA = a + edge.weight

            val (varB, _) = mapB[edge.destination] ?: Pair(Int.MAX_VALUE, listOf(nodeA))

            if (varA < varB) {
                mapB[edge.destination] = varA to (listNode + edge.destination)
            }
            mapB
        }
    }

}
