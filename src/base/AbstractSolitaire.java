package base;

import java.util.Stack;

import card.Cards;

/**
 * Base class for solitaire logic classes
 * @author bhavi
 *
 */
public abstract class AbstractSolitaire implements Runnable {

	public abstract Cards getStockCard();

	public abstract Cards getWasteCard();

	public abstract Cards getFoundCard(int i);

	public abstract Stack<Cards> getPile(Stack<Cards> col1);

	public abstract Stack<Stack<Cards>> getAllPiles();
}