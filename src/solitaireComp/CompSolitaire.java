package solitaireComp;

import java.util.Stack;

import base.AbstractSolitaire;
import card.Cards;
import card.Deck;
import card.Value;
import main.Home;
import solitaire.Solitaire;

/**
 * AI Solitaire Logic TO DO - implement it
 * 
 * @author bhavi
 *
 */
public class CompSolitaire extends AbstractSolitaire {

	public static Stack<Cards> col1;
	public static Stack<Cards> col2;
	public static Stack<Cards> col3;
	public static Stack<Cards> col4;
	public static Stack<Cards> col5;
	public static Stack<Cards> col6;
	public static Stack<Cards> col7;

	private boolean running = true;
	private Stack<Cards> wasteDeck = new Stack<Cards>();
	private Deck stockDeck;
	private Stack<Cards>[] foundation;
	private CompDisplay display;
	private Solver solver;

	public CompSolitaire(Stack<Stack<Cards>> allPiles, Deck stockDeck) {
		this.stockDeck = stockDeck;
		foundation = (Stack<Cards>[]) new Stack[4];
		col7 = allPiles.pop();
		col6 = allPiles.pop();
		col5 = allPiles.pop();
		col4 = allPiles.pop();
		col3 = allPiles.pop();
		col2 = allPiles.pop();
		col1 = allPiles.pop();
		initFound();
	}

	/**
	 * Initialise each foundation pile
	 */
	private void initFound() {
		for (int i = 0; i < this.foundation.length; i++) {
			foundation[i] = new Stack<Cards>();
		}
	}

	/**
	 * Get waste deck
	 * 
	 * @return
	 */
	public Stack<Cards> getWasteDeck() {
		return wasteDeck;
	}

	/**
	 * Get stock deck
	 */
	public Deck getStockDeck() {
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
	 * Updates the solver and display
	 */
	public void update() {
		while (running) {
			try {
				Thread.sleep(2000);
				solver.update();
				display.update();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Return true if the thread is still running
	 * 
	 * @return
	 */
	public boolean isRunning() {
		System.out.println(running);
		return this.running;
	}

	/**
	 * Stops the solver and calls the method in Home to end the thread
	 */
	public void stop() {
		running = false;
		Home.endCompThread();
	}

	/**
	 * Return the display
	 * 
	 * @return
	 */
	private CompDisplay getDisplay() {
		return display;
	}

	/**
	 * Return all the foundation piles
	 * 
	 * @return
	 */
	private Stack<Cards>[] getAllFoundation() {
		return this.foundation;
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

	@Override
	public Stack<Stack<Cards>> getAllPiles() {
		Stack<Stack<Cards>> all = new Stack<Stack<Cards>>();
		all.push(col1);
		all.push(col2);
		all.push(col3);
		all.push(col4);
		all.push(col5);
		all.push(col6);
		all.push(col7);
		return all;
	}

	@Override
	public void run() {
		display = new CompDisplay(this.getAllPiles(), this);
		solver = new Solver(this.getWasteDeck(), this.getStockDeck(), this.getAllFoundation(), this.getAllPiles(),
				this.getDisplay());
		update();
	}
}
