import pk.Game;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PiratenKarpen {
    private static final Logger logger = LogManager.getLogger(PiratenKarpen.class);

    public static void main(String[] args) {

        //Default Game Arguments
        String Player1Strat = "combo";
        String Player2Strat = "combo";
        String NumberOfGames = "42";

        //Creates A New Game Instance
        Game game = new Game();

        //Command Line Argument Handler | Checks Number Of CommandLine Arguments
        if (args.length == 0 || args.length == 1){
            logger.debug("No Arguments Inputted, Using Default Values");
            System.out.println("<Usage> PlayerStrat1, PlayerStrat2, Number Of Games");
            //Starts Game With Default Values
            game.PlayGame(Player1Strat, Player2Strat, NumberOfGames);
        }
        if (args.length == 2){
            logger.debug("Strategies Applied, Using Default Number Of Games (42)");
            //Starts Game [Arg1: P1 ReRoll Strat, Arg2: P2 ReRoll Strat] (Available Strategies: "random", "combo"), Arg3: Default Number Of Games]
            game.PlayGame(args[0], args[1], NumberOfGames);
        }
        if (args.length == 3){
            logger.debug("Strategies And # Of Games Applied");
            //Starts Game [Arg1: P1 ReRoll Strat, Arg2: P2 ReRoll Strat] (Available Strategies: "random", "combo"), Arg3: Number Of Games (3rd Arg Implemented For Testing Purposes When Executing With Maven, but Also Makes For A Good Configurable Feature For # of Games)]
            game.PlayGame(args[0], args[1], args[2]);
        }

        //Debug Checks Number Of Games Played/Won/Ties
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
