package dynamic_programming.knapsack

class KnapsackIterativeProblemSolver {

  def solve(items: Array[Item], maxWeight:Int):Int = {
    val weightSequence = 0 to maxWeight
    val solutionArray = Array.ofDim[Int](items.size + 1, weightSequence.size+1)

//    2493893
    (0 to items.size).foreach( i => {
      (weightSequence).foreach( x => {
        if (i == 0 || x == 0) {
          solutionArray(i)(x) = 0
        } else if ((x >= items(i - 1).weight)) {
          val secondVariant = solutionArray(i - 1)(x - items(i-1).weight) + items(i-1).value
          solutionArray(i)(x) = Math.max(solutionArray(i - 1)(x), secondVariant)
        } else {
          solutionArray(i)(x) = solutionArray(i - 1)(x)
        }

      })
    })

    solutionArray(items.size)(weightSequence.size  - 1)
  }

}
