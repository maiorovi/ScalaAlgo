package dynamic_programming.bellman_ford

import graphs.{Graph, Vertex}

class BellmanFordBasedShortestPathFinder {

  def findShortestPath(graph:Graph, s:Vertex):Map[Vertex, Int] = {
    val i = graph.vertextAmount
    val v = graph.edges.size
    val storage = Array.ofDim[Int](i, v)

    (1 to i).foreach( i => {
      graph.edges.foreach( edge => {

      })
    })
    ???
  }

}
