package dynamic_programming.floyd_warshall

import graphs.{AdjacencyListBasedGraph, DirectedAdjacencyBasedListGraph}

import scala.collection.mutable

class FloydWarshallBasedAllToAllPathFinder {
  private val INF = 999999

  def findAllToAllPaths(graph: DirectedAdjacencyBasedListGraph): Map[(Int, Int), Int] = {
    val n = graph.vertextAmount
    val mapping = (1 to n).zip(graph.vertecies).toMap
    val srcRng = 1 to n
    val destRng = 1 to n
    val kRng = 1 to n

    val storage = Array.fill[Int](n+1, n+1)(INF)

    srcRng.foreach( i => {
      destRng.foreach({j => {
          if (i == j) {
            storage(i)(j) = 0
          } else if (graph.hasEdge(mapping(i), mapping(j))) {
            storage(i)(j) = graph.edgeWeightBetween(mapping(i), mapping(j))
          } else {
            storage(i)(j) = INF
          }
        }
      })
    })

    kRng.foreach(k => {
      srcRng.foreach(i => {
        destRng.foreach(j => {
          if (storage(i)(j) > storage(i)(k) + storage(k)(j)) {
            storage(i)(j) = storage(i)(k) + storage(k)(j)
          }
        })
      })
    })

    val resultMap = mutable.HashMap[(Int, Int), Int]()

    srcRng.foreach(i => {
      destRng.foreach(j => {
        resultMap += (i, j) -> storage(i)(j)
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
