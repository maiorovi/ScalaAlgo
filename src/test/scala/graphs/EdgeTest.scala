package graphs

import org.scalamock.scalatest.MockFactory
import org.scalatest.{BeforeAndAfter, FunSuite}

class EdgeTest extends FunSuite with MockFactory with BeforeAndAfter {

  var edge:Edge = _
  var vertexOne:Vertex = _
  var vertexTwo:Vertex = _

  before {
    vertexOne = new Vertex("1")
    vertexTwo = new Vertex("2")

    edge = new Edge(vertexOne, vertexTwo)
  }

  //not real unit tests
  //should set up mocks here
  test("when first vertex is given to other the second one is returned") {
    assertResult(vertexTwo){ edge.other(vertexOne) }
  }

  test("when second vertex is given to other the first on is returned") {
    assertResult(vertexOne) { edge.other(vertexTwo)}
  }

  test("throws illegal argument exception when given vertex is not related to edge") {
    val vertexThree = new Vertex("3")
    assertThrows[IllegalArgumentException] {
      edge.other(vertexThree)
    }
  }

}
