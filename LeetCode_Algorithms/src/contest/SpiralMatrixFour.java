package contest;

import util.ListNode;

import java.util.Arrays;

public class SpiralMatrixFour {

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int r = 0;
        int c = 0;
        String[] directions = new String[]{"right", "down", "left", "up"};
        int p = 0;

        int[][] res = new int[m][n];
        for (int[] row : res)
            Arrays.fill(row, -1);

        ListNode cur = head;
        while (cur != null) {
            if (directions[p].equals("right")) {
                if (c >= n || res[r][c] != -1) {
                    c--;
                    r++;
                    p = (p + 1) % 4;
                } else {
                    res[r][c ++] = cur.val;
                }
            } else if (directions[p].equals("down")) {
                if (r >= m || res[r][c] != -1) {
                    r--;
                    c--;
                    p = (p + 1) % 4;
                } else {
                    res[r++][c] = cur.val;
                }
            } else if (directions[p].equals("left")) {

                if (c < 0 || res[r][c] != -1) {
                    c++;
                    r++;
                    p = (p + 1) % 4;
                } else {
                    res[r][c--] = cur.val;
                }
            } else if (directions[p].equals("up")) {
                if (r < 0 || res[r][c] != -1) {
                    r++;
                    c++;
                    p = (p + 1) % 4;
                } else {
                    res[r--][c] = cur.val;
                }
            }
            cur = cur.next;
        }
        return res;
    }

}
