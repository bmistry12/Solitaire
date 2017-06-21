package solitare;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cards.Cards;

public class solitareDisplay extends JFrame implements MouseListener {
	private JPanel dealPanel = new JPanel();
	private JPanel gamePanel = new JPanel();
	private JPanel mainPanel = new JPanel();
	private JPanel c1 = new JPanel();
	private JPanel c2 = new JPanel();
	private JPanel c3 = new JPanel();
	private JPanel c4 = new JPanel();
	private JPanel c5 = new JPanel();
	private JPanel c6 = new JPanel();
	private JPanel c7 = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private JLabel newCard = new JLabel();
	private JButton deal = new JButton();
	private JButton one = new JButton();
	private JButton two = new JButton();
	private JButton three = new JButton();
	private JButton four = new JButton();
	private JButton five = new JButton();
	private JButton six = new JButton();
	private JButton seven = new JButton();
	private JLabel a = new JLabel();
	private JLabel b = new JLabel();
	private JLabel c = new JLabel();
	private JLabel d = new JLabel();
	private JLabel e = new JLabel();
	private JLabel f = new JLabel();
	private JLabel g = new JLabel();
	
	private JLabel dealText = new JLabel();
	private Cards currentCard = null;
	private boolean newCardSelected = false;

	public solitareDisplay(SolitareRules solitareRules) {
		this.setTitle("Solitare");
		this.setSize(1500, 700);// set size of frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel.setPreferredSize(new Dimension(1500, 700));
		mainPanel.setOpaque(true);
		mainPanel.setBackground(Color.DARK_GRAY);
		dealPanel.setPreferredSize(new Dimension(130, 180));
		dealPanel.setBackground(Color.white);
		gamePanel.setPreferredSize(new Dimension(1400, 430));
		gamePanel.setBackground(Color.green);
		buttonPanel.setPreferredSize(new Dimension(1400, 100));
		buttonPanel.setBackground(Color.red);
		c1.setPreferredSize(new Dimension(160, 420));
		c1.setBorder(BorderFactory.createLineBorder(Color.blue));
		c2.setPreferredSize(new Dimension(160, 420));
		c2.setBorder(BorderFactory.createLineBorder(Color.black));
		c3.setPreferredSize(new Dimension(160, 420));
		c3.setBorder(BorderFactory.createLineBorder(Color.red));
		c4.setPreferredSize(new Dimension(160, 420));
		c4.setBorder(BorderFactory.createLineBorder(Color.orange));
		c5.setPreferredSize(new Dimension(160, 420));
		c5.setBorder(BorderFactory.createLineBorder(Color.yellow));
		c6.setPreferredSize(new Dimension(160, 420));
		c6.setBorder(BorderFactory.createLineBorder(Color.gray));
		c7.setPreferredSize(new Dimension(160, 420));
		c7.setBorder(BorderFactory.createLineBorder(Color.cyan));

		c1.setVisible(true);
		c2.setVisible(true);
		c3.setVisible(true);
		c4.setVisible(true);
		c5.setVisible(true);
		c6.setVisible(true);
		c7.setVisible(true);
		gamePanel.setVisible(true);
		dealPanel.setVisible(true);
		mainPanel.setVisible(true);
		newCard.setIcon(solitareRules.setCard());
		deal.setPreferredSize(new Dimension(60, 20));
		dealText.setText("Deal");
		deal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dealButtonActionPerformed(evt, solitareRules);
			}
		});

		one.setPreferredSize(new Dimension(20, 10));
		one.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				oneButtonActionPerformed(evt, solitareRules);
			}
		});
		two.setPreferredSize(new Dimension(20, 10));
		two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				twoButtonActionPerformed(evt, solitareRules);
			}
		});
		three.setPreferredSize(new Dimension(20, 10));
		three.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				threeButtonActionPerformed(evt, solitareRules);
			}
		});
		four.setPreferredSize(new Dimension(20, 10));
		four.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				fourButtonActionPerformed(evt, solitareRules);
			}
		});
		five.setPreferredSize(new Dimension(20, 10));
		five.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				fiveButtonActionPerformed(evt, solitareRules);
			}
		});
		six.setPreferredSize(new Dimension(20, 10));
		six.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				sixButtonActionPerformed(evt, solitareRules);
			}
		});
		seven.setPreferredSize(new Dimension(20, 10));
		seven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				sevenButtonActionPerformed(evt, solitareRules);
			}
		});

		deal.add(dealText);
		dealPanel.add(newCard);
		c1.add(a);
		c2.add(b);
		c3.add(c);
		c4.add(d);
		c5.add(e);
		c6.add(f);
		c7.add(g);
		gamePanel.add(c1);
		gamePanel.add(c2);
		gamePanel.add(c3);
		gamePanel.add(c4);
		gamePanel.add(c5);
		gamePanel.add(c6);
		gamePanel.add(c7);
		buttonPanel.add(one);
		buttonPanel.add(two);
		buttonPanel.add(three);
		buttonPanel.add(four);
		buttonPanel.add(five);
		buttonPanel.add(six);
		buttonPanel.add(seven);
		mainPanel.add(deal);
		mainPanel.add(dealPanel);
		mainPanel.add(gamePanel);
		mainPanel.add(buttonPanel);
		this.addMouseListener(this);
		this.add(mainPanel);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Component comp = e.getComponent();
		System.out.println(comp);
		int x = e.getXOnScreen();
		int y = e.getYOnScreen();
		System.out.println(x);
		System.out.println(y);
		if (x <= 752 && x >= 625 && y >= 37 && y <= 214) {
			System.out.println("here");
			newCardSelected = true;
		}
	}

	private void dealButtonActionPerformed(ActionEvent evt, SolitareRules solitareRules) {
		currentCard = solitareRules.wasteDeck.removeTopOfDeck();
		String cardPath = getCardPath.getPath(currentCard);
		ImageIcon icon = new ImageIcon(cardPath);
		newCard.setIcon(icon);
	}

	private void oneButtonActionPerformed(ActionEvent evt, SolitareRules solitareRules) {
		if (newCardSelected == true) {
			String cardPath = getCardPath.getPath(currentCard);
			ImageIcon icon = new ImageIcon(cardPath);
			a.setIcon(icon);
			solitareRules.wasteDeck.removeTopOfDeck();
		} else {
			System.err.println("Cannot add a card - no card has been selected");
		}

	}

	private void twoButtonActionPerformed(ActionEvent evt, SolitareRules solitareRules) {
		if (newCardSelected == true) {
			
		} else {
			System.err.println("Cannot add a card - no card has been selected");
		}

	}

	private void threeButtonActionPerformed(ActionEvent evt, SolitareRules solitareRules) {
		if (newCardSelected == true) {
			
		} else {
			System.err.println("Cannot add a card - no card has been selected");
		}

	}

	private void fourButtonActionPerformed(ActionEvent evt, SolitareRules solitareRules) {
		if (newCardSelected == true) {
			
		} else {
			System.err.println("Cannot add a card - no card has been selected");
		}
	}

	private void fiveButtonActionPerformed(ActionEvent evt, SolitareRules solitareRules) {
		if (newCardSelected == true) {

		} else {
			System.err.println("Cannot add a card - no card has been selected");
		}
	}

	private void sixButtonActionPerformed(ActionEvent evt, SolitareRules solitareRules) {
		// TODO Auto-generated method stub

	}

	private void sevenButtonActionPerformed(ActionEvent evt, SolitareRules solitareRules) {
		if (newCardSelected == true) {

		} else {
			System.err.println("Cannot add a card - no card has been selected");
		}
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
