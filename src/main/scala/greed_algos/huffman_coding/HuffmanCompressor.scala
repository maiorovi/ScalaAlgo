package greed_algos.huffman_coding

class HuffmanCompressor(val huffmanTableBuilder: HuffmanTableBuilder,
                        val huffmanTrieConstructor: HuffmanTrieConstructor,
                        val stringStatisticsCounter: StringStatisticsCounter) {

  def compress(input:String): String = {
    val leafs = stringStatisticsCounter.countStatistics(input)
//    val leafs = List(Leaf("A", 60), Leaf("B", 25), Leaf("C", 10), Leaf("D", 5))
    val trie = huffmanTrieConstructor.buildHuffmanCodingTrie(leafs)
    val table = huffmanTableBuilder.buildCodingTable(trie)

    input.map( c => c.toString).map( c => table(c)).foldLeft("")(_ + _)
  }
}
