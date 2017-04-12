package graphs

import org.scalatest.{BeforeAndAfter, FunSuite}
import org.scalatest.matchers._

class ConnectedComponentsTest extends FunSuite with BeforeAndAfter {

  var connectedComponentsAlgo: ConnectedComponents = _

  before {
    connectedComponentsAlgo = new ConnectedComponents
  }

  test("count number of connected components in a graph") {
    val vertexOne = Vertex("1")
    val vertexTwo = Vertex("2")
    val vertexThree = Vertex("3")
    val vertexFour = Vertex("4")
    val vertexFive = Vertex("5")
    val vertexSix = Vertex("6")

    val edgeOne = Edge(vertexOne, vertexTwo)
    val edgeTwo = Edge(vertexThree, vertexFour)
    val edgeThree = Edge(vertexFive, vertexSix)

    val graph = new AdjacencyListBasedGraph
    graph.addVertex( vertexOne, vertexTwo, vertexThree, vertexFour, vertexFive, vertexSix)
    graph.addEdge(edgeOne, edgeTwo, edgeThree)


    assertResult(3) {
      connectedComponentsAlgo.connectedComponents(graph)
    }
  }
}
