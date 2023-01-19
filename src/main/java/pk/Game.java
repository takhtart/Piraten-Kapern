package pk;

public class Game {

    float GamesPlayed = 0;
    int P1Wins = 0;
    int P2Wins = 0;
    int Ties = 0;
    boolean GameOver = false;
    Player Player1 = new Player();
    Player Player2 = new Player();

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


    public void PlayGame(){

        System.out.println("Welcome to Piraten Karpen Simulator!\n");

        while (GameOver == false){
            //Player 1 Turn
            System.out.println("-----------------------Player 1-----------------------");
            System.out.println("Player 1: I'm rolling dice!");
            Player1.Roll();
            System.out.println("Player 1 Rolled: " + Player1.getroll());
            Player1.ReRoll();
            System.out.println("Player 1 Final Roll: " + Player1.getroll());
            System.out.println("Player 1 Score: " + Player1.getscore() + "\n");
            System.out.println("------------------------------------------------------\n");

            //Player 2 Turn
            System.out.println("-----------------------Player 2-----------------------");
            System.out.println("Player 2: I'm rolling dice!");
            Player2.Roll();
            System.out.println("Player 2 Rolled: " + Player2.getroll());
            Player2.ReRoll();

            System.out.println("Player 2 Final Roll: " + Player2.getroll());
            System.out.println("Player 2 Score: " + Player2.getscore() + "\n");
            System.out.println("------------------------------------------------------\n");

             //Checks Which Player Wins The Game
            if (Player1.getscore() >= 6000 || Player2.getscore() >= 6000){
                if (Player1.getscore() > Player2.getscore()){
                    P1Wins += 1;
                    System.out.println("Player 1 Wins!");
                    System.out.println("-----------------------Final Scores-----------------------");
                    System.out.println("Player 1 Final Score: " + Player1.getscore() + "\n");
                    System.out.println("Player 2 Final Score: " + Player2.getscore());
                    System.out.println("----------------------------------------------------------\n");

                    GamesPlayed += 1;
                    GameOver = true;
                }
                else if (Player2.getscore() > Player1.getscore()) {
                    P2Wins += 1;
                    System.out.println("Player 2 Wins!");
                    System.out.println("-----------------------Final Scores-----------------------");
                    System.out.println("Player 1 Final Score: " + Player1.getscore() + "\n");
                    System.out.println("Player 2 Final Score: " + Player2.getscore());
                    System.out.println("----------------------------------------------------------\n");
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
