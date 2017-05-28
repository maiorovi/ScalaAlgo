package greed_algos.kruskal

import graphs.{Edge, Graph, Vertex}
import greed_algos.union_find.UnionFind

class MaxSpacingAlgorithm {

  def runMaxSpacingProblem(graph: Graph, k:Int):List[Edge] = {
    val uf = new UnionFind[Vertex]()
    //initialize graph
    graph.vertecies.foreach(uf.add(_))
    var currentClustersAmount = graph.vertextAmount

    val sortedEdges:List[Edge] = graph.edges.sortWith((e1, e2) => e1.weight < e2.weight)

    sortedEdges.take(currentClustersAmount - k).foreach(edge => {
        val (v1, v2) = edge.connectedVertexes
        uf.union(v1, v2)
    })

    List()
  }

}
