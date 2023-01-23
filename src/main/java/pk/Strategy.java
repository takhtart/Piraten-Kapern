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

    public int[] CheckCombo(ArrayList<String> Roll){
        int Diamonds = 0;
        int Gold = 0;
        int Monkey = 0;
        int Parrot = 0;
        int Saber = 0;

        for (String item :Roll) {
            if (item == "DIAMOND"){
                Diamonds += 1;
            }
            else if (item == "GOLD"){
                Gold += 1;
            }
            else if (item == "MONKEY"){
                Gold += 1;
            }
            else if (item == "PARROT"){
                Gold += 1;
            }
            else if (item == "SABER"){
                Gold += 1;
            }
        }

        int[] Combo = new int[5];
        Combo[0] = Diamonds;
        Combo[1] = Gold;
        Combo[2] = Monkey;
        Combo[3] = Parrot;
        Combo[4] = Saber;

        return Combo;


    }

    public int CalcScore(int[] Combo){
        int Score = 0;
        for (int i = 0; i < Combo.length; i++) {
            if (i == 0 || i==1){
                Score += 100*Combo[i];
            }
            if (Combo[i] > 2){
                if (Combo[i] == 3){
                    Score += 100;
                }
                else if (Combo[i] == 4){
                    Score += 200;
                }
                else if (Combo[i] == 5){
                    Score += 500;
                }
                else if (Combo[i] == 6){
                    Score += 1000;
                }
                else if (Combo[i] == 7){
                    Score += 2000;
                }
                else{
                    Score += 5000;
                }
            }
        }
        return Score;

    }

    
}
