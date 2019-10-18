package com.gvolpe.api.service

import cats.effect._
import io.circe.generic.auto._
import io.circe.syntax._
import org.http4s.HttpRoutes
import org.http4s.dsl.io._
import org.http4s.circe._

object ProductService {

  def apply(): HttpRoutes[IO] = service

  private val service = HttpRoutes.of[IO] {
    case GET -> Root =>
      val products = List(Product(1, "Book"), Product(2, "Calc"), Product(3, "Guitar")).asJson
      Ok(products)
    case GET -> Root / id =>
      Ok(Product(id.toLong, s"Name#$id").asJson)
  }

}
