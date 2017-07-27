package heuristics.graph

import graphs.{DirectedAdjacencyBasedListGraph, DirectedEdge, Vertex}

class TwoSatGraphConstructor {


  def buildGraph(lines: List[String]): DirectedAdjacencyBasedListGraph = {
    val graph = new DirectedAdjacencyBasedListGraph()

    1 to lines.head.toInt foreach (it => {
      graph.addVertex(new Vertex(it))
      graph.addVertex(new Vertex(-it))
    })

    lines.tail.foreach(line => {
      val splitted = line.split("\\s")
      val fstVertex = splitted(0).toInt
      val sndVertex = splitted(1).toInt
      graph.addEdge(DirectedEdge(new Vertex(-fstVertex), new Vertex(sndVertex)))
      graph.addEdge(DirectedEdge(new Vertex(-sndVertex), new Vertex(fstVertex)))
    })

    graph
  }
}
