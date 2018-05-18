package solitaire;

import java.util.Stack;

import base.BaseSolitare;
import card.*;

/**
 * The logic for the solitaire game
 * @author bhavi
 *
 */
public class Solitaire extends BaseSolitare {

	public static Stack<Cards> col1 = new Stack<Cards>();
	public static Stack<Cards> col2 = new Stack<Cards>();
	public static Stack<Cards> col3 = new Stack<Cards>();
	public static Stack<Cards> col4 = new Stack<Cards>();
	public static Stack<Cards> col5 = new Stack<Cards>();
	public static Stack<Cards> col6 = new Stack<Cards>();
	public static Stack<Cards> col7 = new Stack<Cards>();

	private Stack<Cards> wasteDeck = new Stack<Cards>();
	private Deck startDeck;
	private Deck stockDeck;
	private Stack<Cards>[] foundation;
	private SolitaireDisplay display;

	public Solitaire() {
		startDeck = new Deck();
		foundation = (Stack<Cards>[]) new Stack[4];
		display = new SolitaireDisplay(this);
		deal();
		printCurrentCol();
	}
	
	//
	public Stack<Cards> getColumn1(){
		return col1;
	}
	public Stack<Cards> getColumn2(){
		return col2;
	}
	public Stack<Cards> getColumn3(){
		return col3;
	}
	public Stack<Cards> getColumn4(){
		return col4;
	}
	public Stack<Cards> getColumn5(){
		return col5;
	}
	public Stack<Cards> getColumn6(){
		return col6;
	}
	public Stack<Cards> getColumn7(){
		return col7;
	}
	/**
	 * Get waste deck
	 * @return
	 */
	public Stack<Cards> getWasteDeck(){
		return wasteDeck;
	}
	
	/**
	 * Get stock deck
	 */
	public Deck getStockDeck(){
		return stockDeck;
	}
	
	/**
	 * Return top card on stock deck
	 * 
	 * @return
	 */
	public Cards getStockCard() {
		if (stockDeck.getDeckSize() == 0) {
			resetStock();
			return stockDeck.getTopOfDeck();
		} else {
			return stockDeck.getTopOfDeck();
		}
	}

	/**
	 * View top card on waste deck
	 * 
	 * @return
	 */
	public Cards getWasteCard() {
		if (wasteDeck.size() == 0) {
			return null;
		} else {
			return wasteDeck.peek();
		}
	}

	/**
	 * View top card on a particular foundation deck
	 * 
	 * @param index
	 * @return
	 */
	public Cards getFoundCard(int index) {
		if (foundation[index] == null || foundation[index].isEmpty()) {
			return null;
		} else {
			return foundation[index].peek();
		}
	}

	/**
	 * Get a pile
	 * 
	 * @param pile
	 * @return
	 */
	public Stack<Cards> getPile(Stack<Cards> pile) {
		return pile;
	}

	/**
	 * Reset stock deck - waste deck put back onto stock
	 */
	public void resetStock() {
		System.out.println("Resetting stocks");
		while (!(wasteDeck.isEmpty())) {
			Cards toMove = wasteDeck.pop();
			toMove.turnDown();
			stockDeck.addCard(toMove);
			stockDeck.increaseDeckSize();
		}
	}

	/**
	 * Deal next card from the stock deck
	 */
	public void dealCard() {
		if (!(stockDeck.getDeckSize() == 0)) {
			Cards temp = stockDeck.removeTopOfDeck();
			wasteDeck.push(temp);
			wasteDeck.peek().turnUp();
			System.out.println("Card being dealt " + temp.getValue() + " " + temp.getSuit());
		}
	}

	/**
	 * deal primary set up of deck with the last card on the deck turned up col1
	 * - 1 card col2 - 2 cards col3 - 3 cards col4 - 4 cards col5 - 5 cards col6
	 * - 6 cards col7 - 7 cards
	 */
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

	/**
	 * Print each column to terminal
	 */
	public void printCurrentCol() {
		System.out.println("1 ->" + iterateStack(col1));
		System.out.println("2 ->" + iterateStack(col2));
		System.out.println("3 ->" + iterateStack(col3));
		System.out.println("4 ->" + iterateStack(col4));
		System.out.println("5 ->" + iterateStack(col5));
		System.out.println("6 ->" + iterateStack(col6));
		System.out.println("7 ->" + iterateStack(col7));
	}

	/**
	 * Iterate through a stack. If a card if face down display X instead of card
	 * details
	 * 
	 * @param s1
	 * @return
	 */
	public String iterateStack(Stack<Cards> s1) {
		String pile = "[";
		for (Cards obj : s1) {
			if (!obj.isFaceUp) {
				pile += ("X | ");
			} else {
				pile += (obj + " | ");
			}
		}
		pile += "]";
		return (pile);
	}

	/**
	 * Stock deck has been clicked - deal next card onto waste deck or reset
	 * stock
	 */
	public void stockDeck() {
		System.out.println("Stock clicked");
		display.unselect();
		if (!display.isWasteSelected() && !display.isPileSelected()) {
			if (stockDeck.getDeckSize() == 0) {
				System.out.println("Stock deck is empty");
				resetStock();
			} else {
				dealCard();
			}
		}
	}

	/**
	 * Select waste card when clicked - normally to move onto a pile or
	 * foundation
	 */
	public void wasteCardClicked() {
		System.out.println("Waste card clicked");
		if (!wasteDeck.isEmpty()) {
			if (!display.isWasteSelected()) {
				display.selectWaste();
			} else {
				display.unselect();
			}
		}
	}

	/**
	 * Foundation pile clicked - add new card to it if it is valid
	 * 
	 * @param i
	 */
	public void foundationClicked(int i) {
		System.err.println("foundation" + i + " clicked");
		if (display.isWasteSelected()) {
			if (addToFoundation(wasteDeck.peek(), i)) {
				Cards card = wasteDeck.pop();
				if (foundation[i] == null) {
					foundation[i] = new Stack<Cards>();
				}
				foundation[i].push(card);
				display.unselect();
			} else {
				System.err.println("Not a valid move");
			}
		}

		if (display.isPileSelected()) {
			System.err.println("foundation clicked display on pile");
			Stack<Cards> pileSelected = intToPile(display.selectedPile());
			if (addToFoundation(pileSelected.peek(), i)) {
				Cards cardToMove = pileSelected.pop();
				if (foundation[i] == null) {
					foundation[i] = new Stack<Cards>();
				}
				foundation[i].push(cardToMove);
				if (!pileSelected.isEmpty()) {
					pileSelected.peek().turnUp();
					display.unselect();
				}
			}
		}
	}

	/**
	 * Checks if adding to foundation pile is a valid move
	 * 
	 * @param card
	 * @param i
	 * @return
	 */
	private boolean addToFoundation(Cards card, int i) {
		boolean isValidMove = false;
		if (foundation[i] == null || foundation[i].isEmpty()) {
			if (card.getValue() == Value.ACE) {
				isValidMove = true;
			}
		} else {
			Cards onFound = foundation[i].peek();
			if (onFound.getSuit() == card.getSuit()) {
				if (onFound.valueToInt(onFound.getValue()) + 1 == card.valueToInt(card.getValue())) {
					isValidMove = true;
				}
			}
		}
		return isValidMove;
	}

	/**
	 * A pile has been clicked - add to pile if valid
	 * 
	 * @param pile
	 */
	public void pileClicked(Stack<Cards> pile) {
		if (display.isWasteSelected()) {
			Cards cardToMove = wasteDeck.peek();
			if (canAddToPile(cardToMove, pile) == true) {
				pile.push(wasteDeck.pop());
			} else {
				System.out.println("Cannot add to pile");
			}
			display.unselect();
			display.selectPile(pile);
		} else if (display.isPileSelected()) {
			int oldPile = display.selectedPile();
			System.out.println("old pile" + oldPile);
			int selectedPile = pileToInt(pile);
			System.out.println("new pile" + selectedPile);
			if (selectedPile != oldPile) {
				Stack<Cards> toMove = removeFaceUpCards(oldPile);
				if (canAddToPile(toMove.peek(), pile)) {
					addToPile(toMove, pile);
					if (!intToPile(oldPile).isEmpty()) {
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

	/**
	 * Remove all face up cards
	 * 
	 * @param index
	 * @return
	 */
	private Stack<Cards> removeFaceUpCards(int index) {
		Stack<Cards> cards = new Stack<Cards>();
		while (!intToPile(index).isEmpty() && intToPile(index).peek().isFaceUp()) {
			cards.push(intToPile(index).pop());
		}
		return cards;
	}

	/**
	 * Push top of one pile onto another pile
	 * 
	 * @param toMove
	 * @param pile
	 */
	private void addToPile(Stack<Cards> toMove, Stack<Cards> pile) {
		while (!toMove.isEmpty()) {
			pile.push(toMove.pop());
		}

	}

	/**
	 * Check if moving on to a pile is a valid move or not
	 * 
	 * @param card
	 * @param pile
	 * @return
	 */
	private boolean canAddToPile(Cards card, Stack<Cards> pile) {
		boolean isValidMove = false;
		System.err.println("can add to pile " + card.getValue());
		System.err.println("can add to pile boolean " + card.getValue().equals(Value.KING));

		if (pile.isEmpty() && (card.getValue().equals(Value.KING))) {
			isValidMove = true;
		} else {
			Cards topOfPile = pile.peek();
			if (card.getColour() == "RED" && topOfPile.getColour() == "BLACK") {
				if ((card.valueToInt(card.getValue()) + 1) == topOfPile.valueToInt(topOfPile.getValue())) {
					isValidMove = true;
				}
			} else if (card.getColour() == "BLACK" && topOfPile.getColour() == "RED") {
				if ((card.valueToInt(card.getValue()) + 1) == topOfPile.valueToInt(topOfPile.getValue())) {
					isValidMove = true;
				}
			} else {
				System.out.println("** INVALID MOVE ** ");
			}
		}
		return isValidMove;
	}

	/**
	 * Convert pile to an integer to use for adding etc.
	 * 
	 * @param pile
	 * @return
	 */
	public static int pileToInt(Stack<Cards> pile) {
		int value = -1;
		if (pile == col1) {
			value = 0;
		} else if (pile == col2) {
			value = 1;
		} else if (pile == col3) {
			value = 2;
		} else if (pile == col4) {
			value = 3;
		} else if (pile == col5) {
			value = 4;
		} else if (pile == col6) {
			value = 5;
		} else if (pile == col7) {
			value = 6;
		}
		return value;
	}

	/**
	 * Convert int to column so - returns the column
	 * 
	 * @param pileIndex
	 * @return
	 */
	public static Stack<Cards> intToPile(int pileIndex) {
		Stack<Cards> temp = null;
		if (pileIndex == 0) {
			System.err.println("pile 0 clicked");
			temp = col1;
		} else if (pileIndex == 1) {
			System.err.println("pile 1 clicked");
			temp = col2;
		} else if (pileIndex == 2) {
			System.err.println("pile 2 clicked");
			temp = col3;
		} else if (pileIndex == 3) {
			System.err.println("pile 3 clicked");
			temp = col4;
		} else if (pileIndex == 4) {
			System.err.println("pile 4 clicked");
			temp = col5;
		} else if (pileIndex == 5) {
			System.err.println("pile 5 clicked");
			temp = col6;
		} else if (pileIndex == 6) {
			System.err.println("pile 6 clicked");
			temp = col7;
		}
		return temp;
	}
}
