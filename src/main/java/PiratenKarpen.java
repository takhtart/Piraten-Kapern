import pk.Player;

public class PiratenKarpen {

    public static void main(String[] args) {
        int NumberOfGames = 42;

        float GamesPlayed = 0;

        int P1Wins = 0;
        int P2Wins = 0;

        System.out.println("Welcome to Piraten Karpen Simulator!");

        
        for (int i = 0; i < NumberOfGames; i++) {
            boolean GameOver = false;
            Player Player1 = new Player();
            Player Player2 = new Player();
            //Base Scores
            System.out.println("Player 1 Score: " + Player1.getscore());
            System.out.println("Player 1 Skulls: " + Player1.getskulls());
            System.out.println("Player 2 Score: " + Player1.getscore());
            System.out.println("Player 2 Skulls: " + Player1.getskulls());

            while (GameOver == false){
                //Player 1 Turn
                System.out.println("Player 1: I'm rolling dice!");
                Player1.Roll();
                System.out.println("Player 1 Rolled: " + Player1.getroll());
                System.out.println("Player 1 ReRolling!");
                Player1.ReRoll();
                System.out.println("Player 1 Final Roll: " + Player1.getroll());
                System.out.println("Player 1 Score: " + Player1.getscore() + "\n");
    
                //Player 2 Turn
                System.out.println("Player 2: I'm rolling dice!");
                Player2.Roll();
                System.out.println("Player 2 Rolled: " + Player2.getroll());
                System.out.println("Player 2 ReRolling!");
                Player2.ReRoll();
                System.out.println("Player 2 Final Roll: " + Player2.getroll());
                System.out.println("Player 2 Score: " + Player2.getscore() + "\n");

                 //Checks Which Player Wins The Game
           
                if (Player1.getscore() >= 6000 || Player2.getscore() >= 6000){
                    
                    if (Player1.getscore() >= Player2.getscore()){
                        P1Wins += 1;
                        System.out.println("Player 1 Wins!");
                        GamesPlayed += 1;
                        GameOver = true;
                    }
                    else{
                        P2Wins += 1;
                        System.out.println("Player 2 Wins!");
                        GamesPlayed += 1;
                        GameOver = true;
                    } 
                }
                

           }

        }

        //Debug Checks Number Of Games Played
        System.out.println("Number Of Games Played In Total: " + GamesPlayed);
        System.out.println("Player 1 Games Won: " + P1Wins);
        System.out.println("Player 2 Games Won: " + P2Wins);

        //Print % Of Wins
        float P1WinPercentage = (P1Wins/GamesPlayed)*100;
        float P2WinPercentage = (P2Wins/GamesPlayed)*100;

        System.out.printf("Player 1 Win Percentage: %.2f\n", P1WinPercentage);
        System.out.printf("Player 2 Win Percentage: %.2f\n", P2WinPercentage);
        
    }
    
}
