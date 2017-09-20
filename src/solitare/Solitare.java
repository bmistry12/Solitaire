package solitare;

import java.awt.Color;
import java.util.Stack;

import cards.Cards;
import cards.Deck;
import cards.Suit;
import cards.Value;

public class Solitare {
	private Stack<Cards> wasteDeck = new Stack<Cards>();
	private Deck startDeck = new Deck();
	private Deck stockDeck;
	private Stack<Cards>[] foundation = (Stack<Cards>[]) new Stack[4];
	public static Stack<Cards> col1 = new Stack<Cards>();
	public static Stack<Cards> col2 = new Stack<Cards>();
	public static Stack<Cards> col3 = new Stack<Cards>();
	public static Stack<Cards> col4 = new Stack<Cards>();
	public static Stack<Cards> col5 = new Stack<Cards>();
	public static Stack<Cards> col6 = new Stack<Cards>();
	public static Stack<Cards> col7 = new Stack<Cards>();
	private SolitareDisplay display;
	
	public Solitare(){
		display = new SolitareDisplay(this);
		deal();
		printCurrentCol();
	}
	
	public Cards getStockCard(){
		if(stockDeck.getDeckSize() == 0){
			resetStock();
			return stockDeck.getTopOfDeck();
		} else {
			return stockDeck.getTopOfDeck();
		}	
	}
	
	public Cards getWasteCard(){
		if(wasteDeck.size() == 0){
			return null;
		} else {
			return wasteDeck.peek();
		}
	}
	
	public Cards getFoundCard(int index){
		if(foundation[index] == null || foundation[index].isEmpty()){
			return null;
		} else {
			return foundation[index].peek();
		}		
	}
	
	public Stack<Cards> getPile(Stack<Cards> pile){
		return pile;
	}
	
	public void resetStock(){
		System.out.println("Resetting stocks");
		while (! (wasteDeck.isEmpty())){
			Cards toMove = wasteDeck.pop();
			toMove.turnDown();
			stockDeck.addCard(toMove);
			stockDeck.increaseDeckSize();
		}
	}
	
	public void dealCard(){
		if(! (stockDeck.getDeckSize() == 0)){
			Cards temp = stockDeck.removeTopOfDeck();
			wasteDeck.push(temp).turnUp();
			System.out.println("Cardbeingdealt " + temp.getValue() + " " + temp.getSuit());
		}
	}
	
	private void deal() {
		startDeck.shuffleDeck();
		col1.push(startDeck.removeTopOfDeck()).turnUp();
		col2.push(startDeck.removeTopOfDeck());
		col2.push(startDeck.removeTopOfDeck()).turnUp();
		col3.push(startDeck.removeTopOfDeck());
		col3.push(startDeck.removeTopOfDeck());
		col3.push(startDeck.removeTopOfDeck()).turnUp();
		col4.push(startDeck.removeTopOfDeck());
		col4.push(startDeck.removeTopOfDeck());
		col4.push(startDeck.removeTopOfDeck());
		col4.push(startDeck.removeTopOfDeck()).turnUp();
		col5.push(startDeck.removeTopOfDeck());
		col5.push(startDeck.removeTopOfDeck());
		col5.push(startDeck.removeTopOfDeck());
		col5.push(startDeck.removeTopOfDeck());
		col5.push(startDeck.removeTopOfDeck()).turnUp();
		col6.push(startDeck.removeTopOfDeck());
		col6.push(startDeck.removeTopOfDeck());
		col6.push(startDeck.removeTopOfDeck());
		col6.push(startDeck.removeTopOfDeck());
		col6.push(startDeck.removeTopOfDeck());
		col6.push(startDeck.removeTopOfDeck()).turnUp();
		col7.push(startDeck.removeTopOfDeck());
		col7.push(startDeck.removeTopOfDeck());
		col7.push(startDeck.removeTopOfDeck());
		col7.push(startDeck.removeTopOfDeck());
		col7.push(startDeck.removeTopOfDeck());
		col7.push(startDeck.removeTopOfDeck());
		col7.push(startDeck.removeTopOfDeck()).turnUp();
		stockDeck = startDeck;
		
		
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
	public void stockDeck() {
		System.out.println("Stock clicked");
		display.unselect();
		if(!display.isWasteSelected() && !display.isPileSelected()){
			if (stockDeck.getDeckSize() == 0){
				System.out.println("Stock deck is empty");
				resetStock();
			} else {
				dealCard();
			}
		}
	}

	public void wasteCardClicked() {
		System.out.println("Waste card clicked");
		if(!wasteDeck.isEmpty()){
			if(!display.isWasteSelected()){
				display.selectWaste();
			} else {
				display.unselect();
			}
		}
	}

	public void foundationClicked(int i) {
		System.err.println("foundation" + i + " clicked");
		if (display.isWasteSelected()) {
			if (addToFoundation(wasteDeck.peek(), i)){
				Cards card = wasteDeck.pop();
				if (foundation[i] == null){
					foundation[i] = new Stack<Cards>();
				}
				foundation[i].push(card);
				display.unselect();
			} else {
				System.err.println("Not a valid move");
			}
		}
		if (display.isPileSelected()){
			System.err.println("foundation clicked display on pile");
			Stack<Cards> pileSelected = intToPile(display.selectedPile());
			if(addToFoundation(pileSelected.peek(), i)){
				Cards cardToMove = pileSelected.pop();
				if (foundation[i] == null){
					foundation[i] = new Stack<Cards>();
				}
				foundation[i].push(cardToMove);
				if(!pileSelected.isEmpty()){
					pileSelected.peek().turnUp();
					display.unselect();
				}
			}
		}
	}

	private boolean addToFoundation(Cards card, int i) {
		boolean isValidMove = false;
		if(foundation[i] == null || foundation[i].isEmpty()){
			if (card.getValue() == Value.ACE){
				isValidMove =  true;
			}
		} else {
			Cards onFound = foundation[i].peek();
			if (onFound.getSuit() == card.getSuit()){
				if(onFound.valueToInt(onFound.getValue()) + 1 == card.valueToInt(card.getValue())){
					isValidMove = true;
				}
			}
		}
		return isValidMove;
	}

	public void pileClicked(Stack<Cards> pile) {
		//System.out.println("pile clicked " + pile.peek().getValue());
		if (display.isWasteSelected()){
			Cards cardToMove = wasteDeck.peek();
			System.out.println("IS ALLOWED " + canAddToPile(cardToMove, pile));
			if(canAddToPile(cardToMove, pile) == true){
				pile.push(wasteDeck.pop());
			} else {
				System.out.println("Cannot add to pile");
			}
			display.unselect();
			display.selectPile(pile);
			///////
		} else if (display.isPileSelected()){
			int oldPile = display.selectedPile();
			int selectedPile = pileToInt(pile);
			if (selectedPile != oldPile){
				Stack<Cards> toMove = removeFaceUpCards(oldPile);
				if (canAddToPile(toMove.peek(), pile)){
					addToPile(toMove, pile);
					if(!intToPile(oldPile).isEmpty()){
						intToPile(oldPile).peek().turnUp();
					}
					display.unselect();
				} else {
					System.err.println("invalid move");
					addToPile(toMove, intToPile(oldPile));
					display.unselect();
					display.selectPile(pile);
				}
			
			} else {
				display.unselect();
			}	
		} else {
			display.selectPile(pile);
			pile.peek().turnUp();
		}
	}

	private Stack<Cards> removeFaceUpCards(int index) {
		Stack<Cards> cards = new Stack<Cards>();
		while(!intToPile(index).isEmpty() && intToPile(index).peek().isFaceUp()){
			cards.push(intToPile(index).pop());
		}
		return cards;
	}

	private void addToPile(Stack<Cards> toMove, Stack<Cards> pile) {
		while(!toMove.isEmpty()){
			pile.push(toMove.pop());
		}
		
	}

	private boolean canAddToPile(Cards card, Stack<Cards> pile) {
		boolean isValidMove = false;
		System.err.println("can add to pile " + card.getValue());
		System.err.println("can add to pile boolean " + card.getValue().equals(Value.KING));
		
		if(pile.isEmpty() && (card.getValue().equals(Value.KING))){
			System.out.println("king and that ");
			isValidMove = true;
		} else{
			Cards topOfPile = pile.peek();
			System.out.println("can add to pile check " + topOfPile.getValue() + " " + topOfPile.getColour());
			System.out.println("can add to pile check card to move " + card.getValue() + " " + card.getColour());
			if(card.getColour() == "RED" && topOfPile.getColour() == "BLACK"){
				if((card.valueToInt(card.getValue())+1) == topOfPile.valueToInt(topOfPile.getValue())){
					isValidMove = true;
				}
			} else if(card.getColour() == "BLACK" && topOfPile.getColour() == "RED"){
				if((card.valueToInt(card.getValue())+1) == topOfPile.valueToInt(topOfPile.getValue())){
					isValidMove = true;
				}
			} else { 
				System.out.println("** INVALID MOVE ** ");
			}
		}
		System.out.println("IS VALID MOVE?? " + isValidMove);
		return isValidMove;
	}
	
	public static int pileToInt(Stack<Cards> pile){
		int value = -1;
		if(pile == col1) {
			value = 0;
		} else if(pile == col2) {
			value = 1;
		} else if(pile == col3) {
			value = 2;
		} else if(pile == col4) {
			value = 3;
		} else if(pile == col5) {
			value = 4;
		} else if(pile == col6) {
			value = 5;
		} else if(pile == col7) {
			value = 6;
		}
		return value; 			
	}
	
	public static Stack<Cards> intToPile (int pileIndex){
		Stack<Cards> temp = null;
		if(pileIndex == 0) {
			System.err.println("pile 1 clicked");
			temp = col1;
		} else if (pileIndex == 1){
			System.err.println("pile 2 clicked");
			temp = col2;
		} else if (pileIndex == 2){
			System.err.println("pile 3 clicked");
			temp = col3;
		} else if (pileIndex == 3){
			System.err.println("pile 4 clicked");
			temp = col4;
		} else if (pileIndex == 4){
			System.err.println("pile 5 clicked");
			temp = col5;
		} else if (pileIndex == 5){
			System.err.println("pile 6 clicked");
			temp = col6;
		} else if (pileIndex == 6){
			System.err.println("pile 7 clicked");
			temp = col7;
		} 		
		return temp;
	}
}
