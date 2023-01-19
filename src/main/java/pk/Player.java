package pk;
import java.util.ArrayList;
import java.util.Random;

public class Player {
    private int Score = 0;
    private int Skulls = 0;
    private ArrayList<String> CurrentRoll = new ArrayList<String>();
    
    public int getscore(){
        return Score;
    }
    public String getroll(){
        return CurrentRoll.toString();
    }
    public int getskulls(){
        return Skulls;
    }

    public void Roll(){
        ArrayList<String> Roll = new ArrayList<String>();
        Dice myDice = new Dice();
        for (int i = 0; i < 8; i++) {
            String FaceValue = myDice.roll().toString();
            Roll.add(FaceValue);
            if (FaceValue == "SKULL"){
                Skulls += 1;
                Roll.remove(String.valueOf("SKULL"));
            }
        }

        for (int index = 0; index < Skulls; index++) {
            Roll.add("SKULL");
        }

        CurrentRoll = Roll;
    }

    public void ReRoll(){
        ArrayList<String> ReRoll = CurrentRoll;
        boolean Complete = false;

        while (Complete == false){
            if (Skulls >= 3){
                System.out.println("3 Or More Skulls Have Been Rolled. Ending Turn.\n");
                int Diamonds = 0;
                int Gold = 0;
    
                for (String item :ReRoll) {
                    if (item == "DIAMOND"){
                        Diamonds += 1;
                    }
                    else if (item == "GOLD"){
                        Gold += 1;
                    }
                }

                Score += Diamonds*100 + Gold*100;
                Skulls = 0;
                Complete = true;
            }
    
            else {
                //Current ReRoll Strategy
                System.out.println("Rerolling!");

                //Initializes Random
                Random ReRollRand = new Random();
                //Determines Upperbound of Availible Dice
                int Upperbound = ReRoll.size() - Skulls;
                //Randomly Determines Which Die to Reroll
                int DieSelect = ReRollRand.nextInt(Upperbound);
                //Creates New Die And Generates Roll
                Dice myDice2 = new Dice();
                String RerollValue = myDice2.roll().toString();
                //Updates New Die Roll Replacing the Die Determined by DieSelect
                ReRoll.set(DieSelect, RerollValue);

                //Checks if Reroll is Skull and moves it to the back of the array
                if (RerollValue == "SKULL"){
                    Skulls += 1;
                    ReRoll.remove(DieSelect);
                    ReRoll.add("SKULL");
                }

                System.out.println(ReRoll + "\n");
                CurrentRoll = ReRoll;
                
            }
        }

    }

}
