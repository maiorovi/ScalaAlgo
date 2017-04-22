package graphs

import org.scalamock.scalatest.MockFactory
import org.scalatest.{BeforeAndAfter, FunSuite}

class DirectedEdgeTest extends FunSuite with BeforeAndAfter with MockFactory {

  val v1 = mock[Vertex]
  val v2 = mock[Vertex]

  var directedEdge: DirectedEdge = DirectedEdge(v1, v2)

  test("directed edge created with correct vertecies") {
    assertResult(v1) {
      directedEdge.from
    }

    assertResult(v2) {
      directedEdge.to
    }
  }

  test("other return second edge") {
    assertResult(v2) {
      directedEdge.other(v1)
    }
  }

  test("reverse returns reversed edge") {
    assertResult(Edge(v2, v1)) {
      directedEdge.reverse
    }
  }

  test("allows to specify weight") {
    assertResult(Edge(v2, v1, 10)) {
      Edge(v1, v2, 10).reverse
    }
  }
}
