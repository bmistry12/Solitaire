package solitare;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import cards.Cards;

public class solDisplay extends JFrame implements MouseListener {
	
	private static final int WIDTH = 73;
	private static final int HEIGHT = 97;
	private static final int SPACING = 5;  //distance between cards
	private static final int FUOFFSET = 15;  //distance for cascading face-up cards
	private static final int FDOFFSET = 5;  //distance for cascading face-down cards
	
	private int selectedRow = -1;
	private int selectedCol = -1;
	private SolitareRules solitare;
	
	public solDisplay(SolitareRules solitare){
		this.solitare = solitare;
		this.setTitle("Solitare");
		this.setPreferredSize(new Dimension(WIDTH * 7 + SPACING * 8, HEIGHT * 2 + SPACING * 3 + FDOFFSET * 7 + 13 * FUOFFSET));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addMouseListener(this);
		this.pack();
		this.setVisible(true);
	}
	
	private void paintComponenet(Graphics g){
		g.setColor(Color.BLACK);
		drawCard(g, solitare.wasteDeck.removeTopOfDeck(), SPACING, SPACING);
		///
		if (selectedRow == 0 && selectedCol == 1)
			drawBorder(g, SPACING * 2 + WIDTH, SPACING);

		//piles
		for (int i = 0; i < 7; i++)
		{
			Stack<Cards> pile = solitare.col1;
			int offset = 0;
			for (int j = 0; j < pile.size(); j++)
			{
				drawCard(g, pile.get(j), SPACING + (WIDTH + SPACING) * i, HEIGHT + 2 * SPACING + offset);
				if (selectedRow == 1 && selectedCol == i && j == pile.size() - 1)
					drawBorder(g, SPACING + (WIDTH + SPACING) * i, HEIGHT + 2 * SPACING + offset);

				if (pile.get(j).isFaceUp())
					offset += FUOFFSET;
				else
					offset += FDOFFSET;
			}
			Stack<Cards> pile2 = solitare.col2;
			for (int j = 0; j < pile2.size(); j++)
			{
				drawCard(g, pile2.get(j), SPACING + (WIDTH + SPACING) * i, HEIGHT + 2 * SPACING + offset);
				if (selectedRow == 1 && selectedCol == i && j == pile.size() - 1)
					drawBorder(g, SPACING + (WIDTH + SPACING) * i, HEIGHT + 2 * SPACING + offset);

				if (pile2.get(j).isFaceUp())
					offset += FUOFFSET;
				else
					offset += FDOFFSET;
			}
		}
	}
	
	//
	private void drawBorder(Graphics g, int x, int y)
	{
		g.setColor(Color.RED);
		g.drawRect(x, y, WIDTH, HEIGHT);
		g.drawRect(x + 1, y + 1, WIDTH - 2, HEIGHT - 2);
		g.drawRect(x + 2, y + 2, WIDTH - 4, HEIGHT - 4);
	}
	private void drawCard(Graphics g, Cards card, int x, int y){
		String imagePath = getCardPath.getPath(card);
		Image image = new ImageIcon(imagePath).getImage();
		g.drawImage(image, x, y, WIDTH, HEIGHT, null);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

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
