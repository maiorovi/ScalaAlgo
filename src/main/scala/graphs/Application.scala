package graphs

import scala.collection.mutable
import scala.io.Source

object Application {

  // 1) O(m)
  // 2) O(n^2)
  // 3) r <= d, r >= d / 2
  // 4) sometimes yes, sometimes no
  // 5) could remain the same
  def main(args: Array[String]):Unit = {
    val lines = Source.fromResource("graph.txt").getLines()
//am
    val graph = new DirectedAdjacencyBasedListGraph

    val vertexes = (1 to 875714).map(numb => (numb.toString, new Vertex(numb.toString))).toMap

    vertexes.values.foreach(vert => graph.addVertex(vert))
    lines.foreach(line => {
      val arr: Array[String] = line.split(" ")
      val v1 = vertexes(arr(0))
      val v2 = vertexes(arr(1))

      val edge = Edge(v1, v2)

      graph.addEdge(edge)
    })
    println("running scc lookup algorithm: ")
    val sccAlgo = new StronglyConnectedComponentsAlgo
    val sccs = sccAlgo.findStronglyConnectedComponents(graph)

    println(sccs.map(scc => scc.size).sortWith(_ > _).mkString(","))
  }
}