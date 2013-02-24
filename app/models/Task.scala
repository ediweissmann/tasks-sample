package models

import org.squeryl.KeyedEntity

/**
 * Stay organized! Keep track of tasks
 */
case class Task(id: Long = 0, title: String) extends KeyedEntity[Long]
