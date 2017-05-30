package greed_algos.kruskal

class HammingDistanceCounter {

  def countHamiltonDistance(fst:String, snd:String):Long = {
    (0 until Math.min(fst.size, snd.size)).map(i => if (fst(i) == snd(i)) 0 else 1).sum + Math.abs(fst.size - snd.size)
  }

}
