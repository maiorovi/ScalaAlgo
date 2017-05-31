package greed_algos.union_find

import scala.collection.mutable

class UnionFind[T] {
  private var clustersCount = 0
  private val clustersContainer: mutable.LinkedHashMap[T, T] = mutable.LinkedHashMap[T, T]()
  private val clustersSizeContainer: mutable.LinkedHashMap[T, Int] = mutable.LinkedHashMap[T, Int]()

  def add(x: T): Unit = {
    clustersContainer += (x -> x)
    clustersCount += 1
    clustersSizeContainer += (x -> 1)
  }


  private def find(x: T): T = {
    if (!clustersContainer.contains(x)) {
      throw new IllegalArgumentException
    }
    root(x)
  }

  def union(x: T, y: T): Unit = {
    if (!clustersContainer.contains(x) || !clustersContainer.contains(y)) {
      throw new IllegalArgumentException
    }
    val rootX = root(x)
    val rootY = root(y)

    if (clustersSizeContainer(rootY) > clustersSizeContainer(rootX)) {
      clustersSizeContainer(rootY) += clustersSizeContainer(rootX)
      clustersContainer(rootX) = rootY
    } else {
      clustersContainer(rootY) = rootX
    }
    clustersCount -= 1
    println(s"Current: ${clustersCount}")
  }

  private def root(x: T): T = {
    val seenNodes = mutable.HashSet[T]()
    seenNodes += x

    var current = x
    while (current != clustersContainer(current)) {
      current = clustersContainer(current)
      seenNodes += current
    }

     val root = clustersContainer(current)

    seenNodes.foreach(node => {
      clustersContainer(node) = root
    })

    root
  }

  def connected(x: T, y: T): Boolean = find(x) == find(y)

  def count:Int = clustersCount
}
