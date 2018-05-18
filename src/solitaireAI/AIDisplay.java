package solitaireAI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;

import base.AbstractDisplay;
import card.Cards;
import solitaire.Solitaire;

public class AIDisplay extends AbstractDisplay {

	private AISolitaire aiSolitare;

	/**
	 * Create a new ai solitaire window
	 * 
	 * @param aisolitare
	 */
	public AIDisplay(AISolitaire aisolitare) {
		super(aisolitare);
		this.getFrame().setTitle("AI Solitaire");
		this.setColour(Color.LIGHT_GRAY);
		this.aiSolitare = aisolitare;
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

}
