func dailyRateFrom(hourlyRate: Int) -> Double {
  Double(hourlyRate) * 8.0
}

func monthlyRateFrom(hourlyRate: Int, withDiscount discount: Double) -> Double {
  let monthlyRate = dailyRateFrom(hourlyRate: hourlyRate) * 22.0

  return applyDiscount(to: monthlyRate, discount: discount).rounded() 
}

func workdaysIn(budget: Double, hourlyRate: Int, withDiscount discount: Double) -> Double {
  let days = budget / applyDiscount(to: dailyRateFrom(hourlyRate: hourlyRate), discount: discount)
  return days.rounded(.down)
}

func applyDiscount(to rate: Double, discount: Double) -> Double {
  rate * (1 - (discount / 100.0)) 
}
