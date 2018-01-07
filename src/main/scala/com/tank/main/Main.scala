package com.tank.main

import java.util.concurrent.atomic.AtomicInteger

import com.tank.unit.Node

object Main extends App {
  val keyGenerator = new AtomicInteger(1)

  implicit def int2Str(n: Int): String = n.toString

  val p1: Node[String] = Node(keyGenerator.getAndIncrement(), "this is parent node 1")
  val p2: Node[String] = Node(keyGenerator.getAndIncrement(), "this is parent node 2")
  val c1: Node[String] = Node("5200", keyGenerator.getAndIncrement(), "this child node 3")
  val c2: Node[String] = Node("6200", keyGenerator.getAndIncrement(), "this child node 4")
  val c3: Node[String] = Node("6600", keyGenerator.getAndIncrement(), "this child node 5")
  p1.addChildren(p2)
  p2.addChildren(c1)
  p2.addChildren(c3)
  p1.addChildren(c2)
  p1.display()
  val node = p1.find("2")
  println(node)  


}




