package greed_algos.kruskal

import graphs.{Edge, Graph, Vertex}
import greed_algos.union_find.UnionFind

class MaxSpacingAlgorithm {

  def runMaxSpacingProblem(graph: Graph, k: Int): Int = {
    val uf = new UnionFind[Vertex]()
    //initialize graph
    graph.vertecies.foreach(uf.add(_))
    val initialClustersAmount = graph.vertextAmount

    if (k > initialClustersAmount) {
      throw new IllegalArgumentException
    }
    var maxSpacing = 0
    var currentClustersAmount = initialClustersAmount
    val sortedEdges: List[Edge] = graph.edges.sortWith((e1, e2) => e1.weight < e2.weight)

    sortedEdges.foreach(edge => {

      if (k == currentClustersAmount) {
        maxSpacing = edge.weight
      }

      val (v1, v2) = edge.connectedVertexes
      if (!uf.connected(v1, v2)) {
        currentClustersAmount -= 1
        uf.union(v1, v2)
      }
    })

    maxSpacing
  }

}
