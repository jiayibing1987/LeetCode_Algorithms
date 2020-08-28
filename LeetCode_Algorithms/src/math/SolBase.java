package math;

import java.util.Random;

public class SolBase {

    public int rand10() {
        int a, b, index;
        do {
            a = rand7();
            b = rand7();
            index = b + (a-1) * 7;
        }while(index > 40);
        return (index -1) % 10 + 1;
    }

    public int rand7() {
        return new Random().nextInt(8);
    }
}
