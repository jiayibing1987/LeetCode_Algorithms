package binarysearchtree;

public class ArrangingCoins {

    public int arrangeCoins(int n) {
        if(n <=0) return 0;
        long low = 1;
        long high = n;
        long cur;
        long mid;
        while(low < high) {
            mid = low + (high-low) / 2;
            cur = calc(mid);
            if(cur == n) return (int)mid;

            if(cur < n)
                low = mid + 1;
            if(cur > n)
                high = mid - 1;
        }
        return (int) (calc(low) < n ? low : low - 1);
    }

    private long calc (long n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        System.out.println(new ArrangingCoins().arrangeCoins(5));
    }
}
