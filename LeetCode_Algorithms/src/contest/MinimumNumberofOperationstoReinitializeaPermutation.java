package contest;

import java.util.Arrays;

public class MinimumNumberofOperationstoReinitializeaPermutation {

    public int reinitializePermutation(int n) {
        int[] original = new int[n];
        for (int i = 0; i < n; i++) {
            original[i] = i;
        }

        int[] perm = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = original[i];
        }

        int count = 0;
        do {
            int[] arr = new int[n];
            count++;
            doOperation(arr, perm);
            if (Arrays.equals(original, arr)) break;
            perm = arr;
        } while (true);

        return count;
    }

    private void doOperation(int[] arr, int[] perm) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                arr[i] = perm[i / 2];
            } else {
                arr[i] = perm[n / 2 + (i - 1) / 2];
            }
        }
    }

    public static void main(String[] args) {
        MinimumNumberofOperationstoReinitializeaPermutation m = new MinimumNumberofOperationstoReinitializeaPermutation();
        System.out.println(m.reinitializePermutation(2));
        System.out.println(m.reinitializePermutation(4));
        System.out.println(m.reinitializePermutation(6));
    }

}
