package dynamic_programming

import scala.collection.mutable

case class PathGraphVertex(id: String, weight: Long)

class MaximumWeightIndependentSetProblem {

    def findSolution(pathGraph: Array[PathGraphVertex]):List[PathGraphVertex] = {
      val tmpArray =  new Array[Long](pathGraph.size+1)

      tmpArray(0) = 0
      tmpArray(1) = pathGraph.head.weight

      (1 until pathGraph.length) foreach (ind => {
        val prev = ind
        val prevPrev = ind - 1
        val curVertex = pathGraph(ind)
        if (tmpArray(prev) > tmpArray(prevPrev) + curVertex.weight) {
          tmpArray(ind+1) = tmpArray(prev)
        } else {
          tmpArray(ind+1) = tmpArray(prevPrev) + curVertex.weight
        }
      })


      reconstructSolution(tmpArray, pathGraph)
    }

  private def reconstructSolution(solutionResult: Array[Long], pathGraph: Array[PathGraphVertex]): List[PathGraphVertex] = {
    var i = solutionResult.size - 1
    var result = mutable.MutableList[PathGraphVertex]()
    while( i >= 1) {
      println(i)
      if (solutionResult(i) == solutionResult(i - 1)) {
        i = i -1
      }  else {
        result += pathGraph(i - 1)
        i = i - 2
      }
    }

    result.toList
  }

}
