package controllers

import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.test._
import play.api.test.Helpers._
import play.api.inject.guice.GuiceApplicationBuilder
import models.TaxCalculation

class TaxCalculatorControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting {

  // Override app if you need to add any additional configuration
  override def fakeApplication() = GuiceApplicationBuilder()
    .configure("play.filters.disabled" -> List("play.filters.csrf.CSRFFilter"))
    .build()

  "TaxCalculatorController GET" should {

    "render the tax calculator page" in {
      val controller = inject[TaxCalculatorController]
      val result = controller.showCalculator().apply(FakeRequest(GET, "/tax-calculator"))

      status(result) mustBe OK
      contentType(result) mustBe Some("text/html")
      contentAsString(result) must include("Calculate Your Tax")
    }

    "render the tax calculator page from the router" in {
      val request = FakeRequest(GET, "/tax-calculator")
      val result = route(app, request).get

      status(result) mustBe OK
      contentType(result) mustBe Some("text/html")
      contentAsString(result) must include("Calculate Your Tax")
    }
  }

  "TaxCalculatorController POST" should {

    "calculate tax correctly and render result page" in {
      val controller = inject[TaxCalculatorController]
      val request = FakeRequest(POST, "/calculate")
        .withFormUrlEncodedBody("income" -> "100000")
      val result = controller.calculateTax().apply(request)

      status(result) mustBe OK
      contentType(result) mustBe Some("text/html")
      contentAsString(result) must include("Tax Calculation Result")
      contentAsString(result) must include("£27432.00") // Expected tax for £100,000 income
    }

    "return BadRequest for invalid input" in {
      val controller = inject[TaxCalculatorController]
      val request = FakeRequest(POST, "/calculate")
        .withFormUrlEncodedBody("income" -> "invalid")
      val result = controller.calculateTax().apply(request)

      status(result) mustBe BAD_REQUEST
      contentType(result) mustBe Some("text/html")
      contentAsString(result) must include("Calculate Your Tax")
    }
  }
}
