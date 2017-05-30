package greed_algos.kruskal

import graphs.{AdjacencyListBasedGraph, Vertex}
import greed_algos.JobSchedulerDemo.Lines
import greed_algos.union_find.UnionFind

import scala.io.Source

object MaxSpacingDemoOnBigGraph {

  def main(args: Array[String]): Unit = {
    val lines: List[String] = readLinesFromFile("clustering_big.txt")
    val tailLines = lines.tail
    /*
    1) count hamilton distance for each pair of edge
    2) if hamilton distance beetween pair of edges is 2 or less then
        increment counter
     */
    var counter = 0
    val hummingDistanceCounter = new HammingDistanceCounter()

    tailLines.foreach(currentLine => {
      tailLines.foreach(line => {
        if (currentLine != line) {
          val hummingDistance = hummingDistanceCounter.countHamiltonDistance(line, currentLine)
          println()
          if (hummingDistance < 3) {
            counter += 1
            if (counter % 4 == 0) {
              println(s"Counter: ${counter}")
            }
          }
        }
      })
    })

    println(counter)
  }


  def readLinesFromFile(fileName: String): Lines = {
    Source.fromResource(fileName).getLines().toList
  }
}
