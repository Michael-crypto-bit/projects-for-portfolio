package Poker;

import java.awt.Color;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JPanel;

/**

 * A JFrame that displays a Hand of Cards

 */

public class Runner extends JFrame

{   

  public Runner( String title )

    {

        super( title );

        initComponents();

    }

    

    /**

     * Initializes the JFrame's components

     */

    private void initComponents()

    {

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        getContentPane().setLayout(new java.awt.GridLayout(0, 1));

        

         

       /*

* ADD CODE HERE TO CREATE AN ARRAY OF HANDS, DEAL 5 CARDS EACH FROM A SHUFFLED DECK

 * THEN, CREATE A boolean[] TO TRACK WHICH OF THE HANDS ARE UNBEATEN (DETERMINE THIS 

* ALGORITHMICALLY. NOTE THESE ARRAYS ARE CALLED ‘hands’ and ‘unbeaten’ in the for 

* loop below 

 */
  Hand hand1 = new Hand();
  Hand hand2 = new Hand();
  Hand hand3 = new Hand();
  Hand hand4 = new Hand();
    //     // h1.addCard(c2a);
    //     // h1.addCard(c2b);
    //     // h1.addCard(c2c); //Straight Flush
    //     // h1.addCard(c2d);
    //     // h1.addCard(c2e); 
        
    //     // h2.addCard(c2); //returns Four-of-a-kind
    //     // h2.addCard(c2);
    //     // h2.addCard(c2);
    //     // h2.addCard(c2);
    //     // h2.addCard(c5);

    //     // h3.addCard(c2); //returns Full House
    //     // h3.addCard(c2);
    //     // h3.addCard(c2);
    //     // h3.addCard(c4);
    //     // h3.addCard(c4);
        
    //     // h4.addCard(c2); //returns straight
    //     // h4.addCard(c3);
    //     // h4.addCard(c4);
    //     // h4.addCard(c5);
    //     // h4.addCard(c6);
//--------------------------------------------------------------first four returns player hand1 as the winner no matter the order
    //     // h4.addCard(c2); //returns Three-of-a-kind
    //     // h4.addCard(c2);
    //     // h4.addCard(c2);
    //     // h4.addCard(c5);
    //     // h4.addCard(c6);

    //     // h3.addCard(c2); //returns Two Pair
    //     // h3.addCard(c2);
    //     // h3.addCard(c4);
    //     // h3.addCard(c4);
    //     // h3.addCard(c6);

    //     // h2.addCard(c2); //returns One Pair
    //     // h2.addCard(c2);
    //     // h2.addCard(c4);
    //     // h2.addCard(c5);
    //     // h2.addCard(c6);

    //     // h1.addCard(c2); //High Card in this case 7
    //     // h1.addCard(c7);
    //     // h1.addCard(c4);
    //     // h1.addCard(c5);
    //     // h1.addCard(c6);
    //---------------------------------------------------returns hand4 as winning, because it is a three of a kind and therefore beats every other hand
    //     // h1.addCard(c2); //High Card in this case 7
    //     // h1.addCard(c7);
    //     // h1.addCard(c4);
    //     // h1.addCard(c5);
    //     // h1.addCard(c6);

    //     // h2.addCard(c2); //High Card in this case 7
    //     // h2.addCard(c7);
    //     // h2.addCard(c4);
    //     // h2.addCard(c5);
    //     // h2.addCard(c6);

    //     // h3.addCard(c2); //High Card in this case 7
    //     // h3.addCard(c3);
    //     // h3.addCard(c4);
    //     // h3.addCard(c5);
    //     // h3.addCard(c7);

    //     // h4.addCard(c2); //High Card in this case 7
    //     // h4.addCard(c7);
    //     // h4.addCard(c4);
    //     // h4.addCard(c5);
    //     // h4.addCard(c6);
    //---------------------------------------------------------------returns hands 1,2,and 4 as winning because they all have a high card of 7 but hand three has a next highest car of 5 where evry other hand has a next highest card of 6, and the cards are mostly the same throughout the rest of 1,2,and 4
  Deck d1 = new Deck();
    d1.shuffle();
  for(int i=0;i<5;i++){
    hand1.addCard(d1.deal()); // commented out when hard coding for testing
    hand2.addCard(d1.deal());
    hand3.addCard(d1.deal());
    hand4.addCard(d1.deal());
  }
  Hand[] hands = new Hand[4];
  hands[0] = hand1;
  hands[1] = hand2;
  hands[2] = hand3;
  hands[3] = hand4;
  for(int i=0;i<hands.length;i++){
  System.out.println(hands[i]);
  }
  boolean[] unbeaten = new boolean[4];
  // System.out.println(hand1.compareHands(hand2));
  // System.out.println(hand1.compareHands(hand3));
  // System.out.println(hand1.compareHands(hand4));

  // System.out.println(hand2.compareHands(hand1));
  // System.out.println(hand2.compareHands(hand3));
  // System.out.println(hand2.compareHands(hand4));

  // System.out.println(hand3.compareHands(hand1));
  // System.out.println(hand3.compareHands(hand2));
  // System.out.println(hand3.compareHands(hand4));

  // System.out.println(hand4.compareHands(hand1));
  // System.out.println(hand4.compareHands(hand2));
  // System.out.println(hand4.compareHands(hand3));
  if((hand1.compareHands(hand2) <= 0)&&
  (hand1.compareHands(hand3) <= 0)&&
  (hand1.compareHands(hand4) <= 0)){
    unbeaten[0] = true;
  }
  if((hand2.compareHands(hand1) <= 0)&&
  (hand2.compareHands(hand3) <= 0)&&
  (hand2.compareHands(hand4) <= 0)){
    unbeaten[1] = true;
  }
  if((hand3.compareHands(hand1) <= 0)&&
  (hand3.compareHands(hand2) <= 0)&&
  (hand3.compareHands(hand4) <= 0)){
    unbeaten[2] = true;
  }
  if((hand4.compareHands(hand1) <= 0)&&
  (hand4.compareHands(hand2) <= 0)&&
  (hand4.compareHands(hand3) <= 0)){
    unbeaten[3] = true;
  }
  for(int i=0;i<unbeaten.length;i++){
    if(unbeaten[i] == true){
      System.out.println("the winner is player: "+(i+1));
    }
  }
    

        

       

       // Creates a HandPanel for each hand

        for(int i = 0; i < 4; i++) {

         JPanel p = new JPanel();

         p.setLayout(new java.awt.FlowLayout(FlowLayout.LEADING));

         if(unbeaten[i]) {

          p.setBackground(Color.YELLOW);

         }

         p.add(new HandPanel(hands[i]));

         p.add(new JLabel(hands[i].getHandType()));

         add(p);

        }




        pack();

    }

    

       

    /**

     * The main method launches the JFrame

     */

    public static void main( String[] args )

    {

        

     /* Create and display the form */

     java.awt.EventQueue.invokeLater(new Runnable() {

   

   @Override

   public void run() {

    new Runner("Poker").setVisible(true);

    

   }

  });

    }

}
