package dynamic_programming.knapsack

import scala.io.Source

class KnapsackProblemFileParser {

  def parse(fileName:String):(BigDecimal, List[Item]) = {
    val lines = Source.fromResource(fileName).getLines().toList
    val maxCapacity = BigDecimal(lines.head.split("\\s")(0))

    (maxCapacity, lines.tail.map(line => {
      val parts = line.split("\\s")

      Item(parts(0).toInt, parts(1).toInt)
    }))
  }

}

case class Item(value:Int, weight:Int)