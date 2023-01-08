public class Card {

    //FIXME:Step 1: define the data members => DONE
    private char suit;
    private int value;

    //FIXME: Step 2: create default constructor => DONE
    Card(char suit, int value){
        this.suit = suit;
        this.value = value;
    }

    //FIXME: Step 3: create getters + setters => DONE
    public int getValue(){
        return value;
    }

    public char getSuit(){
        return suit;
    }


    public void setValue(int value){
        this.value = value;
    }



    public void setSuit(char suit){
        this.suit = suit;
    }
}
