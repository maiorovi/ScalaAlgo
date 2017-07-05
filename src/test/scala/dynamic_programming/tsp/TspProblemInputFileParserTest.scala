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

  test("tsp parser parses to matrix base undirected graph") {
    val parser = new TspProblemInputFileParser

    val matrix = parser.parseTo2DMatrix("tspInput.txt")

    matrix.matrix should contain only (
      Array(0.0, 74.53561415712697, 4109.913459889123, 3047.9957068357057),
      Array(74.53561415712697, 0.0, 4069.7051490249282, 2999.4907299221477),
      Array(4109.913459889123, 4069.7051490249282, 0.0, 1172.3669941144244),
      Array(3047.9957068357057, 2999.4907299221477, 1172.3669941144244, 0.0))
  }

}
