package pk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Player {
    private static final Logger logger = LogManager.getLogger(Player.class);
    private int Score = 0;
    private int Skulls = 0;
    private ArrayList<String> CurrentRoll = new ArrayList<String>();
    Strategy Strategy = new Strategy();
    
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
            }
        }

        Collections.sort(Roll);
        CurrentRoll = Roll;
    }

    public void ReRoll(){
        ArrayList<String> ReRoll = CurrentRoll;
        boolean Complete = false;

        while (Complete == false){
            if (Skulls >= 3){
                System.out.println("3 Or More Skulls Have Been Rolled. Ending Turn.\n");
                
                int[] Combo = Strategy.CheckCombo(ReRoll);
                logger.debug(Arrays.toString(Combo));
                Score += Strategy.CalcScore(Combo);

                Skulls = 0;
                Complete = true;
            }
    
            else {
                //Current ReRoll Strategy
                System.out.println("Rerolling!");
                int[] Combo = Strategy.CheckCombo(ReRoll);
                int DieSelect = Strategy.Random(ReRoll, Skulls);

                //Creates New Die And Generates Roll
                Dice myDice2 = new Dice();
                String RerollValue = myDice2.roll().toString();
                //Updates New Die Roll Replacing the Die Determined by DieSelect
                ReRoll.set(DieSelect, RerollValue);

                //Checks if Reroll is Skull and moves it to the back of the array
                if (RerollValue == "SKULL"){
                    Skulls += 1;
                }

                System.out.println(ReRoll + "\n");

                Collections.sort(ReRoll);
                CurrentRoll = ReRoll;
                
            }
        }

    }

}
