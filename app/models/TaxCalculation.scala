package models

case class TaxCalculation(income: BigDecimal, taxAmount: BigDecimal)

object TaxCalculator {
  def calculate(income: BigDecimal): TaxCalculation = {
    val taxAmount = income match {
      case i if i <= 12570 => BigDecimal(0)
      case i if i <= 50270 => (i - 12570) * 0.2
      case i if i <= 150000 => (i - 50270) * 0.4 + 7540
      case i => (i - 150000) * 0.45 + 47432
    }
    TaxCalculation(income, taxAmount.setScale(2, BigDecimal.RoundingMode.HALF_UP))
  }
}