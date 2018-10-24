package sh.locus.interview.custom.util;

import java.util.Arrays;

public class ArrayUtils {

    public static int longestRow(int[][] array) {
        return Arrays.stream(array).map(row -> row.length).max(Integer::compare).orElse(0);
    }
}
