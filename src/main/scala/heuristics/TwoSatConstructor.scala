package heuristics

class TwoSatConstructor {

  def construct(lines: List[String]): (VarsContainer, ExpressionContainer) = {
    val n = lines.head.toInt
    val vars = Array.ofDim[Boolean](n)

    val expressions = lines.tail.map( line => {
      val arr = line.split("\\s")
      Expression(arr(0).toInt, arr(1).toInt)
    }).toArray

    (new VarsContainer(vars), new ExpressionContainer(expressions))
  }

}

case class Expression(val x: Int, val y: Int) {

//  def

  def isTruly(vars: VarsContainer):Boolean =  {
    def getValueFor(x:Int):Boolean = if (x < 0) !vars.getVar(Math.abs(x)) else vars.getVar(Math.abs(x))

    getValueFor(x) || getValueFor(y)
  }

}
