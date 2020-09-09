package twopointer;

import java.util.Arrays;

public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int p1 = 0;
        int p2 = 0;
        while(p1 < v1.length || p2 < v2.length) {
            int digit1 = p1 >= v1.length ? 0 : Integer.valueOf(v1[p1]);
            int digit2 = p2 >= v2.length ? 0 : Integer.valueOf(v2[p2]);

            if(digit1 > digit2)
                return 1;
            else if(digit1 < digit2)
                return -1;
            else {
                p1++;
                p2++;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        CompareVersionNumbers c = new CompareVersionNumbers();
        System.out.print(c.compareVersion("0.1", "1.1"));

    }
}
