import java.util.ArrayList;

public class Dealer{


    //FIXME: Step 1: declare the data members => DONE
    private ArrayList<Card> dealersHand;
    private Deck theDeck;


    //FIXME: Step 2: create the default constructor => DONE
    Dealer(){
        dealersHand = new ArrayList<Card>();
        theDeck = new Deck();
    }

    //FIXME: Step 3: create the dealHand() method => returns an ArrayList<Card>
    // of three cards removed from theDeck => DONE
    public ArrayList<Card> dealHand(){

        ArrayList<Card> cardHolder = new ArrayList<Card>();
        int size = theDeck.size();

        //Check if the size of the deck
        //If more than 34 => we are good. Else: create the new deck.
        if(size > 34){
            System.out.println("There are more than 34 cards left in the deck.");
        }
        else{
            theDeck.newDeck();
        }

        //Take the top 3 card and store them inside temporary container
        //Top 3 card are at index 0 => when I remove the top card
        //The second after the previous top becomes the new top.
        /*for(int i = 0; i < 3; i++){
            Card card = theDeck.remove(0);
            cardHolder.add(card);
        }*/

        //return cardHolder;
        return returnCards();
    }



    private ArrayList<Card> returnCards() {
        ArrayList<Card> temp = new ArrayList<Card>();
        for(int i = 0; i < 3; i++)
            temp.add(theDeck.remove(0));
        return temp;
    }

    //FIXME: Step 4: getters and setters => DONE

    //Allows to get the Deck
    public Deck getDeck(){
        //System.out.println("The getDeck works correctly!");
        return theDeck;
    }

    //Allows to get the dealersHand
    public ArrayList<Card> getDealersHand(){
        //System.out.println("The getDealersHand works correctly!");
        return dealersHand;
    }

    //Allows to set the DealersHand
    public void setDealersHand(ArrayList<Card> dealersHand){
        //System.out.println("The setDealersHand works correctly!");
        this.dealersHand = dealersHand;
    }

    //Allows to set the theDeck
    public void setDeck(Deck theDeck){
        this.theDeck = theDeck;
    }

}
