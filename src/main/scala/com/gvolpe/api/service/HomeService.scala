package com.gvolpe.api.service

import cats.effect._
import org.http4s.HttpRoutes
import org.http4s.dsl.io._

object HomeService {

  def apply(): HttpRoutes[IO] = service

  private val service = HttpRoutes.of[IO] {
    case GET -> Root =>
      Ok("Http4s API")
  }

}
