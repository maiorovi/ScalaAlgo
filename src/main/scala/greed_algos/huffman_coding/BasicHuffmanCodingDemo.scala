package greed_algos.huffman_coding

object BasicHuffmanCodingDemo {

  def main(args:Array[String]):Unit = {
    val stringStatisticsCounter = new StringStatisticsCounter
    val huffmanTableBuilder = new HuffmanTableBuilder
    val huffmanTrieConstructor = new HuffmanTrieConstructor

    val processor = new HuffmanCompressor(huffmanTableBuilder, huffmanTrieConstructor, stringStatisticsCounter)

    println(processor.compress("ABCD"))
  }

}
