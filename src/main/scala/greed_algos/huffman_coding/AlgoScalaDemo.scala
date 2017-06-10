package greed_algos.huffman_coding

import scala.io.Source

object AlgoScalaDemo {

  def main(args:Array[String]):Unit = {
    val lines = loadDataFromFile("huffman.txt")
    val leafs = lines.zipWithIndex.map(t => Leaf(t._2.toString, t._1.toInt))

    val huffmanTableBuilder = new HuffmanTableBuilder
    val huffmanTrieConstructor = new HuffmanTrieConstructor

    val root = huffmanTrieConstructor.buildHuffmanCodingTrie(leafs)
    val codingTable = huffmanTableBuilder.buildCodingTable(root)
    val sortedByDescSizeCodingTable =  codingTable.values.toList.sortWith((s1, s2) => s1.length > s2.length)
    val sortedBySizeCodingTable =  codingTable.values.toList.sortWith((s1, s2) => s1.length < s2.length)
    println(sortedByDescSizeCodingTable.head.length) // while this is not
    println(sortedBySizeCodingTable.head.length) // this is correct
  }

  private def loadDataFromFile(fileName: String): List[String] = Source.fromResource(fileName).getLines().toList


}
