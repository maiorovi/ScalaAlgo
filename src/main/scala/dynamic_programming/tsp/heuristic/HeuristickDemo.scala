package dynamic_programming.tsp.heuristic

import dynamic_programming.tsp.TspProblemInputFileParser

object HeuristickDemo {

  def main(args: Array[String]): Unit = {
    val solver = new TspSolverWithHeuristic
    val loader = new TspProblemInputFileParser

    println(solver.solveTsp(loader.parse("nn.txt").toArray))
  }

}
