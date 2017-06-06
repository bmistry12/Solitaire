package solitareNew;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

import cards.Cards;

public class solitareInJava extends JComponent implements MouseListener
{
	private static final int CARD_WIDTH = 73;
	private static final int CARD_HEIGHT = 97;
	private static final int SPACING = 5;  //distance between cards
	private static final int FACE_UP_OFFSET = 15;  //distance for cascading face-up cards
	private static final int FACE_DOWN_OFFSET = 5;  //distance for cascading face-down cards

	private JFrame frame;
	private int selectedRow = -1;
	private int selectedCol = -1;
	private SolitareRules game;

	public solitareInJava(SolitareRules game)
	{
		this.game = game;

		frame = new JFrame("Solitaire");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(this);

		this.setPreferredSize(new Dimension(CARD_WIDTH * 7 + SPACING * 8, CARD_HEIGHT * 2 + SPACING * 3 + FACE_DOWN_OFFSET * 7 + 13 * FACE_UP_OFFSET));
		this.addMouseListener(this);

		frame.pack();
		frame.setVisible(true);
	}

	public void paintComponent(Graphics g)
	{
		//background
		g.setColor(new Color(0, 128, 0));
		g.fillRect(0, 0, getWidth(), getHeight());

		//face down


		//stock
		
		if (selectedRow == 0 && selectedCol == 1)
			drawBorder(g, SPACING * 2 + CARD_WIDTH, SPACING);

		//aces
			

		//piles

	}

	private void drawCard(Graphics g, Cards card, int x, int y)
	{
		if (card == null)
		{
			g.setColor(Color.BLACK);
			g.drawRect(x, y, CARD_WIDTH, CARD_HEIGHT);
		}
		else
		{
			String fileName = getCardPath.getPath(card);
			if (!new File(fileName).exists())
			    throw new IllegalArgumentException("bad file name:  " + fileName);
			Image image = new ImageIcon(fileName).getImage();
			g.drawImage(image, x, y, CARD_WIDTH, CARD_HEIGHT, null);
		}
	}

	public void mouseExited(MouseEvent e)
	{
	}

	public void mouseEntered(MouseEvent e)
	{
	}

	public void mouseReleased(MouseEvent e)
	{
	}

	public void mousePressed(MouseEvent e)
	{
	}

	public void mouseClicked(MouseEvent e)
	{
		//none selected previously
		int col = e.getX() / (SPACING + CARD_WIDTH);
		int row = e.getY() / (SPACING + CARD_HEIGHT);
		if (row > 1)
			row = 1;
		if (col > 6)
			col = 6;

	}

	private void drawBorder(Graphics g, int x, int y)
	{
		g.setColor(Color.YELLOW);
		g.drawRect(x, y, CARD_WIDTH, CARD_HEIGHT);
		g.drawRect(x + 1, y + 1, CARD_WIDTH - 2, CARD_HEIGHT - 2);
		g.drawRect(x + 2, y + 2, CARD_WIDTH - 4, CARD_HEIGHT - 4);
	}

	public void unselect()
	{
		selectedRow = -1;
		selectedCol = -1;
	}

	public boolean isWasteSelected()
	{
		return selectedRow == 0 && selectedCol == 1;
	}

	public void selectWaste()
	{
		selectedRow = 0;
		selectedCol = 1;
	}

	public boolean isPileSelected()
	{
		return selectedRow == 1;
	}

	public int selectedPile()
	{
		if (selectedRow == 1)
			return selectedCol;
		else
			return -1;
	}

	public void selectPile(int index)
	{
		selectedRow = 1;
		selectedCol = index;
	}
}