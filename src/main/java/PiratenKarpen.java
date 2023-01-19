import pk.Game;

public class PiratenKarpen {
    
    public static void main(String[] args) {

        int NumberOfGames = 42;
        float GamesPlayed = 0;
        int P1Wins = 0;
        int P2Wins = 0;
        int Ties = 0;

        System.out.println("Welcome to Piraten Karpen Simulator!\n");

        
        for (int i = 0; i < NumberOfGames; i++) {
            Game game = new Game();
            game.PlayGame();
            GamesPlayed += game.getGamesPlayed();
            P1Wins += game.getP1Wins();
            P2Wins += game.getP2Wins();
            Ties += game.getTies();
            
           }

            //Debug Checks Number Of Games Played
            //System.out.println("Number Of Games Played In Total: " + GamesPlayed);
            System.out.println("Player 1 Games Won: " + P1Wins);
            System.out.println("Player 2 Games Won: " + P2Wins );
            System.out.println("Ties: " + Ties + "\n");
           
            //Print % Of Wins
            float P1WinPercentage = (P1Wins/GamesPlayed)*100;
            float P2WinPercentage = (P2Wins/GamesPlayed)*100;

            System.out.println("-----------------------Win %--------------------------");
            System.out.printf("Player 1 Win Percentage: %.2f\n", P1WinPercentage);
            System.out.printf("Player 2 Win Percentage: %.2f\n", P2WinPercentage);
            System.out.println("------------------------------------------------------\n");

        }

        
        
    }
