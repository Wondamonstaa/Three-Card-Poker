import java.util.ArrayList;
import java.util.Collections;

public class ThreeCardLogic{

    //FIXME: Step 1: create the evalHand() => returns an integer
    // value representing the value of the hand passed in => DONE
    public static int evalHand(ArrayList<Card> hand){

        String highCards[] = {"Ace", "King", "Queen", "Jack"};

        /*
        Straight flush is a hand
        that contains five cards of sequential rank,
        all of the same suit, such as Q♥ J♥ 10♥ 9♥ 8♥ (a "queen-high straight flush").
         */


        for(int i = 0; i < hand.size()-1; i++) {
            int smallest = i;
            for(int j = i+1; j < hand.size(); j++) {
                if(hand.get(j).getValue() < hand.get(smallest).getValue()) {
                    smallest = j;
                }
            }
            Card temp = hand.get(smallest);
            hand.set(smallest, hand.get(i));
            hand.set(i, temp);
        }


        //Collections.sort(hand);
        /*
        int size = hand.size();
        int reverse = hand.size()-1;

        int k = 0;
        int m = k + 1;

        //FIXME
        while(k < reverse){
            int temp = k;

            while(m < size){
                //if(hand.get(m).getValue() < hand.get(temp).getValue()){
                if(compare(hand, k, temp)){
                    temp = m;
                    //System.out.println("The smallest value was found!");
                }
                else{
                    temp = temp;
                    //System.out.println("The smallest velue was not found!");
                }
                m++;
            }
            k++;
            //m++;
            Card holder = hand.get(temp);
            hand.set(temp, hand.get(k));
            hand.set(k, holder);
        }*/

        Card card1 = hand.get(0);
        Card card2 = hand.get(1);
        Card card3 = hand.get(2);


        /*
        for(int i = 0; i < reverse; i++){
            int temp = i;
            for(int j = i + 1; j < size; j++){
                if(hand.get(j).getValue() < hand.get(temp).getValue()){
                    temp = j;
                    //System.out.println("The smallest value was found!");
                }
                else{
                    temp = temp;
                    //System.out.println("The smallest velue was not found!");
                }
            }
        }*/
        return controller(card1, card2, card3);
    }


    //Helper function to pass the value to the original function => simplicity
    public static int controller(Card card1, Card card2, Card card3){

        if(straightFlash(card1, card2, card3)){
            //System.out.println("1 is returned!");
            return 1;
        }
        else if(threeKind(card1, card2, card3)){
            //System.out.println("2 is returned!");
            return 2;
        }
        else if(straightTest(card1, card2, card3)){
            //System.out.println("3 is returned!");
            return 3;
        }
        else if(simpleFlash(card1, card2, card3)){
            //System.out.println("4 is returned!");
            return 4;
        }
        else if(pair(card1, card2, card3)){
            //System.out.println("5 is returned!");
            return 5;
        }
        else{
            //System.out.println("0 is returned!");
            return 0;
        }

    }


    //Helper function to check the first condition: a straight flush.
    //Returns true if it is indeed a straight flush. False otherwise.
    public static Boolean straightFlash(Card one, Card two, Card three){

        //System.out.println("The straightFlash() is working!");

        if((one.getValue() == two.getValue() - 1) &&
                ((one.getSuit() == two.getSuit()) && two.getValue() == two.getValue()-1) && (two.getSuit() == three.getSuit())){
                return true;
        }
        else{
            return one.getValue() == 2 &&
                    two.getValue() == 3 &&
                    three.getValue() == 14 &&
                    one.getSuit() == two.getSuit() &&
                    two.getSuit() == two.getSuit();
        }
    }


    //Helper function to test the three of a kind cards
    public static Boolean threeKind(Card one, Card two, Card three){

        return one.getValue() == two.getValue() && two.getValue() == three.getValue();

    }


    //Helper function to test if two cards have the same value or not
    public static Boolean pair(Card one, Card two, Card three){

        return one.getValue() == two.getValue() || two.getValue() == three.getValue() || one.getValue() == three.getValue() ;
    }


    //Helper function to test the flash
    public static Boolean simpleFlash(Card one, Card two, Card three){
        return one.getSuit() == two.getSuit() && two.getSuit() == three.getSuit();
    }


    //Helper function to test the three for a straight
    public static Boolean straightTest(Card one, Card two, Card three){

        //FIXME: Straight = any five consecutive cards of different suits.

		if((one.getValue() == two.getValue() - 1) && (two.getValue() == three.getValue() - 1)) {
            return true;
        }

        else return one.getValue() == 2 &&
                two.getValue() == 3 &&
                three.getValue() == 14;
    }


    //Helper function => returns true if the value at the current index is less than value stored in the temporary variable
    public static Boolean compare(ArrayList<Card> hand, int index, int temp){

        return hand.get(index).getValue() < hand.get(temp).getValue();

    }


    //Helper function: used to compare the Dealer's hand
    public static void comparator(ArrayList<Card> toCompare){

        int size = toCompare.size();
        int reverse = toCompare.size() - 1;

        int k = 0;
        int m = k + 1;

        //FIXME
        while(k < reverse){
            int temp = k;

            while(m < size){
                //if(hand.get(m).getValue() < hand.get(temp).getValue()){
                if(compare(toCompare, k, temp)){
                    temp = m;
                    //System.out.println("The smallest value was found!");
                }
                else{
                    temp = temp;
                    //System.out.println("The smallest value was not found!");
                }
                m++;
            }
            k++;
            //m++;
            Card holder = toCompare.get(temp);
            toCompare.set(temp, toCompare.get(k));
            toCompare.set(k, holder);
        }
    }


    //Helper function for compareHands() => sorts both hands in ascending order + compares the hands at the specified index
    static int equalHands(ArrayList<Card> dealer, ArrayList<Card> player) {

        //Step 1: sort both hands in ascending order
        comparator(dealer);
        comparator(player);

        int pos = 2;

        while(pos >= 0){
            if(dealer.get(pos).getValue() == player.get(pos).getValue()){
                pos--;
            }
            else if(dealer.get(pos).getValue() > player.get(pos).getValue()){
                return 1;
            }
            else{
                return 2;
            }
        }

        return 0;
    }


    //Helper function to check which card from the deck is double
    static int equilizer(ArrayList<Card> target){


        //checks which card is the double for player

                /*if(player.get(0).getValue() == player.get(1).getValue())	//1st and 2nd card
                    valDouble1 = player.get(0).getValue();
                else if(player.get(0).getValue() == player.get(2).getValue())	//1st and 3rd card
                    valDouble1 = player.get(0).getValue();
                else	//2nd and 3rd card
                    valDouble1 = player.get(1).getValue();

                //checks which card is the double for dealer
                if(dealer.get(0).getValue() == dealer.get(1).getValue())	//1st and 2nd card
                    valDouble2 = dealer.get(0).getValue();
                else if(dealer.get(0).getValue() == dealer.get(2).getValue())	//1st and 3rd card
                    valDouble2 = dealer.get(0).getValue();
                else	//2nd and 3rd card
                    valDouble2 = dealer.get(1).getValue();
                */

        int result;

        if(target.get(0).getValue() == target.get(1).getValue()){
            result = target.get(0).getValue();
        }
        else if(target.get(0).getValue() == target.get(2).getValue()){
            result = target.get(0).getValue();
        }
        else{
            result = target.get(1).getValue();
        }

        return result;
    }


    //Helper function to find the highest card in the hand
    public static int highDeckChecker(ArrayList <Card> target, int cardNumber){

        int result = 0;

        for(Card c: target){
            if(c.getValue() != cardNumber) {
                result = c.getValue();
            }
            else{
                throw new IllegalArgumentException("The card number is not valid!");
            }
        }

        return result;
    }


    //Helper function to check if either player or dealer has the highest card
    public static int doubleCardsComparator(int first, int second){

        //Equal
        if(first == second){
            return 0;
        }
        //Player's card is higher
        else if(first > second){
            return 2;
        }
        //Dealer has a better card
        else{
            return 1;
        }
    }


    //Helper function to check if the cards in both player's or dealer's hands are equal or not
    public static int noHighCardChecker(int pHand, int dHand, ArrayList <Card> player, ArrayList <Card> dealer){

        //Check if the cards are the same => if so, compare the next cards in a row
        if(dHand == pHand){
            //System.out.println("The cards are the same!");
            return equalHands(dealer, player);
        }
        else if(dHand > pHand){
            return 2;
        }
        else{
            //System.out.println("Player's card is lower!");
            return 1;
        }
    }


    // FIXME: Step 2: create the evalPPWinnings() => returns the amount won for the PairPlus bet. It will
    //  evaluate the hand and then evaluate the winnings and return the amount won. If the
    //  player lost the Pair Plus bet, it will just return 0
    public static int evalPPWinnings(ArrayList <Card> hand, int pairPlusBet){

        int toEval = evalHand(hand);

        if(toEval == 0){
            //System.out.println("Returned the value for high hand!");
            return 0;
        }
        else if(toEval == 1){
            System.out.println("Return the value for special case flash!");
            return pairPlusBet * 40 + pairPlusBet;
        }
        else if(toEval == 2){
            //System.out.println("Return the value for three of a kind!");
            return pairPlusBet * 30 + pairPlusBet;
        }
        else if(toEval == 3){
            //System.out.println("Return the value for straight!");
            return pairPlusBet * 6 + pairPlusBet;
        }
        else if(toEval == 4){
            //System.out.println("Return the value for flash!");
            return pairPlusBet * 3 + pairPlusBet;
        }
        else if(toEval == 5){
            //System.out.println("Return the value for pair!");
            return pairPlusBet * 2;
        }
        else{
            return 0;
        }

    }


    //FIXME: Step 3: create the compareHands() => compares the two hands passed in and returns an
    // integer based on which hand won.
    public static int compareHands(ArrayList<Card> player, ArrayList<Card> dealer){

        /*
        0 if neither hand won
        1 if the dealer hand won
        2 if the player hand won
         */

        //Step 1: get the two hands => Player and Dealer
        int playersHand = evalHand(player);
        int dealersHand = evalHand(dealer);


        //Step 2: compare the two hands => Player and Dealer
        if(dealersHand == 0 || playersHand == 0){
            comparator(dealer);

            //if both hands are both 0, look for the hand with highest value
            //if both hand has same value, look for second highest then third
            //if both have same value hands, then draw
            //if dealer doesn't have a Queen or higher, return wager
            if(dealer.get(2).getValue() < 12 && dealersHand == 0){
                return 0;
            }
            if(dealersHand == 0 && playersHand == 0){
                //System.out.println("Both hands are EQUAL!");
                return equalHands(dealer, player);
            }
            else if(dealersHand == 0){
                //System.out.println("Dealer, better luck next time! You got a high card hand! Player wins!");
                return 2;
            }
            else{
                //System.out.println("Player, better luck next time! You got a high card hand! Dealer wins!");
                return 1;
            }
            //FIXME
        }


        //Step 3: check if player + dealer have a pair at the same time => if so, compare the pair
		else if(dealersHand == 5 && playersHand == 5){

                //Stores values for further comparison
                int card1 = equilizer(player);
                int card2 = equilizer(dealer);

                if(card1 > card2){
                    //System.out.println("Player's card is higher!");
                    return 2;
                }
                else if(card1 < card2){
                    //System.out.println("Dealer's card is higher!");
                    return 1;
                }
                else{
                    //System.out.println("Both hands have the same value! Checking the last cards!");
                    int playersHigh = highDeckChecker(player, card1);
                    int dealersHigh = highDeckChecker(dealer, card2);
                    return doubleCardsComparator(playersHigh, dealersHigh);
                }
            }
            else{
                //System.out.println("No one has a high card!");
                return noHighCardChecker(playersHand, dealersHand, player, dealer);
            }
        }
    }
