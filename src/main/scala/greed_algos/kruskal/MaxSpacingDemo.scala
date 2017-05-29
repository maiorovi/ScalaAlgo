package greed_algos.kruskal

import graphs.{AdjacencyListBasedGraph, Edge, Graph, Vertex}
import greed_algos.JobSchedulerDemo.Lines

import scala.io.Source

object MaxSpacingDemo {

  def main(args: Array[String]): Unit = {
    val lines = readLinesFromFile("clustering1.txt")
    val graph: Graph = constructGraph(lines.tail)
    val maxSpacingAlgorithm = new MaxSpacingAlgorithm()
    val finalClustersAmount = 4

    println(maxSpacingAlgorithm.runMaxSpacingProblem(graph, finalClustersAmount))
  }

  def readLinesFromFile(fileName: String): Lines = {
    Source.fromResource(fileName).getLines().toList
  }

  def constructGraph(lines: List[String]): Graph = {
    val graph = new AdjacencyListBasedGraph
    val vertexes = (1 to 500).map(x => Vertex(x.toString()))
    vertexes.foreach(v => graph.addVertex(v))

    lines.map(line => {
      val splittedLine = line.split(" ")
      Edge(Vertex(splittedLine(0)), Vertex(splittedLine(1)), splittedLine(2).toInt)
    }).foreach(graph.addEdge(_))

    graph
  }


}
