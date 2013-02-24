package dao

import org.squeryl.Schema
import models.Task

object AppDB extends Schema {
  val tasksTable = table[Task]("tasks")
}
