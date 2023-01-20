package pk;
import java.util.ArrayList;
import java.util.Random;

public class Strategy {
    
    public int Random(ArrayList<String> ReRoll, int Skulls){
         //Initializes Random
         Random ReRollRand = new Random();
         //Determines Upperbound of Availible Dice
         int Upperbound = ReRoll.size() - Skulls;
         //Randomly Determines Which Die to Reroll
         int DieSelect = ReRollRand.nextInt(Upperbound);
         return DieSelect;
    }

    
}
