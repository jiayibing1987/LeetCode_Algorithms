package math;

public class NumbersAtMostNGivenDigitSet {

    public int atMostNGivenDigitSet(String[] digits, int n) {
        String number = String.valueOf(n);

        int a = processLesserDigit(digits, number);
        int b = processSameDigit(digits, number, 0);
        return a + b;
    }

    private int processSameDigit(String[] digits, String number, int index) {
        if(index >= number.length()) return 1;
        int res = 0;
        int curDigit = Character.getNumericValue(number.charAt(index));
        for (int i = 0; i < digits.length; i++) {
            int candidate_digit = Integer.valueOf(digits[i]);
            if(candidate_digit < curDigit) {
                int left = number.length() - 1 - index;
                int temp = (int)Math.pow(digits.length, left);
                res += temp;
            } else if(candidate_digit == curDigit) {
                res += processSameDigit(digits, number, index+1);
            }
        }
        return res;
    }

    //pick i (from 1 to n-1)number to make permutation from digits.length
    private int processLesserDigit(String[] digits, String number) {
        int numberOfDigits = digits.length;
        int res = 0;
        for (int i = 1; i <= number.length() - 1; i++) {
            res += calcPerm(i, numberOfDigits);
        }
        return res;
    }

    private int calcPerm(int m, int n) {
        return (int)Math.pow(n, m);
    }

    public static void main(String[] args) {
        NumbersAtMostNGivenDigitSet a = new NumbersAtMostNGivenDigitSet();
        String[] d1 = {"7"};
        int n1 = 8;
        //System.out.println(a.atMostNGivenDigitSet(d1, n1));

        String[] d2 = {"1","3","5","7"};
        int n2 = 100;
        System.out.println(a.atMostNGivenDigitSet(d2, n2));

        String[] d3 = {"1","4", "9"};
        int n3 = 1000000000;
        System.out.println(a.atMostNGivenDigitSet(d3, n3));
    }
}
