package dao

trait Repositories {

  val tasks: TasksRepository = new SquerylTaskRepository
}
