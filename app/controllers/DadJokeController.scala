package controllers

import javax.inject._
import play.api.mvc._
import services.DadJokeService
import scala.concurrent.ExecutionContext
import uk.gov.hmrc.play.http.HeaderCarrierConverter

@Singleton
class DadJokeController @Inject()(
    override val controllerComponents: MessagesControllerComponents,
    dadJokeService: DadJokeService,
    dadJokeView: views.html.dadJoke
)(implicit ec: ExecutionContext) extends MessagesAbstractController(controllerComponents) {

  def showJoke(): Action[AnyContent] = Action.async { implicit request =>
    implicit val hc = HeaderCarrierConverter.fromRequestAndSession(request, request.session)
    dadJokeService.getRandomJoke().map { joke =>
      Ok(dadJokeView(joke))
    }
  }

  def newJoke(): Action[AnyContent] = Action.async { implicit request =>
    implicit val hc = HeaderCarrierConverter.fromRequestAndSession(request, request.session)
    dadJokeService.getRandomJoke().map { joke =>
      Ok(joke)
    }
  }
}
