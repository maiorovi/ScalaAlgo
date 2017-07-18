package heuristics

class ExpressionContainer(val exprsionsArray: Array[Expression]) {
  def findFalseExpression(varsArray: VarsContainer): Option[Expression] = exprsionsArray.find(expr => !expr.isTruly(varsArray))

  def isAllExpressionTrue(varsArray: VarsContainer):Boolean = exprsionsArray.forall(expr => expr.isTruly(varsArray))

}
