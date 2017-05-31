package greed_algos.kruskal

import scala.collection.mutable

class AllLessThenThreeHammingDistanceBitStringGenerator(val bitsNumber:Int) {

  def generateAllBitStrings(input:String):List[String] = {
    val result = mutable.MutableList[String]()
    val intArray = input.toCharArray.map(c => Character.getNumericValue(c))

    (0 until bitsNumber).foreach(bOut => {
      (bOut until bitsNumber).foreach( bIn => {
        val clonedArray = intArray.clone()
        if (bOut != bIn) {
          clonedArray(bOut) = (clonedArray(bOut) + 1) % 2
          clonedArray(bIn) = (clonedArray(bIn) + 1) % 2
        } else {
          clonedArray(bIn) = (clonedArray(bIn) +1) % 2
        }

        result += clonedArray.map(i => i.toString).fold("")(_ + _)
      })
    })

    result.toList
  }

}
