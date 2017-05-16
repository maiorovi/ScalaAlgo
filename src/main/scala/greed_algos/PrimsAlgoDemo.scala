package greed_algos

import graphs.{AdjacencyListBasedGraph, Edge, Vertex}

import scala.io.Source

object PrimsAlgoDemo {

  def main(args:Array[String]):Unit = {
    val primsAlgorithm = new PrimsAlgorithm()
      val lines = readFromFile("prims.txt")
      val vertexAmount = lines.head.split("\\s")(0)
      println(s"VertexAmount: ${vertexAmount}")
      val graph = new AdjacencyListBasedGraph()

    (1 to 500).map(q => Vertex(q.toString)).foreach(v => graph.addVertex(v))

    // skip first line
    lines.tail.map(line => {
      val splittedLine = line.split("\\s")
      Edge(Vertex(splittedLine(0)), Vertex(splittedLine(1)), splittedLine(2).toInt)
    }).foreach(edge => graph.addEdge(edge))

    val (sum, mst) = primsAlgorithm.runPrimAlgorithm(graph, Vertex("1"))

    println(s"Sum: ${sum}")
  }

  private def readFromFile(fileName: String): List[String] = Source.fromResource(fileName).getLines().toList




}
