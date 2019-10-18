package com.gvolpe.api

import cats.data.Kleisli
import cats.effect._
import cats.implicits._
import com.gvolpe.api.service.{HomeService, ProductService, UserService}
import org.http4s.{Request, Response}
import org.http4s.implicits._
import org.http4s.server.Router
import org.http4s.server.blaze._

object Api extends IOApp {

  private val httpApp: Kleisli[IO, Request[IO], Response[IO]] =
    Router("/" -> HomeService(), "/users" -> UserService(), "/products" -> ProductService()).orNotFound

  def run(args: List[String]): IO[ExitCode] =
    BlazeServerBuilder[IO]
      .bindHttp(8080, "localhost")
      .withHttpApp(httpApp)
      .serve
      .compile
      .drain
      .as(ExitCode.Success)

  //  BlazeBuilder.bindHttp(8080)
  //    .mountService(HomeService(), "/")
  //    .mountService(UserService(), "/users")
  //    .mountService(ProductService(), "/products")
  //    .mountService(StreamingService(), "/streaming")
  //    .mountService(WsService(), "/ws")
  //    .run
  //    .awaitShutdown()

}
