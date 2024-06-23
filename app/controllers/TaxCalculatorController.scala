package controllers

import javax.inject._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models.{TaxCalculator, TaxCalculation}
import play.api.i18n._

@Singleton
class TaxCalculatorController @Inject()(
    override val controllerComponents: MessagesControllerComponents,
    taxCalculatorView: views.html.taxCalculator,
    taxResultView: views.html.taxResult
) extends MessagesAbstractController(controllerComponents) {

  val taxForm = Form(
    "income" -> bigDecimal
  )

  def showCalculator() = Action { implicit request: MessagesRequest[AnyContent] =>
    Ok(taxCalculatorView(taxForm))
  }

  def calculateTax() = Action { implicit request: MessagesRequest[AnyContent] =>
    taxForm.bindFromRequest().fold(
      formWithErrors => {
        BadRequest(taxCalculatorView(formWithErrors))
      },
      income => {
        val calculation = TaxCalculator.calculate(income)
        Ok(taxResultView(calculation))
      }
    )
  }
}