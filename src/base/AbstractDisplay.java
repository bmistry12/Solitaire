package base;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;

import card.Cards;
import solitaire.Solitaire;
import solitaireAI.AISolitaire;

/**
 * Abstract Display extended by all solitaire display classes
 * @author bhavi
 *
 */
public class AbstractDisplay extends JComponent {
	protected static final int CARD_WIDTH = 73;
	protected static final int CARD_HEIGHT = 97;
	protected static int spacing = 5;
	protected static int upOffset = 15;
	protected static int downOffset = 5;

	private JFrame frame;
	protected int selectedRow = -1;
	protected int selectedCol = 1;
	private BaseSolitare solitare;

	/**
	 * Create a new solitaire window
	 * 
	 * @param solitare2
	 */
	public AbstractDisplay(BaseSolitare solitare) {
		this.solitare = solitare;
		frame = new JFrame();
		frame.setTitle("Solitaire");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(this);
		this.setPreferredSize(new Dimension(CARD_WIDTH * 7 + spacing * 8,
				CARD_HEIGHT * 2 + spacing * 3 + downOffset * 7 + 13 * upOffset));
		frame.pack();
		frame.setVisible(true);
	}
	Color setColour = Color.GREEN;
	
	protected void setColour(Color colour){
		setColour = colour;
	}
	protected Color getColour(){
		return setColour;
	}
	/**
	 * draw display
	 */
	public void paintComponent(Graphics g) {
		// background
		g.setColor(getColour());
		g.fillRect(0, 0, getWidth(), getHeight());
		// face down
		drawCard(g, solitare.getStockCard(), spacing, spacing);
		// stock
		drawCard(g, solitare.getWasteCard(), spacing * 2 + CARD_WIDTH, spacing);
		if (selectedRow == 0 && selectedCol == 1) {
			drawBorder(g, spacing * 2 + CARD_WIDTH, spacing);
		}
		// aces
		for (int i = 0; i < 4; i++) {
			drawCard(g, solitare.getFoundCard(i), spacing * (4 + i) + CARD_WIDTH * (3 + i), spacing);
		}
		// piles
		int offset = 0;
		Stack<Cards> pile = solitare.getPile(Solitaire.col1);
		for (int i = 0; i < pile.size(); i++) {
			drawCard(g, pile.get(i), spacing + (CARD_WIDTH + spacing) * Solitaire.pileToInt(pile),
					CARD_HEIGHT + 2 * spacing + offset);
			if (selectedRow == 1 && selectedCol == Solitaire.pileToInt(pile) && i == pile.size() - 1) {
				drawBorder(g, spacing + (CARD_WIDTH + spacing) * Solitaire.pileToInt(pile),
						CARD_HEIGHT + 2 * spacing + offset);
			}

			if (pile.get(i).isFaceUp()) {
				offset += upOffset;
			} else {
				offset += downOffset;
			}
		}
		offset = 0;
		pile = solitare.getPile(Solitaire.col2);
		for (int i = 0; i < pile.size(); i++) {
			drawCard(g, pile.get(i), spacing + (CARD_WIDTH + spacing) * Solitaire.pileToInt(pile),
					CARD_HEIGHT + 2 * spacing + offset);
			if (selectedRow == 1 && selectedCol == Solitaire.pileToInt(pile) && i == pile.size() - 1) {
				drawBorder(g, spacing + (CARD_WIDTH + spacing) * Solitaire.pileToInt(pile),
						CARD_HEIGHT + 2 * spacing + offset);
			}

			if (pile.get(i).isFaceUp()) {
				offset += upOffset;
			} else {
				offset += downOffset;
			}
		}
		offset = 0;
		pile = solitare.getPile(Solitaire.col3);
		for (int i = 0; i < pile.size(); i++) {
			drawCard(g, pile.get(i), spacing + (CARD_WIDTH + spacing) * Solitaire.pileToInt(pile),
					CARD_HEIGHT + 2 * spacing + offset);
			if (selectedRow == 1 && selectedCol == Solitaire.pileToInt(pile) && i == pile.size() - 1) {
				drawBorder(g, spacing + (CARD_WIDTH + spacing) * Solitaire.pileToInt(pile),
						CARD_HEIGHT + 2 * spacing + offset);
			}

			if (pile.get(i).isFaceUp()) {
				offset += upOffset;
			} else {
				offset += downOffset;
			}
		}
		offset = 0;
		pile = solitare.getPile(Solitaire.col4);
		for (int i = 0; i < pile.size(); i++) {
			drawCard(g, pile.get(i), spacing + (CARD_WIDTH + spacing) * Solitaire.pileToInt(pile),
					CARD_HEIGHT + 2 * spacing + offset);
			if (selectedRow == 1 && selectedCol == Solitaire.pileToInt(pile) && i == pile.size() - 1) {
				drawBorder(g, spacing + (CARD_WIDTH + spacing) * Solitaire.pileToInt(pile),
						CARD_HEIGHT + 2 * spacing + offset);
			}

			if (pile.get(i).isFaceUp()) {
				offset += upOffset;
			} else {
				offset += downOffset;
			}
		}
		offset = 0;
		pile = solitare.getPile(Solitaire.col5);
		for (int i = 0; i < pile.size(); i++) {
			drawCard(g, pile.get(i), spacing + (CARD_WIDTH + spacing) * Solitaire.pileToInt(pile),
					CARD_HEIGHT + 2 * spacing + offset);
			if (selectedRow == 1 && selectedCol == Solitaire.pileToInt(pile) && i == pile.size() - 1) {
				drawBorder(g, spacing + (CARD_WIDTH + spacing) * Solitaire.pileToInt(pile),
						CARD_HEIGHT + 2 * spacing + offset);
			}

			if (pile.get(i).isFaceUp()) {
				offset += upOffset;
			} else {
				offset += downOffset;
			}
		}
		offset = 0;
		pile = solitare.getPile(Solitaire.col6);
		for (int i = 0; i < pile.size(); i++) {
			drawCard(g, pile.get(i), spacing + (CARD_WIDTH + spacing) * Solitaire.pileToInt(pile),
					CARD_HEIGHT + 2 * spacing + offset);
			if (selectedRow == 1 && selectedCol == Solitaire.pileToInt(pile) && i == pile.size() - 1) {
				drawBorder(g, spacing + (CARD_WIDTH + spacing) * Solitaire.pileToInt(pile),
						CARD_HEIGHT + 2 * spacing + offset);
			}

			if (pile.get(i).isFaceUp()) {
				offset += upOffset;
			} else {
				offset += downOffset;
			}
		}
		offset = 0;
		pile = solitare.getPile(Solitaire.col7);
		for (int i = 0; i < pile.size(); i++) {
			drawCard(g, pile.get(i), spacing + (CARD_WIDTH + spacing) * Solitaire.pileToInt(pile),
					CARD_HEIGHT + 2 * spacing + offset);
			if (selectedRow == 1 && selectedCol == Solitaire.pileToInt(pile) && i == pile.size() - 1) {
				drawBorder(g, spacing + (CARD_WIDTH + spacing) * Solitaire.pileToInt(pile),
						CARD_HEIGHT + 2 * spacing + offset);
			}

			if (pile.get(i).isFaceUp()) {
				offset += upOffset;
			} else {
				offset += downOffset;
			}
		}

	}

	/**
	 * Draw each card onto the gui
	 * 
	 * @param g
	 * @param card
	 * @param x
	 * @param y
	 */
	protected void drawCard(Graphics g, Cards card, int x, int y) {
		if (card == null) {
			g.setColor(Color.BLACK);
			g.drawRect(x, y, CARD_WIDTH, CARD_HEIGHT);
		} else {
			String filename = card.getFileName(card);
			Image image = new ImageIcon(filename).getImage();
			g.drawImage(image, x, y, CARD_WIDTH, CARD_HEIGHT, null);
		}
	}

	/**
	 * Draw a black border for each card
	 * 
	 * @param g
	 * @param x
	 * @param y
	 */
	protected void drawBorder(Graphics g, int x, int y) {
		g.setColor(Color.RED);
		g.drawRect(x, y, CARD_WIDTH, CARD_HEIGHT);
		g.drawRect(x + 1, y + 1, CARD_WIDTH - 2, CARD_HEIGHT - 2);
		g.drawRect(x + 2, y + 2, CARD_WIDTH - 4, CARD_HEIGHT - 4);
	}
	
	/**
	 * Get the game frame
	 * @return
	 */
	protected Frame getFrame() {
		return frame;
	}
}
