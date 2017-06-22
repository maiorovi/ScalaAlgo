package dynamic_programming.knapsack

import scala.collection.mutable

class KnapsackProblemRecursiveSolution {

  private val cache = mutable.HashMap[(Int, Int), Int]()

  def solve(maxWeight: Int, items: Array[Item]): Int = {
    solve(maxWeight, items, items.size)
  }


  private def solve(maxWeight: Int, items: Array[Item], n: Int): Int = {
    if (n == 0 || maxWeight == 0) {
      return 0
    }
    if (cache.contains((n-1, maxWeight - items(n-1).weight))) {
      return cache((n-1, maxWeight - items(n-1).weight))
    }

    return if (items(n - 1).weight > maxWeight) {
      solve(maxWeight, items, n - 1)
    } else {
      val result = Math.max(items(n-1).value + solve(maxWeight - items(n - 1).weight, items, n-1),
                      solve(maxWeight, items, n-1))

      cache += ((n-1, maxWeight - items(n-1).weight) -> result)

      result
    }
  }

}
