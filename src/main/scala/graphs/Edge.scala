package graphs

sealed trait Edge {
  def from:Vertex
  def to:Vertex
  def weight:Int = 1

  def other(that:Vertex): Vertex = if (that == from) to
                                   else if (that == to) from
                                   else throw new IllegalArgumentException("Vertex doesn`t have any relations to this edge")

  def connectedVertexes: (Vertex, Vertex) = (from, to)

  def reverse: Edge
}

case class DirectedEdge(override val from: Vertex,override val to:Vertex) extends Edge {
  override def reverse: Edge = DirectedEdge(to, from)
}

case class WeightedDirectedEdge(override val from: Vertex, override val to:Vertex, override val weight: Int) extends Edge {
  override def reverse: Edge = WeightedDirectedEdge(to, from, weight)
}

object Edge {
  def apply(from: Vertex, to:Vertex ):Edge = DirectedEdge(from, to)

  def apply(from:Vertex, to:Vertex, weight: Int):Edge = WeightedDirectedEdge(from, to, weight)
}
