package solitare;

import java.util.Stack;
import cards.*;

public class SolitareRules {
	
	public SolitareRules(){
		setUp();
	}
	
	public Deck wasteDeck = new Deck();
	private Deck startDeck = new Deck();
	//seven piles
	Stack<Cards> col1 = new Stack<Cards>();
	Stack<Cards> col2 = new Stack<Cards>();
	Stack<Cards> col3 = new Stack<Cards>();
	Stack<Cards> col4 = new Stack<Cards>();
	Stack<Cards> col5 = new Stack<Cards>();
	Stack<Cards> col6 = new Stack<Cards>();
	Stack<Cards> col7 = new Stack<Cards>();
	
	private void startDecks(){
		//set up -> shuffle deck and deal out into 7 piles
		startDeck.shuffleDeck();
		col1.push(startDeck.removeTopOfDeck());
		col1.peek().turnUp();
		col2.push(startDeck.removeTopOfDeck());
		col2.push(startDeck.removeTopOfDeck());
		col2.peek().turnUp();
		col3.push(startDeck.removeTopOfDeck());
		col3.push(startDeck.removeTopOfDeck());
		col3.push(startDeck.removeTopOfDeck());
		col3.peek().turnUp();
		col4.push(startDeck.removeTopOfDeck());
		col4.push(startDeck.removeTopOfDeck());
		col4.push(startDeck.removeTopOfDeck());
		col4.push(startDeck.removeTopOfDeck());
		col4.peek().turnUp();
		col5.push(startDeck.removeTopOfDeck());
		col5.push(startDeck.removeTopOfDeck());
		col5.push(startDeck.removeTopOfDeck());
		col5.push(startDeck.removeTopOfDeck());
		col5.push(startDeck.removeTopOfDeck());
		col5.peek().turnUp();
		col6.push(startDeck.removeTopOfDeck());
		col6.push(startDeck.removeTopOfDeck());
		col6.push(startDeck.removeTopOfDeck());
		col6.push(startDeck.removeTopOfDeck());
		col6.push(startDeck.removeTopOfDeck());
		col6.push(startDeck.removeTopOfDeck());
		col6.peek().turnUp();
		col7.push(startDeck.removeTopOfDeck());
		col7.push(startDeck.removeTopOfDeck());
		col7.push(startDeck.removeTopOfDeck());
		col7.push(startDeck.removeTopOfDeck());
		col7.push(startDeck.removeTopOfDeck());
		col7.push(startDeck.removeTopOfDeck());
		col7.push(startDeck.removeTopOfDeck());
		col7.peek().turnUp();
		//let the rest of the start deck now be in a deck called wasteDeck - used to deal cards
		wasteDeck = startDeck;
	}
	
	private void printWasteDeck(){
		System.out.println(wasteDeck);
		wasteDeck.printDeck();
	}
	
	public void printCurrentCol(){
		//prints each pile
		System.out.println("1 ->" + iterateStack(col1));
		System.out.println("2 ->" + iterateStack(col2));
		System.out.println("3 ->" + iterateStack(col3));
		System.out.println("4 ->" + iterateStack(col4));
		System.out.println("5 ->" + iterateStack(col5));
		System.out.println("6 ->" + iterateStack(col6));
		System.out.println("7 ->" + iterateStack(col7));
	}
	
	public void dealCard() {
		//gets next card from waste pile
		Cards currentCard = wasteDeck.removeTopOfDeck();
		System.out.println("DealtCard " + currentCard);
	}
	
	
	public String iterateStack(Stack<Cards> s1){
		//iterate through a stack. If a card if face down display X instead of card details
		String pile = "[";
		for (Cards obj : s1){
			if (!obj.isFaceUp){
				pile += ("X | ");
			} else {
				pile += (obj + " | ");
			}
		}
		pile += "]";
		return(pile);
	}
	
	public void addCardToStack(Cards card, Stack<Cards> s1){
		//add a card to the top of a stack if it is a valid move
		Cards topOfStack = s1.peek();
		if (card.getValue().ordinal() == topOfStack.getValue().ordinal() - 1 ){
			if ((card.getColour() == "RED" && topOfStack.getColour() == "BLACK") || (card.getColour() == "BLACK" && topOfStack.getColour() == "RED")){
				s1.push(card);
			} else {
				System.out.println("Move not allowed");
			}
		}
	}
	
	public void testing(){ 
		//testing
		//System.out.println("--------------- START DECKS ----------------");
		startDecks();
		System.out.println("--------------- DEALT CARDS ----------------");
		printCurrentCol();
		//System.out.println("--------------- WASTE DECK ----------------");
		//printWasteDeck();
		System.out.println("--------------- DEALT CARD ----------------");
		dealCard();		
	}
	
	public void setUp() {
		//currently only testing -> will be implemented with run code
		//testing();
		startDecks();
		printCurrentCol();
		
	}
	
	public static String toString(Stack<Cards> a){
		String astring = "";
		astring = a.pop() + astring;
		return astring;
		
	}
}
