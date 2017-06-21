package solitare;

import java.util.Stack;
import cards.Cards;
import cards.Deck;
import cards.Suit;

public class SolitareRules {
	
	public SolitareRules(){
		run();
	}
	
	public Deck wasteDeck = new Deck();
	private Deck startDeck = new Deck();
	Stack<Cards> col1 = new Stack<Cards>();
	Stack<Cards> col2 = new Stack<Cards>();
	Stack<Cards> col3 = new Stack<Cards>();
	Stack<Cards> col4 = new Stack<Cards>();
	Stack<Cards> col5 = new Stack<Cards>();
	Stack<Cards> col6 = new Stack<Cards>();
	Stack<Cards> col7 = new Stack<Cards>();
	
	private void startDecks(){
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
		wasteDeck = startDeck;
	}
	
	private void printWasteDeck(){
		System.out.println(wasteDeck);
		wasteDeck.printDeck();
	}
	
	/*private void printCurrentCol(){
		System.out.println("1 - " + col1);
		System.out.println("2 - " + col2);
		System.out.println("3 - " + col3);
		System.out.println("4 - " + col4);
		System.out.println("5 - " + col5);
		System.out.println("6 - " + col6);
		System.out.println("7 - " + col7);
	}*/
	
	private void printCurrentCol(){
		iterateStack(col1);
		iterateStack(col2);
		iterateStack(col3);
		iterateStack(col4);
		iterateStack(col5);
		iterateStack(col6);
		iterateStack(col7);
		
	}
	
	public void dealCard() {
		Cards currentCard = wasteDeck.removeTopOfDeck();
		System.out.println("DealtCard " + currentCard);
	}
	
	
	public void run() {
		//System.out.println("--------------- START DECKS ----------------");
		startDecks();
		System.out.println("--------------- DEALT CARDS ----------------");
		printCurrentCol();
		//System.out.println("--------------- WASTE DECK ----------------");
		//printWasteDeck();
		System.out.println("--------------- DEALT CARD ----------------");
		dealCard();
	}
	
	public void iterateStack(Stack<Cards> s1){
		String a = "[";
		for (Cards obj : s1){
			if (!obj.isFaceUp){
				a += ("X | ");
			} else {
				a+= (obj + " | ");
			}
		}
		a += "]";
		System.out.println(a);
	}
	
	public static String toString(Stack<Cards> a){
		String astring = "";
		astring = a.pop() + astring;
		return astring;
		
	}
	
	public void addCardToStack(Cards card, Stack<Cards> s1){
		Cards topOfStack = s1.peek();
		if (card.getValue().ordinal() == topOfStack.getValue().ordinal() - 1 ){
			if ((card.getColour() == "RED" && topOfStack.getColour() == "BLACK") || (card.getColour() == "BLACK" && topOfStack.getColour() == "RED")){
				s1.push(card);
			} else {
				System.out.println("Move not allowed");
			}
		}
	}
	
	public static void main(String[] args)
	{
        new SolitareRules();
	}
	
}
