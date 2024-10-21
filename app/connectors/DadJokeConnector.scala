package connectors

import javax.inject.{Inject, Singleton}
import uk.gov.hmrc.http.client.HttpClientV2
import uk.gov.hmrc.http.{HeaderCarrier, StringContextOps}
import uk.gov.hmrc.http.HttpReads.Implicits._
import scala.concurrent.{ExecutionContext, Future}
import play.api.libs.json._
import models.DadJoke

@Singleton
class DadJokeConnector @Inject()(httpClient: HttpClientV2)(implicit ec: ExecutionContext) {
  private val apiUrl = "https://icanhazdadjoke.com"

  implicit val dadJokeReads: Reads[DadJoke] = Json.reads[DadJoke]

  def getRandomJoke()(implicit hc: HeaderCarrier): Future[DadJoke] = {
    httpClient.get(url"$apiUrl")
      .setHeader("Accept" -> "application/json")
      .execute[DadJoke]
  }
}
