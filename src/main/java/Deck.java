import java.util.ArrayList;
import java.util.Collections;

public class Deck extends ArrayList<Card>{

    //FIXME: Step 1: create the default constructor => DONE

    Deck(){

        //Create the array with card letters
        //char[] cards = {'C', 'D', 'S', 'H'};
        char cards[] = {'S', 'D', 'C', 'H'};


        int i = 0;
        do{
            int j;
            for(j = 2; j <= 14; j++) {
                this.add(new Card(cards[i], j));
                //System.out.println(cards[i]);
            }
            i++;
        }while(i < 4);

        //Mix the cards in random order
        Collections.shuffle(this);
    }

    /*FIXME: Step 2: create newDeck() => clears all the cards => DONE
    and creates a brand new deck of 52 cards sorted in
    random order*/

    public void newDeck(){

        //Destroy the current Deck of cards to create the new one
        this.clear();

        //Create the array with card letters
        char cards[] = {'S', 'D', 'C', 'H'};

        int i = 0;

        do{
            int j;
            for(j = 2; j <= 14; j++) {
                this.add(new Card(cards[i], j));
                //System.out.println(cards[i]);
            }
            i++;
        }while(i < 4);

        //Mix the cards in random order
        Collections.shuffle(this);

    }

}
