package solitaire;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Stack;

import base.AbstractDisplay;
import card.Cards;

/**
 * Create UI for the game Stock Deck - Left over after cards are dealt Waste
 * Deck - Cards taken off stock deck Foundation Piles - Ace upwards for each
 * suit
 * 
 * @author bhavi
 *
 */
public class SolitaireDisplay extends AbstractDisplay implements MouseListener {

	private Solitaire solitare;

	/**
	 * Create a new solitaire window
	 * 
	 * @param solitaire
	 */
	public SolitaireDisplay(Solitaire solitare) {
		super(solitare);
		this.solitare = solitare;
		this.addMouseListener(this);
	}

	/**
	 * when mouse is clicked carry out relevant method depedning on what has
	 * been clicked and then redraw the gui
	 */
	@Override
	public void mouseClicked(MouseEvent click) {
		int col = click.getX() / (spacing + CARD_WIDTH);
		int row = click.getY() / (spacing + CARD_HEIGHT);
		if (row == 0 && col == 0) {
			solitare.stockDeck();
		} else if (row == 0 && col == 1) {
			solitare.wasteCardClicked();
		} else if (row == 0 && col >= 3) {
			solitare.foundationClicked(col - 3);
		} else if (row == 1) {
			Stack<Cards> temp = Solitaire.intToPile(col);
			solitare.pileClicked(temp);
		}
		repaint();
	}

	/**
	 * Unselect a card
	 */
	public void unselect() {
		selectedRow = -1;
		selectedCol = -1;
	}

	/**
	 * Returns if the waste deck has been selected or not
	 * 
	 * @return
	 */
	public boolean isWasteSelected() {
		return selectedRow == 0 && selectedCol == 1;
	}

	/**
	 * Select the waste deck
	 */
	public void selectWaste() {
		selectedRow = 0;
		selectedCol = 1;
	}

	/**
	 * Returns true if a pile is selected
	 * 
	 * @return
	 */
	public boolean isPileSelected() {
		return selectedRow == 1;
	}

	/**
	 * Returns the selected column (int)
	 * 
	 * @return
	 */
	public int selectedPile() {
		if (selectedRow == 1) {
			return selectedCol;
		} else {
			return -1;
		}
	}

	/**
	 * Select the pile
	 * 
	 * @param pile
	 */
	public void selectPile(Stack<Cards> pile) {
		selectedRow = 1;
		selectedCol = Solitaire.pileToInt(pile);
	}

	// unused methods
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

}
