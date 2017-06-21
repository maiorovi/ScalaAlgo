package dynamic_programming.knapsack

class KnapsackProblemRecursiveSolution {


  def solve(maxWeight: Int, items: Array[Item]): Int = {
    solve(maxWeight, items, items.size)
  }


  private def solve(maxWeight: Int, items: Array[Item], n: Int): Int = {
    if (n == 0 || maxWeight == 0) {
      return 0
    }

    return if (items(n - 1).weight > maxWeight) {
      solve(maxWeight, items, n - 1)
    } else {
      Math.max(items(n-1).value + solve(maxWeight - items(n - 1).weight, items, n-1),
              solve(maxWeight, items, n-1))
    }
  }

}
