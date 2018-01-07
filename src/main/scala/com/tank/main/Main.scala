package com.tank.main

import com.tank.unit.Node

object Main extends App {
  val p1:Node[String] = Node("1", "this is parent node 1")
  val p2:Node[String] = Node("2", "this is parent node 2")
  val c1:Node[String] = Node("5200","3", "this child node 3")
  val c2:Node[String] = Node("6200","4", "this child node 4")
  p1.addChildren(p2)
  p2.addChildren(c1)
  p1.addChildren(c2)

  val node = p1.find("2")
  println(node)
}




