let ranks = 1...8
let files = "A"..."H"

func isValidSquare(rank: Int, file: String) -> Bool {
  ranks.contains(rank) && files.contains(file)
}

func getRow(_ board : [String], rank: Int) -> [String] {
  let row = rank - 1;
  let start = row * 8
  let end = start + 7
  return Array(board[start...end])
}
