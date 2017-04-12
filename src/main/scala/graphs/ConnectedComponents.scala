package graphs

import scala.collection.mutable

class ConnectedComponents {

  def connectedComponents(graph: Graph): Integer = {
    val bfsAlgo = new BreadthFirstSearch()
    val visited = mutable.Set[Vertex]()
    var counter = 0

    graph.vertecies.foreach(vertex => {
      if (!visited(vertex)) {
        val traversedOnThisIteration = bfsAlgo.traverseAndReturnVisited(graph, vertex)
        visited ++= traversedOnThisIteration
        counter += 1
      }
    })

    counter
  }

}
