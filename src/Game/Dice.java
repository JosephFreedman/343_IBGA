package Game;

import java.util.Random;

public class Dice {
    private int roll;

    Dice() {
        Random random = new Random();
        roll = 2 + random.nextInt(10);
    }

    public int getRoll() {
        return roll;
    }
}
