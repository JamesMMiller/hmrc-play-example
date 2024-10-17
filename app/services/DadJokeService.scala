package services

import javax.inject.{Inject, Singleton}
import connectors.DadJokeConnector
import uk.gov.hmrc.http.HeaderCarrier
import scala.concurrent.{ExecutionContext, Future}
import models.DadJoke

@Singleton
class DadJokeService @Inject()(connector: DadJokeConnector)(implicit ec: ExecutionContext) {
  def getRandomJoke()(implicit hc: HeaderCarrier): Future[String] = {
    connector.getRandomJoke().map(_.joke)
  }
}
