package dynamic_programming.tsp.heuristic

import dynamic_programming.tsp.City
import org.scalatest.{FunSuite, Matchers}

class TspSolverWithHeuristicTest extends FunSuite with Matchers {
  val tspSolver = new TspSolverWithHeuristic

  test("basic test of tsp heuristic based on greed algortihm") {
    val cities = List(
      City(1, 2),
      City(7, 5),
      City(5,6),
      City(10,12),
      City(6, 8)
    )

    println(tspSolver.solveTsp(cities.toArray))
  }
}
