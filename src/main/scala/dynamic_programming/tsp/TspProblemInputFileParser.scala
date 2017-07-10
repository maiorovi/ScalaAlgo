package dynamic_programming.tsp

import scala.io.Source

class TspProblemInputFileParser {

  def parse(fileName:String):List[City] = {
    Source.fromResource(fileName).getLines().toList.tail.map(line => {
      val cords = line.split("\\s").map(_.toDouble)
      City(cords(1), cords(2))
    })
  }

  def parseTo2DMatrix(fileName:String):AdjacencyMatrixBasedUndirectedGraph = {
    val cities = parse(fileName).toArray
    val matrix = Array.ofDim[Double](cities.size, cities.size)

    (0 until cities.size).foreach( i => {
      (0 until cities.size).foreach( j => {
        matrix(i)(j) = cities(i).distTo(cities(j))
      })
    })

    new AdjacencyMatrixBasedUndirectedGraph(matrix)
  }
}

case class City(x:Double, y:Double) {
  def distTo(other:City) = Math.sqrt(Math.pow((x - other.x), 2) + Math.pow((y - other.y), 2))
}
