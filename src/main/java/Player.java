import java.util.ArrayList;

public class Player {

    //FIXME: Step 1: declare the data members => DONE
    private ArrayList<Card> hand;
    private int anteBet;
    private int playBet;
    private int pairPlusBet;
    private int totalWinnings;

    private int  totalAmount; //FIXME: DELETE
    private boolean didFold;

    //FIXME: Step 2: create the default constructor => DONE
    Player(){
        this.anteBet = 0;
        this.playBet = 0;
        this.hand = new ArrayList<Card>();
        this.pairPlusBet = 0;
        this.totalWinnings = 0;
        //FIXME: add two more
        totalAmount = 1000; //FIXME: DELETE
        didFold = false;
    }

    //FIXME 3: getters + setters => DONE

    //Sets the anteBet with the provided value
    public void setAnteBet(int anteBet){
        this.anteBet = anteBet;
    }

    //Sets the playBet with the provided value
    public void setPlayBet(int playBet){
        this.playBet = playBet;
    }

    //Sets the hand with the provided value
    public void setHand(ArrayList<Card> hand){
        this.hand = hand;
    }

    //Sets the pairPlusBet with the provided value
    public void setPairPlusBet(int pairPlusBet){
        this.pairPlusBet = pairPlusBet;
    }

    //Sets the totalWinnings with the provided value
    public void setTotalWinnings(int totalWinnings){
        this.totalWinnings = totalWinnings;
    }

    //Gets the anteBet and returns the value
    public int getAnteBet(){
        return this.anteBet;
    }

    //Gets the playBet and returns the value
    public int getPlayBet(){
        return this.playBet;
    }

    //Gets the ArrayList<Card> hand and returns the value
    public ArrayList<Card> getHand(){
        return this.hand;
    }

    //Gets the pairPlusBet and returns the value
    public int getPairPlusBet(){
        return this.pairPlusBet;
    }

    //Gets the totalWinnings and returns the value
    public int getTotalWinnings(){
        return this.totalWinnings;
    }

    //FIXME: DELETE

    public int getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(int money) {
        this.totalAmount = money;
    }
    public boolean getDidFold() {
        return didFold;
    }
    public void setDidFold(boolean fold) {
        didFold = fold;
    }


}
