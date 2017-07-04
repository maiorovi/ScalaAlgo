package dynamic_programming.tsp

import org.scalatest.{FunSuite, Matchers}

class TspProblemInputFileParserTest extends FunSuite with Matchers {

  test("tsp parser correctly parses input file") {
    val parser = new TspProblemInputFileParser

    val cities = parser.parse("tspInput.txt")

    cities should contain only (City(20833.3333, 17100.0000),
      City(20900.0000, 17066.6667),
      City(21300.0000, 13016.6667),
      City(21600.0000, 14150.0000)
    )
  }

}
