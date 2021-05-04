package array;

public class NondecreasingArray {

    //nums[i] <= nums[i + 1]
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        int count = 0;
        if(n <= 2) return true;

        for(int i = 0; i < n - 1; i++) {
            if(nums[i] > nums[i+1]) {
                if(i == 0 || i == n - 2) {
                    count ++;
                } else {
                    //i needs to be fixed, e.g. -1,4,2,3, i == 1
                    if (nums[i + 1] >= nums[i - 1]) {
                        nums[i] = nums[i - 1];
                    } else { //try to fix i+1, e.g. 5,7,1,8, i == 1
                        nums[i + 1] = nums[i];
                    }
                    count++;
                }
                if(count == 2) return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        NondecreasingArray n = new NondecreasingArray();
        int[] a = {5,7,1,8};
        int[] b = {-1,4,2,3};
        System.out.println(n.checkPossibility(a));
        System.out.println(n.checkPossibility(b));
    }
}
