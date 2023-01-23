package pk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Player {
    //Logger
    private static final Logger logger = LogManager.getLogger(Player.class);

    //Default Initialized Values
    private int Score = 0;
    private int Skulls = 0;
    private ArrayList<String> CurrentRoll = new ArrayList<String>();
    private String ReRollStrat = "RANDOM";

    //Initializes Strategy Class
    Strategy Strategy = new Strategy();

    //Sets Strategy If Incorrect Strategy Is Inputted, Will Default To Constructor Default
    public void SetStrat(String Strat){
        if (Strat == "RANDOM" || Strat == "MAXCOMBO"){
            ReRollStrat = Strat;
            System.out.println("Strategy Has Been Set To: " + ReRollStrat);
        }
        else{
            System.out.println("Invalid Strategy Inputted. Current Strategy: " + ReRollStrat);
        }
    }
    
    //Getter Functions
    public int getscore(){
        return Score;
    }
    public String getroll(){
        return CurrentRoll.toString();
    }
    public int getskulls(){
        return Skulls;
    }

    //Initial Roll Function
    public void Roll(){
        //Initialize Dice And New ArrayList To Hold The Roll
        ArrayList<String> Roll = new ArrayList<String>();
        Dice myDice = new Dice();

        //Adds 8 Dice With Randomly Generated Values
        for (int i = 0; i < 8; i++) {
            String FaceValue = myDice.roll().toString();
            Roll.add(FaceValue);

            //Keeps Track Of Skulls
            if (FaceValue == "SKULL"){
                Skulls += 1;
            }
        }

        //Sorts and Sets The Initial Roll As The Current Roll
        Collections.sort(Roll);
        CurrentRoll = Roll;
    }


    //ReRoll Function
    public void ReRoll(){

        //Initialize Variables
        ArrayList<String> ReRoll = CurrentRoll;
        boolean Complete = false;
        boolean EndTurn = false;

        while (Complete == false){
            if (Skulls >= 3 || EndTurn == true){

                if (Skulls >= 3){
                    System.out.println("3 Or More Skulls Have Been Rolled. Ending Turn.\n");
                }
                else{
                    System.out.println("Player Has Decided To End Their Turn\n");
                }
                
                //Generates Combo Array Using Roll
                int[] Combo = Strategy.CheckCombo(ReRoll);

                //Debug Statement, Prints Combo Array
                logger.debug(Arrays.toString(Combo));

                //Calculate And Add Score
                Score += Strategy.CalcScore(Combo);

                //Reset Skull Value
                Skulls = 0;

                //End Loop
                Complete = true;
            }
    
            else {
                //Current ReRoll Strategy
                System.out.println("Rerolling!");
                int DieSelect = 0;

                //If Statements To Check Which Strategy The Player Should Use
                if (ReRollStrat == "MAXCOMBO"){
                    DieSelect = Strategy.MaxCombos(ReRoll, Skulls);
                }
                else if (ReRollStrat == "RANDOM"){
                    DieSelect = Strategy.Random(ReRoll, Skulls);
                }

                //Value Of 10 Being Returned From ReRoll Functions Signals That Player Wants To End Their Turn
                if (DieSelect == 10){
                    EndTurn = true;
                }

                else{
                    //Creates New Die And Generates Roll
                    Dice myDice2 = new Dice();
                    String RerollValue = myDice2.roll().toString();
                    //Updates New Die Roll Replacing the Die Determined by DieSelect
                    ReRoll.set(DieSelect, RerollValue);
                    //Checks if Reroll is Skull and moves it to the back of the array
                    if (RerollValue == "SKULL"){
                        Skulls += 1;
                    }
                }

                //Prints Current Roll (For Clearer View For What Changed)
                System.out.println(ReRoll + "\n");

                //Alphabetically Sorts ReRoll 
                Collections.sort(ReRoll);

                //Sets New ReRoll As The Current Roll
                CurrentRoll = ReRoll;
                
            }
        }

    }

}
