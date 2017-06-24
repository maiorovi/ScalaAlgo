package dynamic_programming.floyd_warshall

import dynamic_programming.MaxWeightIndSetProblemDemo.Lines
import graphs.{DirectedAdjacencyBasedListGraph, Edge, Graph, Vertex}

import scala.io.Source

object FloydWarshallDemo {
  type Lines = List[String]

  def main(args:Array[String]): Unit = {
    val lines = loadDataFromFile("allToAllPath3.txt")
    val graph = buildGraph(lines)

    val floydWarshall = new FloydWarshallBasedAllToAllPathFinder()

    val finalMap = floydWarshall.findAllToAllPaths(graph)
    println(finalMap.values.mkString(","))

    println(finalMap.values.min)
  }

  private def buildGraph(graphData: Lines):DirectedAdjacencyBasedListGraph = {
    val edgeAndVertexAmountData = graphData.head
    val vertexAmount = edgeAndVertexAmountData.split("\\s")(0).toInt

    val graph = new DirectedAdjacencyBasedListGraph()

    (1 to vertexAmount).foreach(i => graph.addVertex(Vertex(i.toString)))

    graphData.tail.foreach( line => {
      val splittedLine = line.split("\\s")
      graph.addEdge(Edge(
        Vertex(splittedLine(0)), Vertex(splittedLine(1)), splittedLine(2).toInt
      ))
    })

    graph
  }

  private def loadDataFromFile(resourceName:String):Lines = Source.fromResource(resourceName).getLines().toList

}
