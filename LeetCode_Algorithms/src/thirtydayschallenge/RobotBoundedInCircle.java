package thirtydayschallenge;

public class RobotBoundedInCircle {

    public boolean isRobotBounded(String instructions) {
        if(instructions == null || instructions.length() == 0) return true;
        Robot robot = new Robot();
        for(char instruction : instructions.toCharArray()){
            robot.action(instruction);
        }

        if(robot.x == 0 && robot.y == 0) return true;
        if(robot.direction == 0) return false;
        else return true;
    }

    class Robot {
        char[] directions = new char[]{'N', 'E', 'S', 'W'};
        int direction;
        int x;
        int y;
        public Robot() {
            this.direction = 0;
            this.x = 0;
            this.y = 0;
        }

        public void action(char instruction) {
            if(instruction == 'G'){
                if(directions[this.direction] == 'N'){
                    this.y ++;
                }else if(directions[this.direction] == 'S'){
                    this.y--;
                }else if(directions[this.direction] == 'E'){
                    this.x++;
                }else if(directions[this.direction] == 'W'){
                    this.x--;
                }
            }else {
                if(instruction == 'L'){
                    direction --;
                    if(direction < 0)
                        direction = 3;
                }else if(instruction == 'R'){
                    direction ++;
                    if(direction >= directions.length)
                        this.direction = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        RobotBoundedInCircle r = new RobotBoundedInCircle();
        System.out.println(r.isRobotBounded("GG"));
    }
}
