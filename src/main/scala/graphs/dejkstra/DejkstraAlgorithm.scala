package graphs.dejkstra

import graphs.{Edge, Graph, Vertex}
import sun.util.resources.cldr.ka.LocaleNames_ka

import scala.collection.mutable

class DejkstraAlgorithm() {

  type PathLenght = Int

  def runDejkstraAlgorithm(graph: Graph, s: Vertex): Map[Vertex, PathLenght] = {
    if (!graph.vertecies.contains(s)) {
      throw new IllegalArgumentException("vertex should be inside graph")
    }

    val visited = mutable.Set[Vertex]()
    val sp = mutable.LinkedHashMap[Vertex, Int]()
    val priorityQueue = new ArrayBufferBasedQueue()

    var i = 0
    sp(s) = 0
    priorityQueue += LookupPair(s, 0)

    while (!priorityQueue.isEmpty) {
      val minimalPair: LookupPair = priorityQueue.pollMin()
      if (!visited(minimalPair.vertex)) {
        visited += minimalPair.vertex
        sp += minimalPair.vertex -> minimalPair.key

        val outEdges = graph.outEdges(minimalPair.vertex)

        priorityQueue ++= outEdges.map(edge => {
          LookupPair(edge.other(minimalPair.vertex), minimalPair.key + edge.weight)
        })
      }
    }

    sp.toMap
  }


}
