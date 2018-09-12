package solitaireComp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import base.AbstractDisplay;
import card.Cards;
import solitaire.EndDialog;
import solitaire.Solitaire;

public class CompDisplay extends AbstractDisplay {

	private CompSolitaire aiSolitaire;
	private Stack<Stack<Cards>> allPiles;
	
	/**
	 * Create a new ai solitaire window
	 * 
	 * @param aisolitare
	 * @param solver 
	 */
	public CompDisplay(Stack<Stack<Cards>> allPiles, CompSolitaire aisolitare) {
		super(aisolitare);
		this.getFrame().setTitle("Computer Play Solitaire");
		this.setColour(Color.LIGHT_GRAY);
		this.allPiles = allPiles;
		this.aiSolitaire = aisolitare;
	}

	public void update(){
		System.out.println("repaint");
		this.repaint();
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

	@Override
	public void endGame(int complete) {
		// TODO Auto-generated method stub
		System.err.println("EndGame");
		JOptionPane.showMessageDialog(this, "Quit the game", null, JOptionPane.PLAIN_MESSAGE);
		aiSolitaire.stop();
	}

}
