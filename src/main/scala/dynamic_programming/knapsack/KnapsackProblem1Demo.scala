package dynamic_programming.knapsack

object KnapsackProblem1Demo {

  def main(args:Array[String]):Unit = {
    val knapsackProblemFileParser = new KnapsackProblemFileParser
    val knapsackProblemSolver = new KnapsackIterativeProblemSolver


//    val (maxCapacity, items) = knapsackProblemFileParser.parse("knapsack1.txt")
    val (maxCapacity, items) = knapsackProblemFileParser.parse("knapsack_big.txt")
//    val solution = knapsackProblemSolver.solve(items.toArray, maxCapacity.toInt)
    println(JavaSolution.knapSack(maxCapacity.toInt, items.map(_.weight).toArray, items.map(_.value).toArray, items.size))
//    println(solution)
  }


}
