func getName(_ item: (name: String, amount: Int)) -> String {
  item.name
}

func createToy(name: String, amount: Int) -> (name: String, amount: Int) {
  (name, amount)
}

func updateQuantity(_ items: [(name: String, amount: Int)], toy: String, amount: Int) ->  [(name: String, amount: Int)] {
  guard let index = items.firstIndex(where: { $0.name == toy }) else { return items }
  var toys = items
  toys[index] = (toy, amount)
  
  return toys
}

func addCategory(_ items: [(name: String, amount: Int)], category: String) -> [(name: String, amount: Int, category: String)] {
  items.map { ($0.name, $0.amount, category) }
}
