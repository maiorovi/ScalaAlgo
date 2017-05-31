package greed_algos.kruskal

import greed_algos.JobSchedulerDemo.Lines
import greed_algos.union_find.UnionFind
import scala.collection.mutable
import scala.io.Source

object MaxSpacingDemoOnBigGraph {

  def main(args: Array[String]): Unit = {
    val lines: List[String] = readLinesFromFile("clustering_big.txt")
    val tailLines = lines.tail
    val trimmedLines = tailLines.map(line => line.replace(" ", "").trim)

    var counter = 0
    val generator = new AllLessThenThreeHammingDistanceBitStringGenerator(24)
    val uf = new UnionFind[String]


    val uniqueNodes = mutable.HashSet[String]()

    trimmedLines.foreach(line => uniqueNodes += line )
    uniqueNodes.foreach(uf.add(_))
    println(s"Initial count: ${uf.count}")
    uniqueNodes.foreach(key => {
      val allBitString = generator.generateAllBitStrings(key)

      allBitString.foreach(generatedString => {
        if (uniqueNodes.contains(generatedString)) {
          if (!uf.connected(generatedString, key)) {
            uf.union(generatedString, key)
          }
        }
      })
    })

    println(s"Final count: ${uf.count}")
  }

  def readLinesFromFile(fileName: String): Lines = {
    Source.fromResource(fileName).getLines().toList
  }
}
