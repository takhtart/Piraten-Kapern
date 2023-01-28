package pk;

import java.util.ArrayList;
import java.util.Collections;


public class Cards {
    private ArrayList<String> Deck = new ArrayList<String>();

    public void GenerateDeck(){
        int nop = 29;

        for (int i = 0; i < nop; i++) {
            Deck.add("nop");
        }

        Deck.add("Sea Battle 2");
        Deck.add("Sea Battle 2");
        Deck.add("Sea Battle 3");
        Deck.add("Sea Battle 3");
        Deck.add("Sea Battle 4");
        Deck.add("Sea Battle 4");

        Collections.shuffle(Deck);
    }

    public String DrawCard(){
        String Card = Deck.get(0);
        Deck.add(Card);
        Deck.remove(0);
        return Card;
    }

    public ArrayList<String> PrintDeck(){
        return Deck;
    }
}
