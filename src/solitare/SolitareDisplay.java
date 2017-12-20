package solitare;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;

import cards.Cards;

@SuppressWarnings("serial")
public class SolitareDisplay extends JComponent implements MouseListener {
	/**
	 * Stock Deck - Left over after cards are dealt 
	 * Waste Deck - Cards taken off stock deck
	 * Foundation Piles - Ace upwards for each suit
	 */
	private static final int CARD_WIDTH = 73;
	private static final int CARD_HEIGHT = 97;
	private static int spacing = 5;
	private static int upOffset = 15;
	private static int downOffset = 5;
	
	private JFrame frame;
	private int selectedRow = -1;
	private int selectedCol = 1;
	private Solitare solitare;
	
	public SolitareDisplay(Solitare solitare){
		this.solitare = solitare;
		frame = new JFrame();
		frame.setTitle("Solitare");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(this);
		this.setPreferredSize(new Dimension(CARD_WIDTH * 7 + spacing * 8, 
				CARD_HEIGHT * 2 + spacing * 3 + downOffset * 7 + 13 * 
				upOffset));
		this.addMouseListener(this);
		frame.pack();
		frame.setVisible(true);
	}
	
	//draw display
	public void paintComponent(Graphics g){
		//background
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, getWidth(), getHeight());
		//face down
		drawCard(g, solitare.getStockCard(), spacing, spacing);
		//stock
		drawCard(g, solitare.getWasteCard(), spacing * 2 + CARD_WIDTH, spacing);
		if (selectedRow == 0 && selectedCol == 1) {
			drawBorder(g, spacing * 2 + CARD_WIDTH, spacing);
		}
		//aces
		for (int i = 0; i < 4; i++) {
			drawCard(g, solitare.getFoundCard(i), spacing * (4 + i) + CARD_WIDTH * (3 + i), spacing);
		}
		//piles
		int offset = 0;
		Stack<Cards> pile = solitare.getPile(Solitare.col1);
		for(int i = 0; i < pile.size(); i++){
			drawCard(g, pile.get(i), spacing + (CARD_WIDTH + spacing) * Solitare.pileToInt(pile), CARD_HEIGHT + 2 * spacing + offset);
			if (selectedRow == 1 && selectedCol == Solitare.pileToInt(pile) && i == pile.size() - 1) {
				drawBorder(g, spacing + (CARD_WIDTH + spacing) * Solitare.pileToInt(pile), CARD_HEIGHT + 2 * spacing + offset);
			}

			if (pile.get(i).isFaceUp()) {
				offset += upOffset;
			} else {
				offset += downOffset;
			}
		}
		offset = 0;
		pile = solitare.getPile(Solitare.col2);
		for(int i = 0; i < pile.size(); i++){
			drawCard(g, pile.get(i), spacing + (CARD_WIDTH + spacing) * Solitare.pileToInt(pile), CARD_HEIGHT + 2 * spacing + offset);
			if (selectedRow == 1 && selectedCol == Solitare.pileToInt(pile) && i == pile.size() - 1) {
				drawBorder(g, spacing + (CARD_WIDTH + spacing) * Solitare.pileToInt(pile), CARD_HEIGHT + 2 * spacing + offset);
			}

			if (pile.get(i).isFaceUp()) {
				offset += upOffset;
			} else {
				offset += downOffset;
			}
		}
		offset = 0;
		pile = solitare.getPile(Solitare.col3);
		for(int i = 0; i < pile.size(); i++){
			drawCard(g, pile.get(i), spacing + (CARD_WIDTH + spacing) * Solitare.pileToInt(pile), CARD_HEIGHT + 2 * spacing + offset);
			if (selectedRow == 1 && selectedCol == Solitare.pileToInt(pile) && i == pile.size() - 1) {
				drawBorder(g, spacing + (CARD_WIDTH + spacing) * Solitare.pileToInt(pile), CARD_HEIGHT + 2 * spacing + offset);
			}

			if (pile.get(i).isFaceUp()) {
				offset += upOffset;
			} else {
				offset += downOffset;
			}
		}
		offset = 0;
		pile = solitare.getPile(Solitare.col4);
		for(int i = 0; i < pile.size(); i++){
			drawCard(g, pile.get(i), spacing + (CARD_WIDTH + spacing) * Solitare.pileToInt(pile), CARD_HEIGHT + 2 * spacing + offset);
			if (selectedRow == 1 && selectedCol == Solitare.pileToInt(pile) && i == pile.size() - 1) {
				drawBorder(g, spacing + (CARD_WIDTH + spacing) * Solitare.pileToInt(pile), CARD_HEIGHT + 2 * spacing + offset);
			}

			if (pile.get(i).isFaceUp()) {
				offset += upOffset;
			} else {
				offset += downOffset;
			}
		}
		offset = 0;
		pile = solitare.getPile(Solitare.col5);
		for(int i = 0; i < pile.size(); i++){
			drawCard(g, pile.get(i), spacing + (CARD_WIDTH + spacing) * Solitare.pileToInt(pile), CARD_HEIGHT + 2 * spacing + offset);
			if (selectedRow == 1 && selectedCol == Solitare.pileToInt(pile) && i == pile.size() - 1) {
				drawBorder(g, spacing + (CARD_WIDTH + spacing) * Solitare.pileToInt(pile), CARD_HEIGHT + 2 * spacing + offset);
			}

			if (pile.get(i).isFaceUp()) {
				offset += upOffset;
			} else {
				offset += downOffset;
			}
		}
		offset = 0;
		pile = solitare.getPile(Solitare.col6);
		for(int i = 0; i < pile.size(); i++){
			drawCard(g, pile.get(i), spacing + (CARD_WIDTH + spacing) * Solitare.pileToInt(pile), CARD_HEIGHT + 2 * spacing + offset);
			if (selectedRow == 1 && selectedCol == Solitare.pileToInt(pile) && i == pile.size() - 1) {
				drawBorder(g, spacing + (CARD_WIDTH + spacing) * Solitare.pileToInt(pile), CARD_HEIGHT + 2 * spacing + offset);
			}

			if (pile.get(i).isFaceUp()) {
				offset += upOffset;
			} else {
				offset += downOffset;
			}
		}
		offset = 0;
		pile = solitare.getPile(Solitare.col7);
		for(int i = 0; i < pile.size(); i++){
			drawCard(g, pile.get(i), spacing + (CARD_WIDTH + spacing) * Solitare.pileToInt(pile), CARD_HEIGHT + 2 * spacing + offset);
			if (selectedRow == 1 && selectedCol == Solitare.pileToInt(pile) && i == pile.size() - 1) {
				drawBorder(g, spacing + (CARD_WIDTH + spacing) * Solitare.pileToInt(pile), CARD_HEIGHT + 2 * spacing + offset);
			}

			if (pile.get(i).isFaceUp()) {
				offset += upOffset;
			} else {
				offset += downOffset;
			}
		}
				
	}
	
	private void drawCard(Graphics g,  Cards card, int x, int y) {
	//draw each card
		if(card == null) {
			g.setColor(Color.BLACK);
			g.drawRect(x, y, CARD_WIDTH, CARD_HEIGHT);
		} else {
			String filename = card.getFileName(card);
			Image image = new ImageIcon(filename).getImage();
			g.drawImage(image, x, y, CARD_WIDTH, CARD_HEIGHT, null);
		}
	}
	
	private void drawBorder(Graphics g, int x, int y) {
	//black border for each card
		g.setColor(Color.BLACK);
		g.drawRect(x, y, CARD_WIDTH, CARD_HEIGHT);
		g.drawRect(x + 1, y + 1, CARD_WIDTH - 2, CARD_HEIGHT - 2);
		g.drawRect(x + 2, y + 2, CARD_WIDTH - 4, CARD_HEIGHT - 4);
	}
	
	@Override
	public void mouseClicked(MouseEvent click) {
	//when mouse is clicked carry out relevant method depedning on what has been clicked and then redraw the gui
		int col = click.getX() / (spacing + CARD_WIDTH);
		int row = click.getY() / (spacing + CARD_HEIGHT);
		if (row == 0 && col == 0){
			solitare.stockDeck();
		} else if (row == 0 && col == 1) {
			solitare.wasteCardClicked();
		} else if (row == 0 && col >= 3) {
			solitare.foundationClicked(col - 3);
		} else if (row == 1) {
			Stack<Cards> temp = Solitare.intToPile(col);
			solitare.pileClicked(temp);			
		}	
		repaint();	
	}
	
	public void unselect() {
		selectedRow = -1;
		selectedCol = -1;
	}

	public boolean isWasteSelected() {
		return selectedRow == 0 && selectedCol == 1;
	}

	public void selectWaste()	{
		selectedRow = 0;
		selectedCol = 1;
	}

	public boolean isPileSelected() {
		return selectedRow == 1;
	}

	public int selectedPile() {
		if (selectedRow == 1) {
			return selectedCol;
		} else {
			return -1;
		}
	}

	public void selectPile(Stack<Cards> pile)	{
		selectedRow = 1;
		selectedCol= Solitare.pileToInt(pile);	
	}
	
	//unused methods
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

