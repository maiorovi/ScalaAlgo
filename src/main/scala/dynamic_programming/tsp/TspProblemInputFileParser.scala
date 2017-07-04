package dynamic_programming.tsp

import scala.io.Source

class TspProblemInputFileParser {

  def parse(fileName:String):List[City] = {
    Source.fromResource(fileName).getLines().toList.tail.map( line => {
      val cords = line.split("\\s").map(_.toDouble)
      City(cords(0), cords(1))
    })
  }




}

case class City(x:Double, y:Double) {
  def distTo(other:City) = Math.sqrt(Math.pow((x - other.x), 2) + Math.pow((y - other.y), 2))
}
