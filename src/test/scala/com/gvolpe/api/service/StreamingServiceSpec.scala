package com.gvolpe.api.service

import org.http4s.{Request, Status, Uri}

class StreamingServiceSpec extends HttpServiceSpec {

  "Streaming Service" should {

    val service = StreamingService()

    "Not find the unknown url request" in {
      val request = new Request(uri = Uri(path = "/unknown"))
      val response = service.run(request).run

      response.status should be (Status.NotFound)
    }

    "Get the streaming data sample" in {
      val request = new Request()
      val response = service.run(request).run

      response.status should be (Status.Ok)
      response.body.asString should (include ("Starting stream intervals") and include ("Current system time"))
    }

    "Get the task delay message" in {
      val request = new Request(uri = Uri(path = "/delay"))
      val response = service.run(request).run

      response.status should be (Status.Ok)
      response.body.asString should be ("Hola!")
    }

    "Get the range of numbers" in {
      val request = new Request(uri = Uri(path = "/range"))
      val response = service.run(request).run

      response.status should be (Status.Ok)
      response.body.asString should be ("(0,10)(10,20)(20,30)(30,40)(40,50)(50,60)(60,70)(70,80)(80,90)(90,100)")
    }

    "Get the random numbers response" in {
      val request = new Request(uri = Uri(path = "/task"))
      val response = service.run(request).run

      response.status should be (Status.Ok)
    }

  }

}
