package main;

import solitaire.Solitaire;
import solitaireComp.CompSolitaire;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 * Home Screen - Contains Main Method.
 * This is where it all runs from
 * 
 * @author bhavi
 */
@SuppressWarnings("serial")
public class Home extends JFrame {

	private JButton standardButton;
	private JButton compModeButton;
	private JMenu fileMenu;
	private JMenuBar menuBar;
	private JMenuItem exitItem;
	private JPanel panel;

	private Thread sol;
	private static Thread compSol;

	/**
	 * Creates new form NewJFrame
	 */
	public Home() {
		this.setTitle("Welcome To Solitaire");
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialise the form.
	 */
	private void initComponents() {
		panel = new JPanel();
		standardButton = new JButton();
		compModeButton = new JButton();
		menuBar = new JMenuBar();
		fileMenu = new JMenu();
		exitItem = new JMenuItem();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		standardButton.setIcon(new ImageIcon("img/buttons/standard.gif")); // standard
		standardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		standardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				standardModeActionPerformed(evt);
			}
		});

		compModeButton.setIcon(new ImageIcon("img/buttons/comp.gif"));// comp
		compModeButton.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
		compModeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compModeActionPerformed(evt);
			}
		});

		GroupLayout jPanel1Layout = new GroupLayout(panel);
		panel.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(34, 34, 34)
						.addComponent(standardButton, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
						.addComponent(compModeButton, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
						.addGap(34, 34, 34)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(standardButton, GroupLayout.Alignment.TRAILING,
										GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
								.addComponent(compModeButton, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
						.addContainerGap(119, Short.MAX_VALUE)));

		fileMenu.setText("File");

		exitItem.setText("Exit");
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				exitActionPerformed(evt);
			}
		});

		fileMenu.add(exitItem);
		menuBar.add(fileMenu);
		setJMenuBar(menuBar);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));

		this.pack();
	}

	/**
	 * Action code for when exit is pressed
	 * 
	 * @param evt
	 */
	private void exitActionPerformed(ActionEvent evt) {
		try {
			if (sol != null) {
				sol.join();
			}
			if (compSol != null) {
				compSol.join();
			}
		} catch (InterruptedException e) {
			e.getMessage();
		}
	}

	/**
	 * Action code for when the Normal mode of solitaire is pressed
	 * 
	 * @param evt
	 */
	private void standardModeActionPerformed(ActionEvent evt) {
		Solitaire solitaire = new Solitaire();
		if (sol == null) {
			sol = new Thread(solitaire);
			sol.start();
		}
	}

	/**
	 * Action code for when the Comp mode of solitaire is pressed
	 * 
	 * @param evt
	 * @throws InterruptedException
	 */
	private void compModeActionPerformed(ActionEvent evt) {
		Solitaire solitaire = new Solitaire();
		CompSolitaire comp = new CompSolitaire(solitaire.getAllPiles(), solitaire.getStockDeck());
		if (compSol == null) {
			compSol = new Thread(comp);
			compSol.start();
		}
	}
	
	/**
	 * Method called from CompSolitaire. Allows us to end the game from file>exit
	 */
	public static void endCompThread() {
		try {
			compSol.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Main method - where it all runs from
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException ex) {
			ex.printStackTrace();
		}
		// Create and display the frame
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Home().setVisible(true);
			}
		});
	}
}
