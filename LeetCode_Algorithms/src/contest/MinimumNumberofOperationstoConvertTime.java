package contest;

public class MinimumNumberofOperationstoConvertTime {

    public int convertTime(String current, String correct) {
        int c1 = covertMins(current);
        int c2 = covertMins(correct);

        int diff = c2 - c1;
        int op = 0;
        while(diff > 0) {
            if(diff >= 60) {
                op += diff / 60;
                diff = diff % 60;
            } else if (diff >= 15) {
                op += diff / 15;
                diff = diff % 15;
            }else if (diff >= 5) {
                op += diff / 5;
                diff = diff % 5;
            } else {
                op += diff;
                diff = 0;
            }
        }
        return op;
    }

    private int covertMins(String current) {
        String[] a = current.split(":");
        int hour = Integer.parseInt(a[0]);
        int minuete = Integer.parseInt(a[1]);
        return hour * 60 + minuete;
    }

    public static void main(String[] args) {
        MinimumNumberofOperationstoConvertTime m = new MinimumNumberofOperationstoConvertTime();
        System.out.println(m.convertTime("02:30", "04:35"));
        System.out.println(m.convertTime("11:00", "11:01"));
    }


}
