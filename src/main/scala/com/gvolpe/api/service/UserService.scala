package com.gvolpe.api.service

import cats.effect._
import org.http4s.HttpRoutes
import org.http4s.dsl.io._
import io.circe.generic.auto._
import io.circe.syntax._

object UserService {

  def apply(): HttpRoutes[IO] = service

  private val service = HttpRoutes.of[IO] {
    case GET -> Root =>
      val users = List(User(1, "user1", "user1@mail.com"), User(2, "user2", "user2@mail.com"))
      Ok(users.asJson.toString)
    case GET -> Root / id =>
      Ok(User(id.toLong, s"User$id", s"user$id@mail.com").asJson.toString)
  }

}
