package solitareNew;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cards.Cards;

public class solitareDisplay extends JFrame implements MouseListener{
	private JPanel dealPanel = new JPanel();
	private JPanel mainPanel = new JPanel();
	private JLabel label = new JLabel();
	private JButton deal = new JButton();
	private JLabel dealText = new JLabel();
	private Cards currentCard = null;
	
	public solitareDisplay(SolitareRules solitareRules) {
		this.setTitle("Solitare");
		this.setSize(1500, 700);// set size of frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel.setPreferredSize(new Dimension(1500, 700));
		mainPanel.setOpaque(true);
		mainPanel.setBackground(Color.DARK_GRAY);
		dealPanel.setPreferredSize(new Dimension(130,180));
		dealPanel.setBackground(Color.white);
		
		dealPanel.setVisible(true);
		mainPanel.setVisible(true);
		label.setIcon(solitareRules.setCard());
		
		deal.setPreferredSize(new Dimension(60, 20));
		dealText.setText("Deal");
		deal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dealButtonActionPerformed(evt, solitareRules);
			}
		});
		
		deal.add(dealText);
		dealPanel.add(label);
		mainPanel.add(deal);
		mainPanel.add(dealPanel);
		this.addMouseListener(this);
		this.add(mainPanel);
		this.pack();
		this.setVisible(true);
	}

	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Component comp  = e.getComponent();
		System.out.println(comp);
		int x = e.getXOnScreen();
		int y = e.getYOnScreen();
		System.out.println(x);
		System.out.println(y);
		if (x <= 752 && x >= 625 && y >= 37 && y <= 214) {
			System.out.println("here");
		}
	}
	
	private void dealButtonActionPerformed(ActionEvent evt, SolitareRules solitareRules) {
		currentCard = solitareRules.startDeck.removeTopOfDeck();
		String cardPath = getCardPath.getPath(currentCard);
		ImageIcon icon = new ImageIcon(cardPath);
		label.setIcon(icon);
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
