package com.tank.main

import com.tank.unit.Node

object Main extends App {
  val parentId = "1"
  val parentNode = Node(parentId, "this is parent node")
  val childId = "2"
  val data = "7900"
  val childNode = Node(data, childId, "this is child node")
  parentNode.addChildren(childNode)
  parentNode.display()
}




