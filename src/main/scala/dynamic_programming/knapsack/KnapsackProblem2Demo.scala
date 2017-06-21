package dynamic_programming.knapsack

object KnapsackProblem2Demo {
  def main(args:Array[String]):Unit = {
    val solver = new KnapsackProblemRecursiveSolution
    val parser = new KnapsackProblemFileParser

    val (maxWeight, items) = parser.parse("knapsack_big.txt")

    val solution = solver.solve(maxWeight.toInt,items.toArray)

    println(solution)
  }
}
