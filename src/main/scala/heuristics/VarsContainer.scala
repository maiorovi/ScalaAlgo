package heuristics

class VarsContainer(val array: Array[Boolean]) {

//  def isTrulyExpression(expression: Expression): Boolean = array(expression.x) || array(expression.y)

  def getVar(i: Int): Boolean = array(i)

  def flipVarValue(i: Int): Unit = array(i) = !array(i)

  def size = array.size

}
