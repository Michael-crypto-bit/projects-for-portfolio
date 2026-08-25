package Poker;
import java.util.ArrayList;
public class Deck {// the deck class creates a simulated deck object with the standard 52 cards found in a deck of playing cards
    ArrayList<Card> deck = new ArrayList<>();
    String suit;
    public Deck(){// initiates a deck with 52 cards, 4 suits and 13 different value of cards, to correctly simulate an entire deck of cards
        for(int j=1;j<=4;j++){
            if(j==1){
                suit = "hearts";
            }
            else if(j==2){
                suit = "spades";
            }
            else if(j==3){
                suit = "diamonds";
            }
            else if(j==4){
                suit = "clubs";
            }
            else{
                suit = "Error no suit";
            }
            for(int i=2;i<=14;i++){
                Card c1 = new Card(i,suit);
                deck.add(c1);
            }
        }
    }
    public Card deal(){ // returns a card object, the first/top card of the deck
        Card output = deck.get(0);
        deck.remove(0);
        return output;

    }
    public void shuffle(){ // called on a deck object, and randomizes the order of the cards
        ArrayList<Card> shuffledDeck = new ArrayList<>();
        for(int k=0;k<6;k++){//shuffling the entire deck 6 times seems to optimally mix the cards
            for(int i=0;i<deck.size();i++){
                int randomNumber = (int)(Math.random()*deck.size()); 
                shuffledDeck.add(deck.get(randomNumber));
                deck.remove(randomNumber);
            }
        }
        deck.addAll(shuffledDeck);
    }
    public String toString(){// returns the entire deck with a different line for each card for readability
        String output = "";
        for(int i=0;i<deck.size();i++){
            output+=deck.get(i).toString();
            output+="\n";
        }
        return output;
    }
}
