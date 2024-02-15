package OO

/**
 * you have been given a data class edge and node
 * and within the class graph there are 2 to be identified functions.
 * What does funcA do and what does it return?
 */
data class Edge(val source: Node, val destination: Node, val weight: Int)

data class Node(val name: String)
class Graph(val nodes: List<Node>, val edges: List<Edge>) {
    // this is a list with all neighbours of each Node
    private val adjacencyList: Map<Node, List<Edge>>
        get() {
            val adjacencyMap = mutableMapOf<Node, List<Edge>>()

            for (node in nodes) {
                val adjacentEdges = mutableListOf<Edge>()
                for (edge in edges) {
                    if (edge.source == node) {
                        adjacentEdges.add(edge)
                    }
                }
                adjacencyMap[node] = adjacentEdges
            }

            return adjacencyMap
        }


    fun funA(nodeA: Node, nodeB: Node): Pair<Int, List<Node>>? {
        val mapA = mutableMapOf<Node, Pair<Int, List<Node>>>()
        mapA[nodeA] = 0 to listOf(nodeA)

        while (mapA.isNotEmpty()) {
            val currentNode = mapA.minByOrNull { it.value.first }
            if (currentNode == null || currentNode.key == nodeB) {
                return mapA[nodeB]
            }

            val varA = currentNode.value.first
            val listB = currentNode.value.second
            mapA.remove(currentNode.key)

            val listEdge = adjacencyList[currentNode.key] ?: emptyList()

            for (edge in listEdge) {
                val nodeC = edge.destination
                val varB = varA + edge.weight
                val listC = listB + nodeC


                if (varB < (mapA[nodeC]?.first ?: Int.MAX_VALUE)) {
                    mapA[nodeC] = varB to listC
                }
            }
        }

        return null
    }
}
/**
 * This class represents a multi-paradigm outlook on the calculations of the shortestpath given a start and end node. It returns a pair
 * containing the cost of the path and the path itself.
 */