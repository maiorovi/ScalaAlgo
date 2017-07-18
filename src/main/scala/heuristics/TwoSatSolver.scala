package heuristics

class TwoSatSolver {

  def solve(expressionContainer: ExpressionContainer, varsArray: VarsContainer): Option[VarsContainer] = {
    def log2(n: Int): Int = (Math.log10(n) / Math.log(2)) toInt

    var i = 0
    var j = 0
    val n = varsArray.size

    while (i < log2(n)) {
      while (j < 2 * Math.pow(n, 2)) {
        if (expressionContainer.isAllExpressionTrue(varsArray)) {
          return Option(varsArray)
        }

        val expr = expressionContainer.findFalseExpression(varsArray)
        varsArray.flipVarValue(expr.map(expr => Math.abs(expr.x)).get)
      }
    }

    Option.empty
  }


}
