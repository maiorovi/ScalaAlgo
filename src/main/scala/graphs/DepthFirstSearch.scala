package graphs

import scala.collection.mutable

class DepthFirstSearch {

  def traverse(graph: Graph, from: Vertex): Unit = {
    val visited = mutable.Set[Vertex]()
    visited += from

    val stack:mutable.ListBuffer[Vertex] =  new mutable.ListBuffer[Vertex]()
    stack.+=:(from)

    while(!stack.isEmpty) {
      val currentVertex = stack.remove(0)
      graph.adjacent(currentVertex).foreach(adjacent => {
        if (!visited(adjacent)) {
          stack.+=:(adjacent)
        }
      })
    }

  }
}
