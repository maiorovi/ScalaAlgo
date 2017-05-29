package union_find

import greed_algos.union_find.UnionFind
import org.scalatest.{BeforeAndAfter, FunSpec, FunSuite, Matchers}

class UnionFindTest extends FunSuite with Matchers with BeforeAndAfter {

  case class Dog(val name: String)

  var uf: UnionFind[Dog] = _

  before {
    uf = new UnionFind()
  }

  test("throws illegal argument exception when find invoked on element not present in union find data structure") {
    val dog1 = Dog("dog1")
    val dog2 = Dog("dog2")
    assertThrows[IllegalArgumentException] {
      uf.connected(dog1, dog2)
    }
  }

  test("throws illegal argument exception when first argument given to union is not in data structure") {
    val dog1 = Dog("dog1")
    val dog2 = Dog("dog2")

    uf.add(dog2)

    assertThrows[IllegalArgumentException] {
      uf.union(dog1, dog2)
    }
  }

  test("throws illegal argument exception when second argument given to union is not in data structure") {
    val dog1 = Dog("dog1")
    val dog2 = Dog("dog2")

    uf.add(dog1)

    assertThrows[IllegalArgumentException] {
      uf.union(dog1, dog2)
    }
  }

  test("returns false if two dogs are not connected") {
    val dog1 = Dog("dog1")
    val dog2 = Dog("dog2")

    uf.add(dog1)
    uf.add(dog2)

    uf.connected(dog1, dog2) shouldBe false
  }

  test("returns true if two dogs are connected by union operation") {
    val dog1 = Dog("dog1")
    val dog2 = Dog("dog2")

    uf.add(dog1)
    uf.add(dog2)

    uf.union(dog1, dog2)

    uf.connected(dog1, dog2) shouldBe true
  }


  test("returns true if two dogs are connected by union operation for more complex scenario") {
    val dog1 = Dog("dog1")
    val dog2 = Dog("dog2")
    val dog3 = Dog("dog3")
    val dog4 = Dog("dog4")

    uf.add(dog1)
    uf.add(dog2)
    uf.add(dog3)
    uf.add(dog4)

    uf.union(dog1, dog3)
    uf.union(dog3, dog2)
    uf.union(dog2, dog4)

    uf.connected(dog1, dog4) shouldBe true
  }

  test("does union of two tree correctly") {
    val dog1 = Dog("dog1")
    val dog2 = Dog("dog2")
    val dog3 = Dog("dog3")
    val dog4 = Dog("dog4")
    val dog5 = Dog("dog5")

    uf.add(dog1)
    uf.add(dog2)
    uf.add(dog3)
    uf.add(dog4)
    uf.add(dog5)

    uf.union(dog1, dog3)
    uf.union(dog3, dog5)


    uf.union(dog2, dog4)
    //union two tree
    uf.union(dog3, dog4)

    uf.connected(dog3, dog5) shouldBe true
    uf.connected(dog1, dog4) shouldBe true
  }

}
