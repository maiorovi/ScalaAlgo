package dynamic_programming.tsp.heuristic

import dynamic_programming.tsp.City
import scala.collection._


class TspSolverWithHeuristic {

  def solveTsp(cities: Array[City]): Double = {
    val n = cities.size
    val visitedCities = Array.ofDim[Boolean](n)
    val tour = Array.ofDim[Double](n)
    val queue = mutable.Queue[Int]()
    val minDistances = Array.ofDim[Double](n)

    (0 until n).foreach(i => visitedCities(i) = false)
    (0 until n).foreach(i => tour(i) = 0)

    queue += 0
    var counter = 0

    while (!queue.isEmpty) {
      val i = queue.dequeue()
      counter += 1

      if (!visitedCities(i)) {
        visitedCities(i) = true
        var min = Double.MaxValue
        var nextCity = -1

        (0 until n).foreach(j => {
          if (i != j) {
            if (min > cities(i).distTo(cities(j)) && !visitedCities(j)) {
              nextCity = j
              min = cities(i).distTo(cities(j))
            }
          }
        })

        if (nextCity != -1) {
          queue += nextCity
          tour(i) = min
        } else {
          tour(i) = cities(i).distTo(cities(0))
        }

      }
//      val compl = i * 100 / n
//      if ( compl % 5 == 0) println(s"${compl}")

    }

    tour.sum
  }

}
