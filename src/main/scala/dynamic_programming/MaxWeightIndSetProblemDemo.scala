package dynamic_programming

import scala.collection.immutable.HashSet
import scala.collection.mutable
import scala.io.Source

object MaxWeightIndSetProblemDemo {

  type Lines = Array[String]

  def main(args: Array[String]):Unit = {
    val lines = loadDataFromFile("mwis.txt")
    val indexes = (1 to lines.size)
    val vertexies = lines.zip(indexes).map(t => PathGraphVertex(t._2.toString, t._1.toInt))

    val algorithm = new MaximumWeightIndependentSetProblem()

    val solution = algorithm.findSolution(vertexies)
    println(solution.mkString(", "))
    val keyVertexesSet = mutable.LinkedHashSet(1,2,3,4,17,117,517,997)

    val filteredResult = solution.filter(vert => keyVertexesSet.contains(vert.id.toInt)).map(v => v.id.toInt)
    val string = keyVertexesSet.foldLeft("")((acc, c) => if (filteredResult.contains(c)) acc + "1" else acc + "0")

    println(string)

  }

  private def loadDataFromFile(resourceName:String):Lines = Source.fromResource(resourceName).getLines().toArray.tail
}
