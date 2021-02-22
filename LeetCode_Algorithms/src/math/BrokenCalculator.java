package math;

import java.util.Stack;

public class BrokenCalculator {

    public int brokenCalc(int x, int y) {
        if(x >= y) return x - y;
        int count = 0;
        while(y > x) {
            if(y % 2 == 0) {
                y = y / 2;
            } else {
                y++;
            }
            count ++;
        }
        return count + x - y;
    }

    public static void main(String[] args) {
        BrokenCalculator b = new BrokenCalculator();
        System.out.println(b.brokenCalc(5, 8));
        System.out.println(b.brokenCalc(3, 10));
        System.out.println(b.brokenCalc(1, 1000000000));
    }

}
