package graphs

import scala.collection.mutable

class StronglyConnectedComponentsAlgo {

  def findStronglyConnectedComponents(graph: DirectedAdjacencyBasedListGraph): mutable.MutableList[mutable.Set[Vertex]] = {
    val dfs = new DepthFirstSearch
    val reversedGraph = graph.reverse()
    var visited = mutable.Set[Vertex]()
    val topOrder = mutable.MutableList[Vertex]()
    val ssc = mutable.MutableList[mutable.Set[Vertex]]()

    reversedGraph.vertecies.foreach(vertex => {
      if (!visited(vertex)) {
        dfs.recursiveDfs(reversedGraph, vertex, topOrder, visited)
      }
    })
//    434821
//    968
//    459
//    313
//    211

    visited = mutable.Set[Vertex]()

    topOrder.foreach(vertex => {
      if (!visited(vertex)) {
        val c = mutable.Set[Vertex]()
        dfs.recursiveDfsReturnVisited(graph, vertex, visited, c)
        ssc += c
      }
    })

    ssc
  }
}
