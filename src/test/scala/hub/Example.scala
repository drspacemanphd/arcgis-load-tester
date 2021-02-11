package hub

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class Example extends Simulation {

  val httpProtocol = http
    .baseUrl("https://arcgis.com")
  
  val scn = scenario("Perform a search")
    .exec(http("perform a search using the ArcGIS Rest API")
      .post("/sharing/rest/search/")
      .headers(Map(
        "Content-Type" -> "application/json"
      ))
      .body(RawFileBody("example.json")).asJson
    )
  
  setUp(
    scn.inject(
      constantUsersPerSec(1).during(1.seconds)
    )
  .protocols(httpProtocol))
}