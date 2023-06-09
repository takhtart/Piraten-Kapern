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
    private String ReRollStrat = "combo";
    private String Card = "";
    private int DiceRolled = 0;

    //Initializes Strategy Class
    Strategy Strategy = new Strategy();

    //Sets Strategy If Incorrect Strategy Is Inputted, Will Default To Constructor Default
    public void SetStrat(String Strat){
        if (Strat.equals("random") || Strat.equals("combo")){
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
    public String getStrat(){
        return ReRollStrat;
    }
    public int getRolls(){
        return DiceRolled;
    }

    //Initial Roll Function
    public void Roll(String PulledCard){
        //Initialize Dice And New ArrayList To Hold The Roll
        ArrayList<String> Roll = new ArrayList<String>();
        Card = PulledCard;
        DiceRolled = 0;

        Dice myDice = new Dice();

        //Adds 8 Dice With Randomly Generated Values
        for (int i = 0; i < 8; i++) {
            String FaceValue = myDice.roll().toString();
            Roll.add(FaceValue);

            //Keeps Track Of Skulls
            if (FaceValue.equals("SKULL")){
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
                    System.out.println("3 Or More Skulls Have Been Rolled. Turn Ends With No Points.\n");
                    logger.debug("Skulls Ending Turn");
                }
                else{
                    logger.debug("Ending Turn");
                    System.out.println("Player Has Decided To End Their Turn\n");
                }
                
                //Generates Combo Array Using Roll
                int[] Combo = Strategy.CheckCombo(ReRoll,Card);

                //Debug Statement, Prints Combo Array
                logger.debug("Calculated Combo: " + Arrays.toString(Combo));

                int ScoreCalc = Strategy.CalcScore(Combo,Card);
                //Calculate And Add Score
                System.out.println("Points Awarded This Turn: " + ScoreCalc +"\n");
                Score += ScoreCalc;

                //Reset Skull Value
                Skulls = 0;

                //End Loop
                Complete = true;
            }
    
            else {
                //Current ReRoll Strategy
                int DieSelect = 0;

                //If Statements To Check Which Strategy The Player Should Use
                if (ReRollStrat.equals("combo")){
                    logger.debug("Combo Strat Used");
                    DieSelect = Strategy.MaxCombos(ReRoll, Skulls, Card);
                }
                else if (ReRollStrat.equals("random")){
                    logger.debug("Random Strat Used");
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
                    //Adds 1 To Diced Rolled
                    DiceRolled += 1;
                    //Updates New Die Roll Replacing the Die Determined by DieSelect
                    ReRoll.set(DieSelect, RerollValue);
                    //Checks if Reroll is Skull and moves it to the back of the array
                    if (RerollValue.equals("SKULL")){
                        Skulls += 1;
                    }
                }

                //Prints Current Roll (For Clearer View For What Changed)
                logger.trace(ReRoll + "\n");

                //Alphabetically Sorts ReRoll 
                Collections.sort(ReRoll);

                //Sets New ReRoll As The Current Roll
                CurrentRoll = ReRoll;
                
            }
        }

    }

}
