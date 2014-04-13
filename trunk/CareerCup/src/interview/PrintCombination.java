package interview;

import java.util.Arrays;

public class PrintCombination {

    public static void main(String[] args) {
        int[] a = { 1, 2, 3 };
        for (int i = 1; i <= a.length; i++) {
            printCombo(a, new int[i], 0, 0, i);
        }
    }

    public static void printCombo(int[] a, int[] result, int pos, int start, int comboLength) {
        if (pos == comboLength) {
            System.out.println(Arrays.toString(result));
            return;
        }
        for (int i = start; i < a.length; i++) {
            result[pos] = a[i];
            printCombo(a, result, pos + 1, i + 1, comboLength);

        }
    }

}
