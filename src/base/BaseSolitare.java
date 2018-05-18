package base;

import java.util.Stack;
import card.*;
import solitaire.SolitaireDisplay;

/**
 * Base class for solitaire logic classes
 * @author bhavi
 *
 */
public abstract class BaseSolitare {

	public abstract Cards getStockCard();

	public abstract Cards getWasteCard();

	public abstract Cards getFoundCard(int i);

	public abstract Stack<Cards> getPile(Stack<Cards> col1);

}