package math;

/**
 * Given two numbers, hour and minutes. Return the smaller angle (in degrees) formed between the hour and the minute hand.
 */
public class AngleBetweenHandsofaClock {

    public double angleClock(int hour, int minutes) {
        if(hour >=12) hour -= 12;
        double min = (double) minutes / 60.0;
        double hr = (double) hour / 12 + min *(1.0 / 12.0);
        double diff = Math.abs(min - hr);
        double angle = 360 * diff;
        if(angle > 180.0) angle = 360 - angle;
        return angle;
    }

}
