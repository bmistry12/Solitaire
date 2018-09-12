package solitaireComp;

import java.util.Stack;

import card.Cards;
import card.Deck;
import card.Suit;
import card.Value;

/**
 * Automatically moves cards where possible
 * <p>
 * 
 * TODO Only moves one card (e.g not a pile like //k q j) </br>
 * Also does multiple moves at once which needs to be fixed
 * 
 * @author bhavi
 *
 */
public class Solver {

	private Stack<Cards> wasteDeck;
	private Deck stockDeck;
	private Stack<Cards>[] foundation;
	private Stack<Stack<Cards>> piles;
	private CompDisplay aiDisplay;

	/**
	 * Creates a new Solver, which is a class that will automatically move cards
	 * around
	 * 
	 * @param wasteDeck
	 * @param stockDeck
	 * @param foundation
	 * @param piles
	 * @param aiDisplay
	 */
	public Solver(Stack<Cards> wasteDeck, Deck stockDeck, Stack<Cards>[] foundation, Stack<Stack<Cards>> piles,
			CompDisplay aiDisplay) {
		this.wasteDeck = wasteDeck;
		this.stockDeck = stockDeck;
		this.foundation = foundation;
		this.piles = piles;
		this.aiDisplay = aiDisplay;
	}

	/**
	 * Run the methods of the Solver
	 */
	public void update() {
		System.out.println("update");
		aceCheck();
		kingMove();
		checkPiles();
		wasteMove();
	}

	/**
	 * Deal a card to the waste deck from the stock deck. If it can be moved to
	 * a pile or a foundation pile then move it.
	 */
	private void wasteMove() {
		boolean moved = false;
		if (stockDeck.getDeckSize() == 0) {
			System.out.println("Stock deck is empty");
			resetStock();
		} else {
			Cards temp = this.stockDeck.removeTopOfDeck();
			this.wasteDeck.push(temp);
			this.wasteDeck.peek().turnUp();
			for (Stack<Cards> pile : piles) {
				if (canAddToPile(temp, pile)) {
					System.out.println("add from waste to a pile");
					moveCard(this.wasteDeck, pile);
					moved = true;
					break;
				}
			}
			if (!moved) {
				for (Stack<Cards> found : foundation) {
					if (canAddToFound(temp, found)) {
						System.out.println("add from waste to a foundation");
						moveCard(this.wasteDeck, found);
						moved = true;
						break;
					}
				}
			}
		}
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
	 * Check to see if a card can be moved from a pile to another pile or the
	 * foundation decks
	 */
	private void checkPiles() {
		boolean moved = false;
		int currentPile;
		for (Stack<Cards> pile : piles) {
			if (!pile.isEmpty()) {
				currentPile = CompSolitaire.pileToInt(pile);
				Cards check = pile.peek();
				// check adding to other piles
				if (check.getValue() != Value.KING) {
					for (int i = 0; i < piles.size(); i++) {
						if (i != currentPile) {
							if (canAddToPile(check, piles.get(i))) {
								moveCard(pile, piles.get(i));
								moved = true;
								break;
							}
						}
					}
				}
				if (!moved) {
					for (Stack<Cards> found : foundation) {
						if (canAddToFound(check, found)) {
							moveCard(pile, found);
						}
					}
				}
			}
		}

	}

	/**
	 * Move a card between two piles
	 * 
	 * @param from
	 * @param to
	 */
	public void moveCard(Stack<Cards> from, Stack<Cards> to) {
		to.push(from.pop());
		if (!from.isEmpty()) {
			from.peek().turnUp();
		}
	}

	/**
	 * Checks if adding to foundation pile is a valid move
	 * 
	 * @param card
	 * @param found
	 * @return
	 */
	private boolean canAddToFound(Cards card, Stack<Cards> found) {
		if (found.isEmpty()) {
			if (card.getValue() == Value.ACE) {
				return true;
			}
		} else {
			Cards onFound = found.peek();
			if (onFound.getSuit() == card.getSuit()) {
				if (onFound.valueToInt(onFound.getValue()) + 1 == card.valueToInt(card.getValue())) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Check if moving on to a pile is a valid move or not
	 * 
	 * @param card
	 * @param pile
	 * 
	 * @return
	 */
	private boolean canAddToPile(Cards card, Stack<Cards> pile) {
		System.err.println("can add to pile " + card.getValue());
		System.err.println("can add to pile boolean " + card.getValue().equals(Value.KING));
		if (pile.isEmpty()) {
			if ((card.getValue().equals(Value.KING))) {
				return true;
			} else {
				return false;
			}
		} else {
			Cards topOfPile = pile.peek();
			if (card.getColour() == "RED" && topOfPile.getColour() == "BLACK") {
				if ((card.valueToInt(card.getValue()) + 1) == topOfPile.valueToInt(topOfPile.getValue())) {
					return true;
				}
			} else if (card.getColour() == "BLACK" && topOfPile.getColour() == "RED") {
				if ((card.valueToInt(card.getValue()) + 1) == topOfPile.valueToInt(topOfPile.getValue())) {
					return true;
				}
			} else {
				System.out.println("** INVALID MOVE ** ");
			}
		}
		return false;
	}

	/**
	 * See if a king is available to move into an empty space
	 */
	private void kingMove() {
		System.out.println("king move");
		Stack<Cards> emptyPile = null;
		for (Stack<Cards> pile : piles) {
			if (pile.isEmpty()) {
				emptyPile = pile;
			}
			break;
		}
		if (emptyPile != null) {
			for (Stack<Cards> pile : piles) {
				if (!pile.equals(emptyPile)) {
					Cards card = pile.peek();
					if (card.getValue().equals(Value.KING)) {
						emptyPile.push(card);
						pile.peek().turnUp();
					}
				}
				break;
			}
		}
	}

	/**
	 * Checks if an ace is available to move to foundation
	 */
	private void aceCheck() {
		System.out.println("ace check");
		for (Stack<Cards> pile : piles) {
			System.out.println("hello");
			System.out.println(CompSolitaire.pileToInt(pile));
			if (!pile.isEmpty()) {
				if (pile.peek().getValue() == Value.ACE) {
					System.out.println("we got an ace ");
					addAceToFound(pile);
				}
			}
		}
	}

	/**
	 * Add an ace to an empty foundation pile
	 * 
	 * @param pile
	 */
	private void addAceToFound(Stack<Cards> pile) {
		System.out.println("add to foundation");
		int foundCount = 0;
		for (Stack<Cards> found : foundation) {
			if (found.size() == 0) {
				found.push(pile.pop());
				pile.peek().turnUp();
				break;
			}
			foundCount++;
		}
		System.out.println(foundCount);
	}

	/**
	 * Set waste deck
	 * 
	 * @param wasteDeck
	 */
	public void setWasteDeck(Stack<Cards> wasteDeck) {
		this.wasteDeck = wasteDeck;
	}

	/**
	 * Set stock deck
	 * 
	 * @param stockDeck
	 */
	public void setStockDeck(Deck stockDeck) {
		this.stockDeck = stockDeck;
	}

	/**
	 * Set foundation piles
	 * 
	 * @param foundation
	 */
	public void setFoundation(Stack<Cards>[] foundation) {
		this.foundation = foundation;
	}

	/**
	 * Set all piles
	 * 
	 * @param piles
	 */
	public void setPiles(Stack<Stack<Cards>> piles) {
		this.piles = piles;
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
}
