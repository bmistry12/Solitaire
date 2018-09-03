package base;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import card.Cards;
import solitaire.Solitaire;

/**
 * Abstract Display extended by all solitaire display classes
 * 
 * @author bhavi
 *
 */
public abstract class AbstractDisplay extends JComponent {

	protected static final int CARD_WIDTH = 73;
	protected static final int CARD_HEIGHT = 97;
	protected static int spacing = 5;
	protected static int upOffset = 15;
	protected static int downOffset = 5;

	protected int selectedRow = -1;
	protected int selectedCol = 1;

	private Dimension size = new Dimension(CARD_WIDTH * 7 + spacing * 8,
			CARD_HEIGHT * 2 + spacing * 3 + downOffset * 7 + 13 * upOffset);
	private JFrame frame;
	private JMenuBar menubar;
	private AbstractSolitaire solitaire;
	//Default colour set as green - can be changed via edit>..
	private Color bckgrdColour = Color.GREEN;

	/**
	 * Create a new solitaire window
	 * 
	 * @param solitaire
	 */
	public AbstractDisplay(AbstractSolitaire solitaire) {
		this.solitaire = solitaire;
		frame = new JFrame();
		frame.setTitle("Solitaire");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		menubar = new JMenuBar();
		initMenuBar();
		frame.setJMenuBar(menubar);

		frame.getContentPane().add(this);
		this.setPreferredSize(size);
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Initialise the menu bar
	 */
	private void initMenuBar() {
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.setActionCommand("Exit");
		exitMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.err.println("clicked exit!");
				endGame(0);
			}
		});
		JMenuItem colGr = new JMenuItem("BckGrd Green");
		colGr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setColour(Color.GREEN);
				repaint();
			}
		});
		JMenuItem colRed = new JMenuItem("BckGrd Red");
		colRed.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setColour(Color.RED);
				repaint();
			}
		});
		JMenuItem colBlue = new JMenuItem("BckGrd Blue");
		colBlue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setColour(Color.BLUE);
				repaint();
			}
		});
		JMenuItem colPink = new JMenuItem("BckGrd Pink");
		colPink.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setColour(Color.PINK);
				repaint();
			}
		});
		JMenuItem colOrg = new JMenuItem("BckGrd Orange");
		colOrg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setColour(Color.ORANGE);
				repaint();
			}
		});

		fileMenu.add(exitMenuItem);
		editMenu.add(colGr);
		editMenu.add(colRed);
		editMenu.add(colBlue);
		editMenu.add(colPink);
		editMenu.add(colOrg);
		menubar.add(fileMenu);
		menubar.add(editMenu);
	}

	/**
	 * Ends the current game
	 * 
	 * @param complete
	 */
	public abstract void endGame(int complete);

	
	/**
	 * draw display
	 */
	public void paintComponent(Graphics g) {
		// background
		g.setColor(getColour());
		g.fillRect(0, 0, getWidth(), getHeight());
		// face down
		drawCard(g, solitaire.getStockCard(), spacing, spacing);
		// stock
		drawCard(g, solitaire.getWasteCard(), spacing * 2 + CARD_WIDTH, spacing);
		if (selectedRow == 0 && selectedCol == 1) {
			drawBorder(g, spacing * 2 + CARD_WIDTH, spacing);
		}
		// aces
		for (int i = 0; i < 4; i++) {
			drawCard(g, solitaire.getFoundCard(i), spacing * (4 + i) + CARD_WIDTH * (3 + i), spacing);
		}
		// piles
		Stack<Stack<Cards>> piles = solitaire.getAllPiles();
		for (Stack<Cards> pile : piles) {
			int offset = 0;
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
	 * 
	 * @return
	 */
	protected JFrame getFrame() {
		return frame;
	}

	/**
	 * Returns the size of the game frame
	 * 
	 * @return
	 */
	public Dimension frameSize() {
		return size;
	}
	
	/**
	 * Set the background colour
	 * @param colour
	 */
	protected void setColour(Color colour) {
		this.bckgrdColour = colour;
	}

	/**
	 * Get the current background colour
	 * @return
	 */
	protected Color getColour() {
		return this.bckgrdColour;
	}
}
