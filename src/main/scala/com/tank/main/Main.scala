package com.tank.main

import com.tank.unit.Node

object Main extends App {
  val p1 = Node("1", "this is parent node")
  val p2 = Node("2", "this is parent node")
  val c1 = Node("5200","3", "this child node 3")
  val c2 = Node("6200","4", "this child node 3")
  p1.addChildren(p2)
  p1.addChildren(c1)
  p2.addChildren(c2)
  val node = p1.find("2")
  println(node)
}




