package solitareNew;

import java.awt.Component;
import java.util.Stack;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import cards.Cards;
import cards.Deck;

public class SolitareRules {
	private solitareDisplay display;
	public SolitareRules(){
		display = new solitareDisplay(this);
		run();
	}
	
	public Deck startDeck = new Deck();
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
	}
	
	private void printCurrentCol(){
		System.out.println(col1);
		System.out.println(col2);
		System.out.println(col3);
		System.out.println(col4);
		System.out.println(col5);
		System.out.println(col6);
		System.out.println(col7);
	}
	
	public Icon setCard() {
		Cards currentCard = startDeck.removeTopOfDeck();
		String cardPath = getCardPath.getPath(currentCard);
		ImageIcon icon = new ImageIcon(cardPath);
		System.out.println(icon.getIconWidth());
		System.out.println(icon.getIconHeight());
		return icon;
	}
	
	
	public void run() {
		startDecks();
		printCurrentCol();
	}
	
	public static String toString(Stack<Cards> a){
		String astring = "";
		astring = a.pop() + astring;
		return astring;
		
	}
	public static void main(String[] args)
	{
        new SolitareRules();
	}
}
