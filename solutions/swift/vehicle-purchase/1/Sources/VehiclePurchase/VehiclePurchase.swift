func canIBuy(vehicle: String, price: Double, monthlyBudget: Double) -> String {
  let monthlyPrice = price / 60
  if monthlyPrice <= monthlyBudget {
    return "Yes! I'm getting a \(vehicle)"
  }

  if monthlyPrice <= monthlyBudget * 1.1 {
    return "I'll have to be frugal if I want a \(vehicle)"
  }

  return "Darn! No \(vehicle) for me"
}

func licenseType(numberOfWheels wheels: Int) -> String {
  switch wheels {
    case 2, 3: "You will need a motorcycle license for your vehicle"
    case 4, 6: "You will need an automobile license for your vehicle"
    case 18: "You will need a commercial trucking license for your vehicle"
    default: "We do not issue licenses for those types of vehicles"
  }
}

func calculateResellPrice(originalPrice: Int, yearsOld: Int) -> Int {
 let rate  = switch yearsOld {
  case 0..<3: 0.8
  case 3..<10: 0.7
  default: 0.5
 }

 return Int(Double(originalPrice) * rate)
}
