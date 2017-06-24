package dynamic_programming.floyd_warshall

import graphs.{AdjacencyListBasedGraph, DirectedAdjacencyBasedListGraph}

import scala.collection.mutable

class FloydWarshallBasedAllToAllPathFinder {

  def findAllToAllPaths(graph: DirectedAdjacencyBasedListGraph): Map[(Int, Int), Int] = {
    val n = graph.vertextAmount
    val mapping = (1 to n).zip(graph.vertecies).toMap
    val srcRng = 1 to n
    val destRng = 1 to n
    val kRng = 1 to n

    val storage = Array.fill[Int](n+1, n+1, n+1)(Int.MaxValue)

    kRng.foreach(k => {
      srcRng.foreach(i => {
        destRng.foreach(j => {
          if (k == 1) {
            if (i == j) {
              storage(1)(i)(j) = 0
            } else if (graph.hasEdge(mapping(i), mapping(j))) {
              storage(1)(i)(j) = graph.edgeWeightBetween(mapping(i), mapping(j))
            } else { storage(1)(i)(j) = Int.MaxValue }
          } else {
            storage(i)(j)(k) = Math.min(storage(i)(j)(k - 1), storage(i)(k)(k - 1) + storage(k)(j)(k - 1))
          }
        })
      })
    })

    val resultMap = mutable.HashMap[(Int, Int), Int]()

    srcRng.foreach(i => {
      destRng.foreach(j => {
        resultMap += (i, j) -> storage(i)(j)(n)
      })
    })

    if (isGraphHasNegativeCycle(resultMap.toMap, n)) {
      throw new RuntimeException("Negative cycle detected")
    }

    resultMap.toMap
  }

  private def isGraphHasNegativeCycle(algorithmOutput: Map[(Int, Int), Int], n: Int): Boolean = {
    var answer = false

    (1 to n).foreach(i => {
      (1 to n).foreach(j => {
        if (algorithmOutput(i,i) < 0) {
          answer = true
        }
      })
    })

    answer
  }


}
