package graphs

import scala.collection.mutable

class TopologicalSortAlgo {

  def sortTopologicaly(graph: Graph): List[Vertex] = {
    val dfsAlgo = new DepthFirstSearch
    var visited = mutable.Set[Vertex]()
    val index = graph.vertextAmount
    var topologicalySortedVertecies = mutable.MutableList[Vertex]()//

    graph.vertecies.foreach(currentVertex => {
      if (!visited(currentVertex)) {
        val c = mutable.MutableList[Vertex]()
        val visitedOnThisIteration = mutable.Set[Vertex]()
        dfsAlgo.recursiveDfs(graph, currentVertex, topologicalySortedVertecies, visited)
//        topologicalySortedVertecies = topologicalySortedVertecies.++(c)
//        visited = visited.++(visitedOnThisIteration)
      }
    })

    topologicalySortedVertecies.toList
  }

}
