import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.Collections.reverseOrder;
import static java.util.stream.Stream.iterate;

class DiamondPrinter {

    List<String> printToList(char a) {
        var rowLength = (a - 'A') * 2 + 1;
        var center = Math.ceilDiv(rowLength, 2);

        var forward = iterate('A', i -> (char) (i + 1))
            .limit((a - 'A') + (long) 1);

        var backwards = iterate('A', i -> (char) (i + 1))
            .limit((long) a - 'A')
            .sorted(reverseOrder());

        return Stream.concat(forward, backwards)
            .map(toRow(rowLength, center))
            .toList();
    }

    private static Function<Character, String> toRow(int rowLength, int center) {
        return i -> {
            var row = new StringBuilder(" ".repeat(rowLength));

            var index = center - (i - 'A') - 1;
            row.replace(index, index + 1, String.valueOf(i));

            index = i - 'A';
            if (index > 0) {
                row.replace(center + index - 1, center + index, String.valueOf(i));
            }

            return row.toString();
        };
    }
}
