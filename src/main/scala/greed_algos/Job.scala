package greed_algos

case class Job(val weight: Long, val length:Long) {

  def this(weight:String, length:String) {
    this(weight.toLong, length.toLong)
  }
}


object Job {
//  def apply(weight:String, length:String):Job = new Job(weight, length)
}