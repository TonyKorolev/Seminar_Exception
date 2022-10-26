package Seminars.Seminar2;

import java.util.Arrays;

public class homework_001 {
    public static void main(String[] args) {
        String[][] array = { { "3", "1", "2", "4", "5" }, { "a", "b", "c", "d", "a" }, { "e", "f", "g", "h", "45" } };
        System.out.println(Arrays.deepToString(array));
        int sum = sum2d(array);
        System.out.println(sum);
    }

    public static int sum2d(String[][] a) {
        int s = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < 5; j++) {
                if (a[i][j] == "0") {
                    throw new RuntimeException("В исходном массиве битые значения!");
                }
                try {
                    int val = Integer.parseInt(a[i][j]);
                    s += val;
                } catch (NumberFormatException e) {
                    // System.err.println("Неправильный формат строки!");
                } finally {
                    int val = 0;
                    s += val;
                }
            }
        }
        return s;
    }
}
