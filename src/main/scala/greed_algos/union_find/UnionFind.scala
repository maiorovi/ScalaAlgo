package greed_algos.union_find

import scala.collection.mutable

class UnionFind[T] {
  private var clustersCount = 0
  private val clustersContainer:mutable.LinkedHashMap[T,T] = mutable.LinkedHashMap[T, T]()

  def add(x:T):Unit = {
    clustersContainer += (x -> x)
    clustersCount += 1
  }


  private def find(x:T):T = {
    if (!clustersContainer.contains(x)) {
         throw new IllegalArgumentException
    }
    root(x)
  }

  def union(x:T, y:T):Unit = {
    if (!clustersContainer.contains(x) || !clustersContainer.contains(y)) {
      throw new IllegalArgumentException
    }
    val rootX = root(x)
    val rootY = root(y)

    clustersContainer(rootX) = rootY
  }

  private def root(x:T):T = {
    var current = x
    while(current != clustersContainer(current)) {
      current = clustersContainer(current)
    }

    clustersContainer(current)
  }


  def connected(x:T, y:T):Boolean = find(x) == find(y)
}
