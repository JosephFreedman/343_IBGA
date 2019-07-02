package Game;

import java.util.HashMap;

// Represents the attack action in the sequence of play
public class Attack {
    Attack(Group attacker, Group attacked, String typeOfAttack) {
        // If target card is an Illuminati, it cannot be attacked
    }

    public void attackToControl(Group attacker, Group attacked, int money) {
        int attackerPowerBonus = 0;
        // If target card is a Game.Group you already control, it cannot be attacked
        // Attacking Game.Group must have an outward arrow free
        // Aiding Attacks: If a Game.Group does not attack during a turn, it may use its transferable power to aidan attack made by any other Game.Group in its Power Structure. If a Game.Group has two Power numbers separated by a slash (like 5/2), the second number is its transferable power. The UFO's can attack twice per turn. Example: A Game.Group with a power of 6, aided by another Game.Group with a transferable power of 4, is attacking a Game.Group with a resistance of 3. The attacker has a total power of 10 (6 plus 4), and will have to roll a 7 or less (10 minus 3) to succeed.
        // Power Structure Position. If a Game.Group is already controlled by an opponent, it may be harder to control. The closer it is to the Illuminati who control it, the more of a bonus it gets to Resistance (or to Power if someone tries to destroy it). If it is adjacent, it gets a +10! If it is one Game.Group away, it gets a +5. If it is two Groups away, it gets a +2
        // For each identical alignment, add 4 to the attacker's Power. For each opposite alignment, subtract 4 from the attacker's Power
        for (String alignment : attacker.getAlignments()) {
            for (String alignment2 : attacked.getAlignments()) {
                switch (getAlignment(alignment, alignment2)) {
                    case "O":
                        attackerPowerBonus -= 4;
                        break;
                    case "I":
                        attackerPowerBonus += 4;
                        break;
                }
            }
        }
        // Special Powers
        // Spending Money to Game.Attack
        attackerPowerBonus += money;

        // To find the roll required for a successful attack, subtract the defending Game.Group’s Resistance from the attacking Game.Group’s  Power. Example: If a Power of 6 attacks a Resistance of 2, it can succeed only on a roll of 4 or less
        int diceRoll = new Dice().getRoll();
        // Automatic Failure. A roll of 11 or 12 results in automatic failure of the attack
        if (diceRoll > 10) {
            // Automatic Failure
        }
    }

    public void attackToNeutralize() {

    }

    public void attackToDestroy() {

    }

    public String getAlignment(String a, String b) {
        // O = Opposite, I = Identical, N = None

        HashMap<String, String> alignments = new HashMap<>();
        alignments.put("Government", "Communist");
        alignments.put("Communist", "Government");
        alignments.put("Liberal", "Conservative");
        alignments.put("Conservative", "Liberal");
        alignments.put("Peaceful", "Violent");
        alignments.put("Violent", "Peaceful");
        alignments.put("Straight", "Weird");
        alignments.put("Weird", "Straight");
        alignments.put("Fanatic", "Fanatic");

        if(alignments.get(a).equals(b))
            return "O";

        if (a.equals(b))
            return "I";

        return "N";
    }
}
