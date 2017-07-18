package heuristics

import hash_tables.Application.Line

import scala.io.Source

object Demo {

  def main(args: Array[String]): Unit = {
    def readFile(filename:String):List[Line] = Source.fromResource(filename).getLines().toList

    val constructor = new TwoSatConstructor
    val solver = new TwoSatSolver

    val (vars, expressions) = constructor.construct(readFile("2sat/2sat1.txt"))

    val answer = solver.solve(expressions, vars)

    if (answer.isEmpty) {
      println("Not tractable")
    } else {
      println("tractable")
    }
  }



}
