package Poker;
import java.util.ArrayList;
public class Hand {//hand class creates hand objects, of which hold card objects
    int rank; // overall rank variable so tha it can be accessed by most functions, stores rank value
    int maxPaired; // value of the max paired card, good in ties
    int index = 0;
    ArrayList<Card> hand;
    
    public Hand(){ // initializes the Hand class with an empty hand for cards to get added to
       hand = new ArrayList<>();
    }
    public ArrayList<Card> getHand(){// returns the hand of cards objects
        return hand;
    }
    public Card addCard(Card newCard1){//adds a card to the Hand object it is called upon, it adds a card object that is specified when the function is called @parameter Card newCard1 the card obejct that you want to add, when adding adds card to the Hand object with the Card objects sorted in descending order
        Card newCard = newCard1;
        for(int i=0;i<=hand.size();i++){
            if (hand.size() == 0 || newCard.getValue() >= hand.get(i).getValue()){
                hand.add(i, newCard);
                return newCard;
            }
            else if(newCard.getValue() < hand.get(hand.size()-1).getValue()){
                hand.add(newCard);
                return newCard;
            }
            
        }
        return newCard;
    }
    public boolean isFlush(){ // checks if the hand object it is called on fit the parameters of being a flush hand, giving an according value of true or false, parameter is that the hand must be sorted in descending order
        int count = 1;
        String type = hand.get(0).getSuit();
        for(int i=1;i<hand.size();i++){
            if(hand.get(i).getSuit() == type){
                count++;
            }
        }
        if(count == hand.size()){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean isStraight(){ // checks if the hand object it is called on fit the parameters of being a straight, returning true or false accordingly, parameter is that the hand must be sorted in descending order
    int count = 0;
    for(int i=0;i<hand.size();i++){
    if(i==0 || hand.get(i).getValue() == hand.get(i-1).getValue()-1){
    count++;
    }
    }
    if(count == hand.size()){
            return true;
        }
    else{
        return false;
    }
    }
    public boolean isRoyal(){// checks if the hand object it is called on is a royal hand or not, returning true or false accordingly, requires that the hand object is sorted in descending order
        int count = 0;
    for(int i=0;i<hand.size();i++){
        if(hand.get(i).getValue()>9){
            count++;
        }
    }
    if(count == hand.size()){
            return true;
        }
    else{
        return false;
    }
    }
    public boolean isFour(){// checks if the hand object it is called on has a group of four of the same value cards, returning true, or false accordingly, requires that the hand object is sorted in descending order
        int count = 1;
        int type = hand.get(0).getValue();
        for(int i=1;i<hand.size();i++){
        if(hand.get(i).getValue() == type){
            count++;
        }
        }
        if (count >=4){
            maxPaired = type;
            return true;
        }
        else if(count >=2){
            return false;
        }
        else{
        count = 1;
        type = hand.get(1).getValue();
        for(int i=2;i<hand.size();i++){
        if(hand.get(i).getValue() == type){
            count++;
        }
        }   
        
        if (count >=4){
            maxPaired = type;
            return true;
        }
        else{
            return false;
        }
        }
    }
    public boolean isFull(){// checks if the hand object it is called on fit the parameters of being a full hand in poker returning true or false accordingly, requires the hand object to be sorted in descending order
        int count = 1;
        int type = hand.get(0).getValue();
        ArrayList<Card> second = new ArrayList<>();
        for(int i=1;i<hand.size();i++){
            if(hand.get(i).getValue() == type){
                count++;
            }
            else{
                second.add(hand.get(i));
            }
        }
        if(count == 3){
            if(second.get(0).getValue() == second.get(1).getValue()){
                maxPaired = type;
                return true;
            }
            else{
                return false;
            }
        }
        else if(count == 2){
        int count2 = 1;
        type = second.get(0).getValue();
        for(int i=1;i<second.size();i++){
            if(second.get(i).getValue() == type){
                count2++;
            }
        }
        if(count2 == 3){
            maxPaired = type;
            return true;
        }
        else{
            return false;
        }
        }
        else{
            return false;
        }
    }
    public boolean isThree(){//checks if the hand object it is called upon has a three of a kind, returning true or false accordingly, the hand object must be sorted in descending order
        int count = 1;
        int type = hand.get(0).getValue();
        for(int i=1;i<hand.size()+1;i++){
        if(count >= 3){
            maxPaired = type;
            return true;
        }
        else if(i<hand.size() && hand.get(i).getValue() == type){
            count++;
        }
        else{
            count = 1;
            if(i<hand.size()){
            type = hand.get(i).getValue();
            }
            else{
                return false;
            }
        }
        }
        return false;
    }
    public boolean isTwoPair(){//checks to see if the hand object it is called on has two pairs, or not, returning true or false accordingly, the hand object must be sorted in descending order
    int index = 0;
    int count = 0;
    for(int i=0;i<hand.size();i++){
    if(i+1<hand.size() && hand.get(i).getValue() == hand.get(i+1).getValue()){
    count++;
    i++;
    if(hand.get(i).getValue()>index){
    index = i;
    }
    }
    }
    if(count == 2){
         maxPaired = index;
         return true;
    }
    else{
        return false;
    }
    }
    public boolean isPair(){//checks to see if the hand object it is called upon has a pair or not, returning true or false accordingly, the hand must be sorted in descending order
    for(int i=0;i<hand.size()-1;i++){
    if(hand.get(i).getValue() == hand.get(i+1).getValue()){
        maxPaired = hand.get(i).getValue();
        return true;
    }
    }
    return false;
    }
    public String toString(){//prints the hand object with a card on each line
    String output = "";
    for(int i=0;i<hand.size();i++){
    output += hand.get(i).toString();
    output += "\n";
    };
    return output;
    }
    public String getHandType(){// returns what type of hand the function is called upon in standard english like "Royal flush", or "Thre-of-a-kind" and if it doesn't meet any requirements, it returns the highest card
    if(isFlush() == true && isRoyal() == true && isStraight() == true){
        rank = 9;
        return "Royal Flush";
    }
    else if(isStraight() == true && isFlush() == true){
        rank = 8;
        return "Straight Flush";
    }
    else if(isFour() == true){
        rank = 7;
        getMaxPairedCard();
        return " Four-of-a-kind";
    }
    else if(isFull() == true){
        rank = 6;
        getMaxPairedCard();
        return "Full House";
    }
    else if(isFlush() == true){
        rank = 5;
        return "Flush";
    }
    else if(isStraight() == true){
        rank = 4;
        return "Straight";
    }
    else if(isThree() == true){
        rank = 3;
        getMaxPairedCard();
        return "Three-of-a-kind";
    }
    else if(isTwoPair() == true){
        rank = 2;
        getMaxPairedCard();
        return "Two Pair";
    }
    else if(isPair() == true){
        rank = 1;
        getMaxPairedCard();
        return "One Pair";
    }
    else{
    return "High Card";
    }
    }
    public int getRank(){//returns the rank value of a hand object, a value from 1-9
        getHandType();
        return rank;
    }
    public int getMax(){// returns the highest card of a given hand objectt
        int max = hand.get(0).getValue();
        for(int i=0;i<hand.size();i++){
            if(hand.get(i).getValue()>max){
                max = hand.get(i).getValue();
            }
        }
        return max;
    }
    public Card get(int index){// returns the Card object at the specified index of a Hand object, @parameter int index
        return hand.get(index);
    }
    public int getMaxPairedCard(){// returns the card value of the hand object if it meets any of the requirements of any of the ranking parameters, such as a hand with four aces will return 14, whereas a hand with a two pairs, one of 2 and one of 3 will return 3, because 3 is the highest paired card
        return maxPaired;
    }
    public int compareHands(Hand h2){//compares hand 1 and hand 2, of which are both parameters, returns -1 if hand 1 has a greater point value in the game of poker, than hand 2, it returns 1 in the reverse situation, and 0 if they are equal, @parameter Hand h1 @parameter Hand h2, the two hadn objects
        if(getRank() > h2.getRank()){
            return -1;
        }
        else if(getRank() < h2.getRank()){
            return 1;
        }
        else if(getRank() == h2.getRank() && getRank() != 0){
            if(getMaxPairedCard() > h2.getMaxPairedCard()){
                return -1;
            }
            else if(getMaxPairedCard() < h2.getMaxPairedCard()){
                return 1;
            }
            else{
                System.out.println("middle route");
                for(int i=0;i<hand.size();i++){
                if(get(i).getValue() > h2.get(i).getValue()){
                    return -1;
                }
                else if(get(i).getValue() < h2.get(i).getValue()){
                    return 1;
                }
            }
            }
        }
        else if(getRank() == h2.getRank() && getRank() == 0){
            System.out.print("last route");
            for(int i=0;i<hand.size();i++){
                if(get(i).getValue() > h2.get(i).getValue()){
                    return -1;
                }
                else if(get(i).getValue() < h2.get(i).getValue()){
                    return 1;
                }
            }
                return 0;
        }
        return 0;
    }
    // public static void main(String[] args) {
    //     Card c2 = new Card(2, "Spades");
    //     Card c3 = new Card(3, "Clubs");
    //     Card c4 = new Card(4, "Diamonds");
    //     Card c5 = new Card(5, "Spades");
    //     Card c6 = new Card(6, "Hearts");
    //     Card c7 = new Card(7, "Spades");
    //     Card c8 = new Card(8, "Diamonds");
    //     Card c9 = new Card(9, "Clubs");
    //     Card c10 = new Card(10, "Spades");
    //     Card c11 = new Card(11, "Spades");
    //     Card c12 = new Card(12, "Spades");
    //     Card c13 = new Card(13, "Spades");
    //     Card c14 = new Card(14, "Spades");
    //     Card c2a = new Card(2, "Spades");
    //     Card c2b = new Card(3, "Spades");
    //     Card c2c = new Card(4, "Spades");
    //     Card c2d = new Card(5, "Spades");
    //     Card c2e = new Card(6, "Spades");
    //     Hand h1 = new Hand();
    //     Hand h2 = new Hand();
    //     Deck d1 = new Deck();
    //     d1.shuffle();
    //     // h1.addCard(c10); //returns Royal Flush
    //     // h1.addCard(c11);
    //     // h1.addCard(c12);
    //     // h1.addCard(c13);
    //     // h1.addCard(c14);

    //     // h2.addCard(c10); //returns Royal Flush
    //     // h2.addCard(c11);
    //     // h2.addCard(c12);
    //     // h2.addCard(c13);
    //     // h2.addCard(c14);
    //----------------------------------------------------------- no wins returns 0
    //     // h2.addCard(c2a);
    //     // h2.addCard(c2b);
    //     // h2.addCard(c2c); //returns Straight Flush
    //     // h2.addCard(c2d);
    //     // h2.addCard(c2e); 
        
    //     // h1.addCard(c2); //returns Four-of-a-kind
    //     // h1.addCard(c2);
    //     // h1.addCard(c2);
    //     // h1.addCard(c2);
    //     // h1.addCard(c5);
    //-----------------------------------------------------------  hand two wins here returning 1
    //     // h1.addCard(c2); //returns Full House
    //     // h1.addCard(c2);
    //     // h1.addCard(c2);
    //     // h1.addCard(c4);
    //     // h1.addCard(c4);
        
    //     // h2.addCard(c2); //returns straight
    //     // h2.addCard(c3);
    //     // h2.addCard(c4);
    //     // h2.addCard(c5);
    //     // h2.addCard(c6);
    //-----------------------------------------------------------  hand one wins here returning -1
    //     // h1.addCard(c2); //returns Three-of-a-kind
    //     // h1.addCard(c2);
    //     // h1.addCard(c2);
    //     // h1.addCard(c5);
    //     // h1.addCard(c6);

    //     // h2.addCard(c2); //returns Two Pair
    //     // h2.addCard(c2);
    //     // h2.addCard(c4);
    //     // h2.addCard(c4);
    //     // h2.addCard(c6);
    //-----------------------------------------------------------   hand one wins here returning -1
    //     // h1.addCard(c2); //returns One Pair
    //     // h1.addCard(c2);
    //     // h1.addCard(c4);
    //     // h1.addCard(c5);
    //     // h1.addCard(c6);
    
    //     // h2.addCard(c2); //returns High Card in this case 7
    //     // h2.addCard(c7);
    //     // h2.addCard(c4);
    //     // h2.addCard(c5);
    //     // h2.addCard(c6);
    //-----------------------------------------------------------  hand one wins here returning -1
    //     // h1.addCard(c2); //returns High Card in this case 7
    //     // h1.addCard(c7);
    //     // h1.addCard(c4);
    //     // h1.addCard(c4);
    //     // h1.addCard(c6);

    //     // h2.addCard(c2); //returns High Card in this case 7
    //     // h2.addCard(c7);
    //     // h2.addCard(c4);
    //     // h2.addCard(c5);
    //     // h2.addCard(c6);    
    //-----------------------------------------------------------  hand two wins here because the third highest card is 5 on h2 and 4 on h1 so h2 wins returning 1
    //     // h1.addCard(c2); //returns One Pair
    //     // h1.addCard(c4);
    //     // h1.addCard(c4);
    //     // h1.addCard(c5);
    //     // h1.addCard(c6);

    //     // h2.addCard(c2); //returns One Pair
    //     // h2.addCard(c2);
    //     // h2.addCard(c4);
    //     // h2.addCard(c5);
    //     // h2.addCard(c6);
    //----------------------------------------------------------- hand one wins here with a pair of 4 versus h2's pair of twos, returning -1
    //     // h1.addCard(c2); //returns One Pair
    //     // h1.addCard(c4);
    //     // h1.addCard(c4);
    //     // h1.addCard(c5);
    //     // h1.addCard(c6);

    //     // h2.addCard(c2); //returns One Pair
    //     // h2.addCard(c4);
    //     // h2.addCard(c4);
    //     // h2.addCard(c5);
    //     // h2.addCard(c6);
    //----------------------------------------------------------- complete tie no winners returns 0
    //     // h1.addCard(c2); //returns One Pair
    //     // h1.addCard(c4);
    //     // h1.addCard(c4);
    //     // h1.addCard(c5);
    //     // h1.addCard(c6);

    //     // h2.addCard(c3); //returns One Pair
    //     // h2.addCard(c4);
    //     // h2.addCard(c4);
    //     // h2.addCard(c5);
    //     // h2.addCard(c6);
    //----------------------------------------------------------- hand two wins with it final card value 3 beat hand one's final card of 2, returning 1
    //     // h1.addCard(c2); //returns Full House
    //     // h1.addCard(c2);
    //     // h1.addCard(c2);
    //     // h1.addCard(c4);
    //     // h1.addCard(c4);

    //     // h1.addCard(c3); //returns Full House
    //     // h1.addCard(c3);
    //     // h1.addCard(c3);
    //     // h1.addCard(c4);
    //     // h1.addCard(c4);
    //----------------------------------------------------------- hand two wins with a higher value trio, returning 1    
    //     // h1.addCard(c7); //returns straight
    //     // h1.addCard(c3);
    //     // h1.addCard(c4);
    //     // h1.addCard(c5);
    //     // h1.addCard(c6);

    //     // h2.addCard(c2); //returns straight
    //     // h2.addCard(c3);
    //     // h2.addCard(c4);
    //     // h2.addCard(c5);
    //     // h2.addCard(c6);
    //----------------------------------------------------------- hand one wins with a higher value straight returning -1
    //     // System.out.println(h1.compareHands(h2));
    // }
}