package Game;

import java.util.Random;

public class Dice {
    private int roll;

    public Dice() {
        Random random = new Random();
        roll = 2 + random.nextInt(11);
    }

    public int getRoll() {
        return roll;
    }
}
