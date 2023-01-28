package pk;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Strategy {
    private static final Logger logger = LogManager.getLogger(Strategy.class);


    public int Random(ArrayList<String> ReRoll, int Skulls){
        int DieSelect = 0;
        if (Skulls == 2){
            Random RiskSkull = new Random();
            int DoNotRoll = RiskSkull.nextInt(2);

            if (DoNotRoll == 1){
                DieSelect = 10;
                return DieSelect;
            }
            
        }
         //Initializes Random
         Random ReRollRand = new Random();
         //Determines Upperbound of Available Dice
         int Upperbound = ReRoll.size() - Skulls;
         //Randomly Determines Which Die to Reroll
         DieSelect = ReRollRand.nextInt(Upperbound);

         return DieSelect;
    }

    public int MaxCombos(ArrayList<String> ReRoll, int Skulls, String Card){

        //Initialize DieSelection
        int DieSelect = 0;
        //Checks Current Combo Value
        int[] Combo = CheckCombo(ReRoll);
        //Check Number Of Dice That Are Available to Roll
        int Rollable = ReRoll.size() - Skulls;

        //Check Highest and Lowest Combo
        int Highest = 0;
        int Lowest = 0;

        //Clones And Sorts Combo Array
        int[] SortedComboArr = Combo.clone();
        Arrays.sort(SortedComboArr);

        //Highest Combo Located At End Of Array
        Highest = SortedComboArr[SortedComboArr.length-1];

        //Lowest Combo Near Beginning Of The List, However 0's need to be ignored so it will check for the first value greater than 0 and then break the loop to determine lowest combo val
        for (int i = 0; i < SortedComboArr.length; i++) {
            if (SortedComboArr[i] > 0){
                Lowest = SortedComboArr[i];
                break;
            } 
        }

        if (Card.equals("Sea Battle 2") || Card.equals("Sea Battle 3") || Card.equals("Sea Battle 4")){
            DieSelect = SeaBattle(ReRoll, Skulls, Card);
            return DieSelect;
        }

        //Prioritize Full Chest (1st Priority)
        else if (Rollable == 8){
          DieSelect = 10;
        }

        //If 2 Or More Skulls Are Present In The Roll End Turn
        else if (Rollable <= 6){
            DieSelect = 10;
        }


        //If Full Chest Is Not Achievable And There Are More Than 2 Faces Present in Combo (Trys To Reach A Combo That Consists of a Max Of 2 Faces)
        else if (Highest + Lowest != Rollable){

            //Initialize LowestPos Variable For Locating Position of Lowest Combo in Array
            int LowestPos = 0;

            //Searches For Face With Lowest Combo (Searching Backwards [Right to Left] to Prioritize Diamonds and Gold)
            for(int i = 4; i > 0; i--) {
                if(Combo[i] == Lowest) {
                       LowestPos = i;
                       break;
                 }
            }

            //Debug Statements
            logger.debug(Arrays.toString(Combo));
            logger.debug("Highest: " + Highest);
            logger.debug("Lowest: " + Lowest);

            //ReRolls A Die With A Set Face Based On The Determined Lowest Combo Postion In Combo Array
            if (LowestPos == 0){
                DieSelect = ReRoll.indexOf("DIAMOND");
                logger.debug("ReRolling Diamond: " + DieSelect);
            }
            else if (LowestPos == 1){
                DieSelect = ReRoll.indexOf("GOLD");
                logger.debug("ReRolling Gold: " + DieSelect);
            }
            else if (LowestPos == 2){
                DieSelect = ReRoll.indexOf("MONKEY");
                logger.debug("ReRolling Monkey: " + DieSelect);

            }
            else if (LowestPos == 3){
                DieSelect = ReRoll.indexOf("PARROT");
                logger.debug("ReRolling Parrot: " + DieSelect);
            }
            else{
                DieSelect = ReRoll.indexOf("SABER");
                logger.debug("ReRolling Saber: " + DieSelect);
            }

        }

        else{
            //If There Is A Combo of 2 Faces and The Availble Dice That Can Be Rolled Are Odd (Applies To Having 7 Availible Dice)
            if (Rollable % 2 != 0){
                if (Lowest <= 2){
                    int LowestPos = 0;
                    //Searches For Face With Lowest Combo (Searching Backwards [Right to Left] to Prioritize Diamonds and Gold)
                    for(int i = 4; i > 0; i--) {
                        if(Combo[i] == Lowest) {
                            LowestPos = i;
                            break;
                        }
                    }

                    //If Diamond And Gold Are The Lowest Combo Out Of The 7 Dice Keeps Hand And Ends Turn (DieSelect Value Of 10 Tells Program To End Turn), Otherwise ReRoll The Die
                    if (LowestPos == 0 || LowestPos == 1){
                        DieSelect = 10;
                    }
                    else if (LowestPos == 2){
                        DieSelect = ReRoll.indexOf("MONKEY");
                        logger.debug("ReRolling Monkey: " + DieSelect);
        
                    }
                    else if (LowestPos == 3){
                        DieSelect = ReRoll.indexOf("PARROT");
                        logger.debug("ReRolling Parrot: " + DieSelect);
                    }
                    else{
                        DieSelect = ReRoll.indexOf("SABER");
                        logger.debug("ReRolling Saber: " + DieSelect);
                    }
            }

            //Ends Turn
            else{
                DieSelect = 10;
            }
        }
   }

   //Returns Selected Die To ReRoll (If A DieSelect Value Of 10 Is Sent Turn Ends)
   return DieSelect;
}

public int SeaBattle(ArrayList<String> ReRoll, int Skulls, String Card){
    //Initialize DieSelection
    int DieSelect = 0;
    //Checks Current Combo Value
    int[] Combo = CheckCombo(ReRoll);
     //Check Highest and Lowest Combo
     int Highest = 0;
     int Lowest = 0;
     int SabersNeeded = 0;

     //Clones And Sorts Combo Array
     int[] SortedComboArr = Combo.clone();

     //Sets Saber Val to 0 So it Gets Ignored
     SortedComboArr[4] = 0;

     Arrays.sort(SortedComboArr);

     //Highest Combo Located At End Of Array
     Highest = SortedComboArr[SortedComboArr.length-1];

     //Lowest Combo Near Beginning Of The List, However 0's need to be ignored so it will check for the first value greater than 0 and then break the loop to determine lowest combo val
     for (int i = 0; i < SortedComboArr.length; i++) {
         if (SortedComboArr[i] > 0){
             Lowest = SortedComboArr[i];
             break;
         } 
     }
    
    if (Card.equals("Sea Battle 2")){
        SabersNeeded = 2;
    }

    else if (Card.equals("Sea Battle 3")){
        SabersNeeded = 3;
    }

    else{
        SabersNeeded = 4;
    }



    if (Combo[4] >= SabersNeeded){
        DieSelect = 10;
        return DieSelect;
    }

    else{

        //Initialize LowestPos Variable For Locating Position of Lowest Combo in Array
        int LowestPos = 0;

        //Searches For Face With Lowest Combo (Searching Backwards [Right to Left] to Prioritize Diamonds and Gold) And Ignores Sabers
        for(int i = 3; i > 0; i--) {
            if(Combo[i] == Lowest) {
                    LowestPos = i;
                    break;
            }
        }

        //Debug Statements
        logger.debug(Arrays.toString(Combo));
        logger.debug("Highest: " + Highest);
        logger.debug("Lowest: " + Lowest);

        //ReRolls A Die With A Set Face Based On The Determined Lowest Combo Postion In Combo Array
        if (LowestPos == 0){
            DieSelect = ReRoll.indexOf("DIAMOND");
            logger.debug("ReRolling Diamond: " + DieSelect);
        }
        else if (LowestPos == 1){
            DieSelect = ReRoll.indexOf("GOLD");
            logger.debug("ReRolling Gold: " + DieSelect);
        }
        else if (LowestPos == 2){
            DieSelect = ReRoll.indexOf("MONKEY");
            logger.debug("ReRolling Monkey: " + DieSelect);

        }
        else if (LowestPos == 3){
            DieSelect = ReRoll.indexOf("PARROT");
            logger.debug("ReRolling Parrot: " + DieSelect);
        }

    }

//Returns Selected Die To ReRoll (If A DieSelect Value Of 10 Is Sent Turn Ends)
return DieSelect;

}

    public int[] CheckCombo(ArrayList<String> Roll){

        //Initialized Count Of Dice Values In Roll (Skulls Are Excluded From Combo Check)
        int Diamonds = 0;
        int Gold = 0;
        int Monkey = 0;
        int Parrot = 0;
        int Saber = 0;

        //Counts Dice Values In Roll
        for (String item :Roll) {
            if (item.equals("DIAMOND")){
                Diamonds += 1;
            }
            else if (item.equals("GOLD")){
                Gold += 1;
            }
            else if (item.equals("MONKEY") ){
                Monkey += 1;
            }
            else if (item.equals("PARROT")){
                Parrot += 1;
            }
            else if (item.equals("SABER")){
                Saber += 1;
            }
        }

        //Creates Ordered Array To Display The Combo
        int[] Combo = new int[5];
        Combo[0] = Diamonds;
        Combo[1] = Gold;
        Combo[2] = Monkey;
        Combo[3] = Parrot;
        Combo[4] = Saber;

        return Combo;
    }

    public int CalcScore(int[] Combo, String Card){

        //Initialize Variables
        int Score = 0;
        int TotalDice = 0;
        int SabersNeeded = 0;

        //Checks How Many Sabers Are Needed If Sea Battle Card Was Pulled And Calculate Bonuses
        if (Card.equals("Sea Battle 2") || Card.equals("Sea Battle 3") || Card.equals("Sea Battle 4")){
            if (Card.equals("Sea Battle 2")){
                SabersNeeded = 2;
            }
        
            else if (Card.equals("Sea Battle 3")){
                SabersNeeded = 3;
            }
        
            else{
                SabersNeeded = 4;
            }

            if (Combo[4] < SabersNeeded){
                logger.debug("Sabers Needed: " + SabersNeeded);
                logger.debug("Sabers Had: " + Combo[4]);
                logger.debug("Lost Battle No Points");
                Score = 0;
                return Score; 
            }
            else{
                if (SabersNeeded == 2){
                    logger.debug("Sabers Needed: " + SabersNeeded);
                    logger.debug("Sabers Had: " + Combo[4]);
                    logger.debug("Saber Bonus Applied - 300");
                    Score += 300;
                }
                else if (SabersNeeded == 3){
                    logger.debug("Sabers Needed: " + SabersNeeded);
                    logger.debug("Sabers Had: " + Combo[4]);
                    logger.debug("Saber Bonus Applied - 500");
                    Score += 500;
                }
                else{
                    logger.debug("Sabers Needed: " + SabersNeeded);
                    logger.debug("Sabers Had: " + Combo[4]);
                    logger.debug("Saber Bonus Applied - 1000");
                    Score += 1000;
                }
            }
        }



        //Counts Total Amount Of Valuable Dice Using Combo Array (To Check For Full Chest Bonus)
        for (int i = 0; i < Combo.length; i++) {
            TotalDice += Combo[i];
        }

        //Returns Score Of Zero if 3 or More Skulls Are Present
        if (TotalDice <= 5){
            Score = 0;
            return Score;
        }

        //Calculates Scores
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

        //Full Chest Bonus
        if (TotalDice == 8){
            Score += 500;
        }

        return Score;

    }

    
}
