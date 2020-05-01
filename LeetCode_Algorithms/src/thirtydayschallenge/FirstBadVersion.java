package thirtydayschallenge;

public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        while(low <= high) {
            int mid = low + (high- low)/ 2;
            if(isBadVersion(mid)){
                if(low == high) return low;
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

    boolean isBadVersion(int version){
        return false;
    }
}
