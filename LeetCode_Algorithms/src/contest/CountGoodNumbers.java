package contest;

public class CountGoodNumbers {

    long m = 1000000000 + 7;
    public int countGoodNumbers(long n) {
        long odd_constant = 4;
        long even_constant = 5;

        long odd;
        long even;
        if(n % 2 == 0) {
            odd = n / 2;
            even = odd;
        }else {
            odd = n / 2;
            even = odd + 1;
        }

        long odd_total = power(odd_constant, odd);
        long even_total = power(even_constant, even) ;

        return  (int)((odd_total * even_total) % m);
    }

    private long power(long base, long p) {
        if(p == 0)
            return 1;
        if(p == 1)
            return base;
        long ans = power(base, p / 2);
        ans = ans * ans;
        ans %= m;
        if(p % 2 != 0)
            ans *= base;

        return ans % m;
    }

    public static void main(String[] args) {
        CountGoodNumbers c = new CountGoodNumbers();
        //System.out.println(c.countGoodNumbers(4));
        System.out.println(c.countGoodNumbers(50));
        //System.out.println(c.countGoodNumbers(100000000000000L));
    }
}
