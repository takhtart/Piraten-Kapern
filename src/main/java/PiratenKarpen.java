import pk.Game;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PiratenKarpen {
    private static final Logger logger = LogManager.getLogger(PiratenKarpen.class);

    public static void main(String[] args) {

        //Number of Games That Will Be Played
        int NumberOfGames = 42;

        //Creates A New Game Instance
        Game game = new Game();


        //For Loop That Simulates Multiple Games
        for (int i = 0; i < NumberOfGames; i++) {
            //Starts Game
            game.PlayGame();
        }
        
        //Debug Checks Number Of Games Played
        logger.debug("Number Of Games Played In Total: " + game.getGamesPlayed());
        logger.debug("Player 1 Games Won: " + game.getP1Wins());
        logger.debug("Player 2 Games Won: " + game.getP2Wins());
        logger.debug("Ties Encountered: " + game.getTies() + "\n");
        
        //% Of Wins Calculation
        float P1WinPercentage = (game.getP1Wins()/game.getGamesPlayed())*100;
        float P2WinPercentage = (game.getP2Wins()/game.getGamesPlayed())*100;

        //Print % of Wins
        System.out.println("-----------------------Win %--------------------------");
        System.out.printf("Player 1 Win Percentage: %.2f\n", P1WinPercentage);
        System.out.printf("Player 2 Win Percentage: %.2f\n", P2WinPercentage);
        System.out.println("------------------------------------------------------\n");

    }

        
        
    }
