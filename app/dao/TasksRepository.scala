package dao

import org.squeryl.PrimitiveTypeMode._
import AppDB._
import models.Task

trait TasksRepository {
  def remove(id: Long)
  def add(title: String): Task
  def list(): Seq[Task]
}

class SquerylTaskRepository extends TasksRepository {
  override def list() = inTransaction {
    from(tasksTable)(row => select(row))
      .toList.reverse
  }

  override def add(title: String): Task = inTransaction {
    tasksTable insert Task(title = title)
  }

  override def remove(id: Long) {
    inTransaction {
      tasksTable.delete(id)
    }
  }
}
