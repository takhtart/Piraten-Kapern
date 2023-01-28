package pk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Game {

    private static final Logger logger = LogManager.getLogger(Game.class);

    //Initializes Player Tracking Variables
    private float GamesPlayed = 0;
    private int P1Wins = 0;
    private int P2Wins = 0;
    private int Ties = 0;
    
    

    //Getter Functions
    public int getP1Wins(){
        return P1Wins;
    }
    public int getP2Wins(){
        return P2Wins;
    }
    public int getTies(){
        return Ties;
    }
    public float getGamesPlayed(){
        return GamesPlayed;
    }


    //Simulates Game
    public void PlayGame(String Player1Strat, String Player2Strat,String NumberOfGames){

        //For Loop That Simulates Multiple Games
        for (int i = 0; i < Integer.valueOf(NumberOfGames); i++) {
            
            //Initialize Game Variables
            boolean GameOver = false;

            System.out.println("Welcome to Piraten Karpen Simulator!\n");
            Cards Cards = new Cards();
            Cards.GenerateDeck();
            logger.debug(Cards.PrintDeck());

            Player Player1 = new Player();
            Player Player2 = new Player();

            Player1.SetStrat(Player1Strat);
            Player2.SetStrat(Player2Strat);

            //Runs While Game Is Ongoing
            while (GameOver == false){

                //Player 1 Turn
                logger.debug("Player1 Turn");

                System.out.println("-----------------------Player 1-----------------------");

                //Card Draw
                String Player1Card = Cards.DrawCard();
                System.out.println("Player 1 Drew The " + Player1Card + " Card!");

                //Card Draw Description
                if (Player1Card.equals("Sea Battle (2)") || Player1Card.equals("Sea Battle (3)") || Player1Card.equals("Sea Battle (4)")){
                    System.out.println("Ship is Engaged in a Sea Battle! Must Roll Enough Sabers To Win!");
                }
                if (Player1Card.equals("Monkey Business")){
                    System.out.println("Monkeys and Parrots are Grouped Together!");
                }

                //Initial Roll
                System.out.println("\nPlayer 1: I'm rolling dice!");
                Player1.Roll(Player1Card);
                System.out.println("Player 1 Rolled: " + Player1.getroll() +"\n");


                //Reroll
                System.out.println("ReRolling!");
                Player1.ReRoll();
                System.out.println("Player 1 Rolled " + Player1.getRolls() + " Dice To Get To Its Final Roll!\n");
                System.out.println("Player 1 Final Roll: " + Player1.getroll());
                System.out.println("Player 1 Score: " + Player1.getscore() + "\n");
                System.out.println("------------------------------------------------------\n");

                //Player 2 Turn
                logger.debug("Player2 Turn");
                
                System.out.println("-----------------------Player 2-----------------------");

                //Card Draw
                String Player2Card = Cards.DrawCard();
                System.out.println("Player 2 Drew The " + Player2Card + " Card!");

                //Card Draw Description
                if (Player2Card.equals("Sea Battle (2)") || Player2Card.equals("Sea Battle (3)") || Player2Card.equals("Sea Battle (4)")){
                    System.out.println("Ship is Engaged in a Sea Battle! Must Roll Enough Sabers To Win!");
                }
                if (Player2Card.equals("Monkey Business")){
                    System.out.println("Monkeys and Parrots are Grouped Together!");
                }

                //Initial Roll
                System.out.println("\nPlayer 2: I'm rolling dice!");
                Player2.Roll(Player2Card);
                System.out.println("Player 2 Rolled: " + Player2.getroll()+"\n");

                //Reroll
                System.out.println("ReRolling!");
                Player2.ReRoll();
                System.out.println("Player 2 Rolled " + Player2.getRolls() + " Dice To Get To Its Final Roll!\n");
                System.out.println("Player 2 Final Roll: " + Player2.getroll());
                System.out.println("Player 2 Score: " + Player2.getscore() + "\n");
                System.out.println("------------------------------------------------------\n");

                //Checks Which Player Wins The Game
                if (Player1.getscore() >= 6000 || Player2.getscore() >= 6000){
                    if (Player1.getscore() > Player2.getscore()){
                        P1Wins += 1;
                        System.out.println("Player 1 Wins!\n");
                        System.out.println("---------------------Final Scores---------------------");
                        System.out.println("Player 1 Final Score: " + Player1.getscore() + "\n");
                        System.out.println("Player 2 Final Score: " + Player2.getscore());
                        System.out.println("------------------------------------------------------\n");

                        GamesPlayed += 1;
                        GameOver = true;
                    }
                    else if (Player2.getscore() > Player1.getscore()) {
                        P2Wins += 1;
                        System.out.println("Player 2 Wins!\n");
                        System.out.println("---------------------Final Scores---------------------");
                        System.out.println("Player 1 Final Score: " + Player1.getscore() + "\n");
                        System.out.println("Player 2 Final Score: " + Player2.getscore());
                        System.out.println("------------------------------------------------------\n");
                        GamesPlayed += 1;
                        GameOver = true;
                    }
                    else {
                        System.out.println("Tied! Playing Another Round");
                        Ties += 1;
                        
                    } 
                }
            }

        }

    }
    
}
