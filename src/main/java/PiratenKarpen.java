import pk.Dice;
import pk.Faces;

import java.util.ArrayList;

public class PiratenKarpen {

    public static ArrayList<String> Roll8(){
        ArrayList<String> Rolls = new ArrayList<String>();
        Dice myDice = new Dice();
        for (int i = 0; i <= 7; i++) {
            Rolls.add(myDice.roll().toString());
        }
        return Rolls;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Piraten Karpen Simulator!");
        System.out.println("I'm rolling a dice");
        Dice myDice = new Dice();
        System.out.println(myDice.roll());
        System.out.println("That's all folks!");
        System.out.println("I'm rolling 8 dice");
        ArrayList<String> Rolls = Roll8();
        System.out.println(Rolls);
    }
    
}
