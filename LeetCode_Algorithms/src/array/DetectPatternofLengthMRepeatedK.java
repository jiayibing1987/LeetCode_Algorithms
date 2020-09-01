package array;

/**
 * 1566. Detect Pattern of Length M Repeated K or More Times
 */
public class DetectPatternofLengthMRepeatedK {

    // 1 2 1 2 1 1 3  m=2 k=2
    public boolean containsPattern(int[] arr, int m, int k) {
        int count = 0;
        for(int i=0; i<arr.length - m; i++) {
            if(arr[i] == arr[i+m])
                count ++;
            else
                count = 0;
            if(count == m * (k-1)) return true;
        }
        return false;
    }

}
