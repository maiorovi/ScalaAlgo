package dynamic_programming

import org.scalatest.{BeforeAndAfter, FunSuite, Matchers}

class MaximumWeightIndependentSetProblemTest extends FunSuite with Matchers with BeforeAndAfter {


  var algo: MaximumWeightIndependentSetProblem = _

  before {
    algo = new MaximumWeightIndependentSetProblem
  }

  test("bare test") {
    val input = Array(PathGraphVertex("1", 10), PathGraphVertex("2", 5), PathGraphVertex("3", 12), PathGraphVertex("4", 21), PathGraphVertex("5", 30))
    val solution = algo.findSolution(input)
    solution should contain(PathGraphVertex("1", 10), PathGraphVertex("3", 12), PathGraphVertex("5", 30))
  }


}
