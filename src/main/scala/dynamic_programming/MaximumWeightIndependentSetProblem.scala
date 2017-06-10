package dynamic_programming

import scala.collection.mutable

case class PathGraphVertex(id: String, weight: Int)

class MaximumWeightIndependentSetProblem {
    case class HistoryAwareSolution(value:Int, history: List[PathGraphVertex])

    def findSolution(pathGraph: Array[PathGraphVertex]):List[PathGraphVertex] = {
      val tmpArray =  new Array[Int](pathGraph.size)

      tmpArray(0) = 0
      tmpArray(1) = pathGraph.head.weight

      (2 until pathGraph.length) foreach (ind => {
        val prev = ind - 1
        val prevPrev = ind - 2
        val curVertex = pathGraph(ind)
        if (tmpArray(prev) > tmpArray(prevPrev) + curVertex.weight) {
          tmpArray(ind) = tmpArray(prev)
        } else {
          tmpArray(ind) = tmpArray(prevPrev) + curVertex.weight
        }
      })


      reconstructSolution(tmpArray, pathGraph)
    }

  private def reconstructSolution(solutionResult: Array[Int], pathGraph: Array[PathGraphVertex]): List[PathGraphVertex] = {
    var i = solutionResult.size - 1
    var result = mutable.MutableList[PathGraphVertex]()
    while( i > 1) {
      println(i)
      if (solutionResult(i - 1) >= solutionResult(i - 2) + pathGraph(i).weight) {
        i = i -1
      }  else {
        result += pathGraph(i)
        i = i - 2
      }
    }

    result.toList
  }

}
