import pk.Player;

public class PiratenKarpen {

    public static void main(String[] args) {
        Player Player1 = new Player();
        Player Player2 = new Player();

        int P1Wins = 0;
        int P2Wins = 0;

        System.out.println("Welcome to Piraten Karpen Simulator!");

        //Base Scores
        System.out.println("Player 1 Score: " + Player1.getscore());
        System.out.println("Player 1 Skulls: " + Player1.getskulls());
        System.out.println("Player 2 Score: " + Player1.getscore());
        System.out.println("Player 2 Skulls: " + Player1.getskulls());

        while (Player1.getscore() <= 6000 && Player2.getscore() <= 6000){
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
        }

        //Checks Which Player Wins The Game
        
        if (Player1.getscore() > Player2.getscore()){
            P1Wins += 1;
            System.out.println("Player 1 Wins!");
        }
        else{
            P2Wins += 1;
            System.out.println("Player 2 Wins!");
        }
        
    }
    
}
