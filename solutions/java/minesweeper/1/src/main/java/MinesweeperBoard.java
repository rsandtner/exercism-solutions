import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

record MineIndex(int row, int col) {

}

class MinesweeperBoard {

    private final int rows;
    private final int columns;

    private List<MineIndex> mineIndex;

    MinesweeperBoard(List<String> boardRows) {
        this.rows = boardRows.size();
        if (this.rows == 0) {
            this.columns = 0;
        }
        else {
            this.columns = boardRows.getFirst().length();
        }

        this.mineIndex = new ArrayList<>();
        for (int i = 0; i < boardRows.size(); i++) {
            var row = boardRows.get(i).toCharArray();
            for (int j = 0; j < row.length; j++) {
                if (row[j] == '*') {
                    mineIndex.add(new MineIndex(i, j));
                }
            }
        }
    }

    List<String> withNumbers() {
        if (rows == 0) {
            return List.of();
        }

        var result = new ArrayList<String>();
        for (int row = 0; row < rows; row++) {
            var rowWithNumbers = new StringBuilder(columns);
            for (int col = 0; col < columns; col++) {
                var count = 0;
                boolean isMine = false;
                for (var mineIndex : mineIndex) {
                    if (mineIndex.col() == col && mineIndex.row() == row) {
                        rowWithNumbers.append("*");
                        isMine = true;
                        break;
                    }

                    // check column before and after
                    if (mineIndex.row() == row && (mineIndex.col() == col - 1 || mineIndex.col() == col + 1)) {
                        count++;
                        continue;
                    }

                    // check previous row
                    if ((mineIndex.row() == row - 1 || mineIndex.row() == row + 1) && (mineIndex.col() == col - 1 || mineIndex.col() == col + 1 || mineIndex.col() == col)) {
                        count++;
                    }
                }
                if (isMine) {
                    continue;
                }
                if (count == 0) {
                    rowWithNumbers.append(" ");
                }
                else {
                    rowWithNumbers.append(count);
                }
            }
            result.add(rowWithNumbers.toString());
        }

        return result;
    }
}
