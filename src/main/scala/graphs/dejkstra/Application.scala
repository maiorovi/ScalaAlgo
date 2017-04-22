package graphs.dejkstra

import graphs.{DirectedAdjacencyBasedListGraph, Edge, Graph, Vertex}

import scala.io.Source

object Application {
  type Line = String

  def main(args:Array[String]):Unit = {
    val lines = readFile("sp-graph.txt")
    val graph:Graph = constructGraph(lines)

    val dejkstraAlgorithm = new DejkstraAlgorithm()

    val spMap = dejkstraAlgorithm.runDejkstraAlgorithm(graph, Vertex("1"))

    val indexesToShow = List(7, 37, 59, 82,99, 115, 133,165,188,197)

    println(indexesToShow.map( index => spMap(Vertex(index.toString))).mkString(","))
  }

  def readFile(filename:String):List[Line] = Source.fromResource(filename).getLines().toList

  def constructGraph(connections: List[Line]):Graph = {
    val graph = new DirectedAdjacencyBasedListGraph()

    //set up vertecies
    1 to 200 foreach (id => graph.addVertex(Vertex(id.toString)))

    connections.foreach(con => {
      val splitted = con.split("\t")
      val currentVert = splitted(0)

      splitted.drop(1).foreach(v => {
        val tuple = v.split(",")
        val targetVert = tuple(0)
        val len = tuple(1).toInt

        graph.addEdge(Edge(Vertex(currentVert), Vertex(targetVert), len))
      })
    })

    graph
  }


}
