package contest;

public class TheNumberofFullRounds {

    public int numberOfRounds(String startTime, String finishTime) {
        String[] start = startTime.split(":");
        String[] end = finishTime.split(":");

        int startHour = Integer.parseInt(start[0]);
        int startMinute = adjustMinute(Integer.parseInt(start[1]), true);
        if(startMinute == 0 && !start[1].equals("00")) {
            startHour ++;
        }

        int endHour = Integer.parseInt(end[0]);
        int endMinute = adjustMinute(Integer.parseInt(end[1]), false);

        if(startHour == endHour && startMinute == endMinute)
            return 0;

        boolean isOvernight = startHour > endHour || (startHour == endHour && startMinute > endMinute);

        int hours_diff;
        if(isOvernight) {
            hours_diff = 24 - startHour;
            hours_diff += endHour;
        } else {
            hours_diff = endHour - startHour;
        }

        int minutes_diff = (endMinute - startMinute ) / 15;
        return hours_diff * 4 + minutes_diff;
    }

    private int adjustMinute(int m, boolean isStart) {
        if(m % 15 == 0) return m;
        if(isStart) {
            m += 15;
        }
        return m >= 60 ? 0 : m - (m % 15);
    }


    public static void main(String[] args) {
        TheNumberofFullRounds r = new TheNumberofFullRounds();
        System.out.println(r.numberOfRounds("12:01", "12:44"));
    }
}
