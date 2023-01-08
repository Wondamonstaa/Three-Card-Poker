import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

class MyTest {


	@Test
	@DisplayName("Test Constructor")
	void testConstructor() {
		Dealer dealer = new Dealer();
		assertNotNull(dealer);
	}


	@Test
	@DisplayName("Test dealHand()")
	void testDealHand(){
		Dealer dealer = new Dealer();
		assertNotNull(dealer.dealHand());
	}


	@Test
	@DisplayName("Test getters + setters")
	void testGettersSetters(){

		Dealer dealer = new Dealer();
		dealer.setDealersHand(dealer.dealHand());
		assertNotNull(dealer.getDealersHand());
		assertNotNull(dealer.getDeck());

	}

	@Test
	@DisplayName("Test toString()")
	void testToString(){

		Dealer dealer = new Dealer();
		dealer.setDealersHand(dealer.dealHand());
		assertNotNull(dealer.toString());
	}


	@Test
	@DisplayName("Test Card")
	void testCard(){

		Card card = new Card('S', 1);
		assertNotNull(card);
	}


	@Test
	@DisplayName("Test dealHand()")
	void testDealHandCard(){
		Dealer card = new Dealer();
		assertNotNull(card.dealHand());

		assertEquals(3, card.dealHand().size());

		int total = 0;
		for(int i = 0; i < card.dealHand().size(); i++) {
			total += card.dealHand().get(i).getValue();
		}
	}


	@Test
	@DisplayName("Test getDeck()")
	void testGetDeck(){
		Dealer dealer = new Dealer();
		assertNotNull(dealer.getDeck());

		if(dealer.getDeck().size() > 34){
			System.out.println("There are more than 34 cards left in the deck.");
		}
		else{
			dealer.getDeck().newDeck();
		}
	}


	@Test
	@DisplayName("Test getDealersHand()")
	void testGetDealersHand(){

		Dealer dealer = new Dealer();
		assertNotNull(dealer.getDealersHand());

		//test if the size of the dealersHand is 5
		assertEquals(0, dealer.getDealersHand().size());

	}


	@Test
	@DisplayName("Test setDeck()")
	void testSetDeck(){
		Dealer dealer = new Dealer();
		dealer.setDeck(dealer.getDeck());
		assertNotNull(dealer.getDeck());
	}


	@Test
	@DisplayName("Test dealHand()")
	void testDealHand2(){

		Dealer dealer = new Dealer();
		assertNotNull(dealer.dealHand());
		System.out.println(dealer.dealHand());

		assertEquals(3, dealer.dealHand().size());
	}


	@Test
	@DisplayName("Test setAnteBet()")
	void testSetAnteBet(){

		Player player = new Player();
		player.setAnteBet(10);
		assertEquals(10, player.getAnteBet());
	}


	@Test
	@DisplayName("Test setPlayBet()")
	void testSetPlayBet(){

		Player player = new Player();
		player.setPlayBet(100);
		assertEquals(100, player.getPlayBet());
	}


	@Test
	@DisplayName("Test setHand()")
	void testSetHand(){

		Player player = new Player();
		player.setHand(player.getHand());
		assertNotNull(player.getHand());

		//check if hand is not empty. If so print the message
		if(player.getHand().size() == 0){
			System.out.println("Error: the hand is empty!");
		}
	}

	@Test
	@DisplayName("Test setPairPlusBet()")
	void testSetPairPlusBet(){

		Player player = new Player();
		player.setPairPlusBet(3123);
		assertEquals(3123, player.getPairPlusBet());
	}


	@Test
	@DisplayName("Test evalHand()")
	void testEvalHand(){
		ThreeCardLogic logic = new ThreeCardLogic();
		Card card1 = new Card('S', 1);
		Card card2 = new Card('S', 2);
		Card card3 = new Card('S', 3);
		ArrayList<Card> hand = new ArrayList<>();
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		assertEquals(3, logic.evalHand(hand));
	}


	@Test
	@DisplayName("Test compareHands()")
	void testCompareHands(){

		ArrayList<Card> hand = new ArrayList<>();
		Card card1 = new Card('S', 1);
		Card card2 = new Card('S', 2);
		Card card3 = new Card('S', 3);
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);

		ArrayList<Card> hand2 = new ArrayList<>();
		Card card4 = new Card('S', 1);
		Card card5 = new Card('S', 2);
		Card card6 = new Card('S', 3);
		hand2.add(card4);
		hand2.add(card5);
		hand2.add(card6);

		ThreeCardLogic logic = new ThreeCardLogic();
		assertEquals(0, ThreeCardLogic.compareHands(hand, hand2));
	}

	@Test
	@DisplayName("Test doubleCardsComparator()")
	void testDoubleCardsComparison(){
		ThreeCardLogic logic = new ThreeCardLogic();
		Card card1 = new Card('D', 1);
		Card card2 = new Card('A', 2);
		Card card3 = new Card('S', 3);
		ArrayList<Card> hand = new ArrayList<>();
		assertEquals(1, logic.doubleCardsComparator(10, 20));
	}

	@Test
	@DisplayName("Test evalPPWinnings()")
	void testEvalPPWinnings3(){
		ThreeCardLogic logic = new ThreeCardLogic();
		Card card1 = new Card('S', 424);
		Card card2 = new Card('S', 4242);
		Card card3 = new Card('S', 1111);
		ArrayList<Card> hand = new ArrayList<>();
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		assertEquals(169696, ThreeCardLogic.evalPPWinnings(hand, 42424));
	}


	@Test
	@DisplayName("Test pair()")
	void testPair(){
		ThreeCardLogic logic = new ThreeCardLogic();
		Card card1 = new Card('S', 1);
		Card card2 = new Card('O', 2);
		Card card3 = new Card('S', 3);
		assertFalse(ThreeCardLogic.pair(card1, card2, card3));
	}

	@Test
	@DisplayName("Test simpleFlash()")
	void testFlash(){
		ThreeCardLogic logic = new ThreeCardLogic();
		Card card1 = new Card('S', 5);
		Card card2 = new Card('D', 2);
		Card card3 = new Card('D', 5);
		ArrayList<Card> hand = new ArrayList<>();
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		assertFalse(ThreeCardLogic.simpleFlash(card3, card2, card1));
	}


	@Test
	@DisplayName("Test evalHand()")
	void testEvalHand2(){
		ThreeCardLogic logic = new ThreeCardLogic();
		Card card1 = new Card('S', 1);
		Card card2 = new Card('S', 2);
		Card card3 = new Card('S', 3);
		ArrayList<Card> hand = new ArrayList<>();
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		assertEquals(3, ThreeCardLogic.evalHand(hand));
	}


	@Test
	@DisplayName("Test highDeckChecker()")
	void testHighDeckChecker(){
		ThreeCardLogic logic = new ThreeCardLogic();
		Card card1 = new Card('S', 1);
		Card card2 = new Card('S', 2);
		Card card3 = new Card('S', 3);
		ArrayList<Card> hand = new ArrayList<>();
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		assertEquals(3, ThreeCardLogic.highDeckChecker(hand, 10));
	}


	@Test
	@DisplayName("Test simpleFlash()")
	void testSimpleFlash(){
		ThreeCardLogic logic = new ThreeCardLogic();
		Card card1 = new Card('S', 1);
		Card card2 = new Card('S', 2);
		Card card3 = new Card('S', 3);
		ArrayList<Card> hand = new ArrayList<>();
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		assertTrue(ThreeCardLogic.simpleFlash(card3, card2, card1));
	}


	@Test
	@DisplayName("Test evalPPWinnings()")
	void testEvalPPWinnings2(){
		ThreeCardLogic logic = new ThreeCardLogic();
		Card card1 = new Card('S', 12);
		Card card2 = new Card('S', 32);
		Card card3 = new Card('S', 42);
		ArrayList<Card> hand = new ArrayList<>();
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		assertEquals(3796, ThreeCardLogic.evalPPWinnings(hand, 949));
	}

	@ParameterizedTest
	@CsvSource({"42, 24, 43, 31", "421, 342, 253, 643", "2654, 1465, 643, 2433", "2654, 23, 541, 63", "365, 165, 3264, 643", "643, 264, 641, 643"})
	void testIterative2(int c1, int c2, int c3, int expected) {
		Card card1 = new Card('S', c1);
		Card card2 = new Card('S', c2);
		Card card3 = new Card('S', c3);
		assertEquals(4, ThreeCardLogic.controller(card1, card2, card3));
	}

	@Test
	@DisplayName("Test evalPPWinnings()")
	void testEvalPPWinnings4(){
		ThreeCardLogic logic = new ThreeCardLogic();
		Card card1 = new Card('S', 1);
		Card card2 = new Card('S', 2);
		Card card3 = new Card('S', 3);
		ArrayList<Card> hand = new ArrayList<>();
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		assertEquals(296968, ThreeCardLogic.evalPPWinnings(hand, 42424));
	}

	@Test
	@DisplayName("Test controller()")
	void testController(){
		ThreeCardLogic logic = new ThreeCardLogic();
		Card card1 = new Card('S', 1);
		Card card2 = new Card('S', 2);
		Card card3 = new Card('S', 3);
		ArrayList<Card> hand = new ArrayList<>();
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		assertEquals(3, ThreeCardLogic.controller(card1, card2, card3));
	}

	@Test
	@DisplayName("Test equalHands()")
	void testEqualHands(){
		ThreeCardLogic logic = new ThreeCardLogic();
		Card card1 = new Card('S', 1);
		Card card2 = new Card('S', 2);
		Card card3 = new Card('S', 3);
		ArrayList<Card> hand = new ArrayList<>();
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);

		Card card4 = new Card('S', 1);
		Card card5 = new Card('S', 2);
		Card card6 = new Card('S', 3);
		ArrayList<Card> hand2 = new ArrayList<>();
		hand2.add(card4);
		hand2.add(card5);
		hand2.add(card6);
		assertEquals(0, ThreeCardLogic.equalHands(hand, hand2));
	}


	@Test
	@DisplayName("Test highDeckChecker()")
	void testHighDeckChecker2(){
		ThreeCardLogic logic = new ThreeCardLogic();
		Card card1 = new Card('S', 1);
		Card card2 = new Card('S', 2);
		Card card3 = new Card('S', 3);
		ArrayList<Card> hand = new ArrayList<>();
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		assertEquals(3, ThreeCardLogic.highDeckChecker(hand, 10));
	}

	@ParameterizedTest
	@CsvSource({"1, 3, 2, 3", "2, 1, 3, 3", "2, 3, 1, 3", "3, 1, 2, 3", "3, 2, 1, 3"})
	void testIterative(int c1, int c2, int c3, int expected) {
		Card card1 = new Card('S', c1);
		Card card2 = new Card('S', c2);
		Card card3 = new Card('S', c3);
		assertEquals(4, ThreeCardLogic.controller(card1, card2, card3));
	}

	@Test
	@DisplayName("Test highDeckChecker()")
	void testHighDeckChecker3(){
		ThreeCardLogic logic = new ThreeCardLogic();
		Card card1 = new Card('S', 1);
		Card card2 = new Card('S', 2);
		Card card3 = new Card('S', 3);
		ArrayList<Card> hand = new ArrayList<>();
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		assertEquals(3, ThreeCardLogic.highDeckChecker(hand, 10));
	}

	@Test
	@DisplayName("Test setValue()")
	void testSetValue(){
		Card card = new Card('S', 555);
		card.setValue(555);
		assertEquals(555, card.getValue());
	}



}
