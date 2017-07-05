package dynamic_programming.tsp

class AdjacencyMatrixBasedUndirectedGraph(val matrix:Array[Array[Double]]) {

  def distFromIToJCities(i:Int, j:Int):Double = matrix(i)(j)

  def verteciesAmount: Int = matrix.size
}
