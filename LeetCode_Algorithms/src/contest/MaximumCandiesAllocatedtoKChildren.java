package contest;

import java.util.Arrays;

public class MaximumCandiesAllocatedtoKChildren {

    public int maximumCandies(int[] candies, long k) {
        long sum = 0;
        for(int c : candies)
            sum += c;
        if(sum < k) return 0;

        int n = candies.length;
        Arrays.sort(candies);
        long low = 1;
        long high = candies[n - 1];

        while(low <= high) {
            long mid = low + (high - low) / 2;
            long numOfChildren = getnumberOfChildren(candies, mid);
            long oneMoreCandy = getnumberOfChildren(candies, mid + 1);

            if(numOfChildren >= k &&  oneMoreCandy < k)
                return (int)mid;

            if(numOfChildren >= k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int)high;
    }

    private long getnumberOfChildren(int[] candies, long a) {
        long res = 0;
        for(int i = candies.length - 1; i >= 0; i --) {
            int cur = candies[i];
            if(cur >= a){
                res += cur / a;
            } else
                break;
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumCandiesAllocatedtoKChildren m = new MaximumCandiesAllocatedtoKChildren();
        int[] c1 = new int[] {5,8,6};
        System.out.println(m.maximumCandies(c1, 3));

        int[] c2 = new int[] {5,6,4,10,10,1,1,2,2,2};
        System.out.println(m.maximumCandies(c2, 9));
    }
}
