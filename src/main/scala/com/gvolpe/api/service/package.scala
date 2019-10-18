package com.gvolpe.api

import io.circe.Json
import org.http4s.headers.{`Content-Type`, `Transfer-Encoding`}
import org.http4s._
import play.api.libs.json.{JsValue, Json}

import scala.collection.parallel.Task

package object service {

  case class User(id: Long, name: String, email: String)
  case class Product(id: Long, name: String)

//  implicit class ChunkedResponse(response: Task[Response]) {
//    def chunked: Task[Response] = {
//      response.putHeaders(`Transfer-Encoding`(TransferCoding.chunked))
//    }
//  }

}
