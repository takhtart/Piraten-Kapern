package pk;

import java.util.ArrayList;
import java.util.Collections;


public class Cards {
    private ArrayList<String> Deck = new ArrayList<String>();

    //Generates And Shuffles The Deck Of Cards (Currently 25 Nops, 6 Sea Battle Cards (Of Various Kinds), and 4 Monkey Business Cards - Totalling 35 Cards)
    public void GenerateDeck(){
        int nop = 25;
        int monkeybus = 4;

        //Adds Monkey Business Cards Via For Loop
        for (int i = 0; i < monkeybus; i++) {
            Deck.add("Monkey Business");
        }

        //Adds Nop Cards Via For Loop
        for (int i = 0; i < nop; i++) {
            Deck.add("nop");
        }

        //Adds Sea Battle Cards (2 of Each Type (Totalling 6)) Manually 
        Deck.add("Sea Battle (2)");
        Deck.add("Sea Battle (2)");
        Deck.add("Sea Battle (3)");
        Deck.add("Sea Battle (3)");
        Deck.add("Sea Battle (4)");
        Deck.add("Sea Battle (4)");

        //Shuffles Array (Deck)
        Collections.shuffle(Deck);
    }
    
    //Draws A Single Card From The Top (Beginning Of Array) and Puts it At The Bottom Of The Deck (End Of Array). Returns The Card That Was Drawn
    public String DrawCard(){
        //Draw Card
        String Card = Deck.get(0);

        //Add Card To The Bottom
        Deck.add(Card);

        //Remove Card From The Top
        Deck.remove(0);

        //Returns Card
        return Card;
    }

    //Getter That Returns Deck Array For Viewing (Used For Debug Purposes)
    public ArrayList<String> PrintDeck(){
        return Deck;
    }
}
