package array;

public class MaximumPointsYouCanObtainfromCards {

    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length - k;
        int totalSum = 0;
        for(int p : cardPoints)
            totalSum += p;

        long sum = 0;
        long minSum = Integer.MAX_VALUE;
        for(int i=0; i<cardPoints.length; i++) {
            sum  = sum + cardPoints[i];

            int j = i - n;
            if(j == -1) {
                minSum = Math.min(sum, minSum);
            } else if (j >= 0) {
                sum = sum - cardPoints[j];
                minSum = Math.min(sum, minSum);
            }
        }
        return totalSum - (int)minSum;
    }

    public static void main(String[] args) {
        MaximumPointsYouCanObtainfromCards p = new MaximumPointsYouCanObtainfromCards();
        int[] a = new int[] {1,2,3,4,5,6,1};
        System.out.println(p.maxScore(a, 3));
    }
}
