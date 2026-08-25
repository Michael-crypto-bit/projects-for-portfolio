package Poker;
public class Card { // card class creates playing card objects for the poker game
    private int cardValue;
    private String suit;
    public Card(int cardValue2,String suit2){// initializes a card object with a value 2-14, and a suit
        cardValue = cardValue2;
        suit = suit2;
    }
    public int getValue(){ // returns the value of the card object it is called upon
        return cardValue;
    }
    public String getSuit(){ // returns the suit of the card object it is called upon
        return suit;
    }
    public String imageFileName(){ // parses the card values into a file name, and returns the file name in a .png format such a "ace_of_spades.png"
        if(cardValue>10){
            if(cardValue == 11){
                return "jack_of_"+suit + ".png";
            }
            else if(cardValue == 12){
                return "queen_of_"+suit + ".png";
            }
            else if(cardValue == 13){
                return "king_of_"+suit + ".png";  
            }
            else{
                return "ace_of_"+suit + ".png";
            }
        }
        else{
            return cardValue+"_of_"+suit  + ".png";
        }
    }
    public String toString(){ // prints all attributes of the card object in one line for debugging mainly
        return "Value: "+cardValue+", Suit: "+suit+", filename: "+imageFileName();
    }

}
