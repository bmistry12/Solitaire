package main;

import solitaire.Solitaire;
import solitaireAI.AISolitaire;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 * Home Screen - main method
 * 
 * @author bhavi
 */
public class Home extends JFrame {

	private JButton standardButton;
	private JButton jButton2;
	private JMenu fileMenu;
	private JMenuBar menuBar;
	private JMenuItem exitItem;
	private JPanel panel;

	/**
	 * Creates new form NewJFrame
	 */
	public Home() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialise the form.
	 */
	private void initComponents() {
		panel = new JPanel();
		standardButton = new JButton();
		jButton2 = new JButton();
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

		jButton2.setIcon(new ImageIcon("img/buttons/ai.gif"));// ai
		jButton2.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				aiModeActionPerformed(evt);
			}
		});

		GroupLayout jPanel1Layout = new GroupLayout(panel);
		panel.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(34, 34, 34)
						.addComponent(standardButton, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
						.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
						.addGap(34, 34, 34)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(standardButton, GroupLayout.Alignment.TRAILING,
										GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
						.addContainerGap(119, Short.MAX_VALUE)));

		fileMenu.setText("File");

		exitItem.setText("Exit");
		exitItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
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
	private void exitActionPerformed(java.awt.event.ActionEvent evt) {
		System.exit(0);
	}

	/**
	 * Action code for when the Normal mode of solitaire is pressed
	 * 
	 * @param evt
	 */
	private void standardModeActionPerformed(java.awt.event.ActionEvent evt) {
		Solitaire solitaire = new Solitaire();
	}

	/**
	 * Action code for when the AI mode of solitaire is pressed
	 * 
	 * @param evt
	 */
	private void aiModeActionPerformed(java.awt.event.ActionEvent evt) {
		Solitaire solitaire = new Solitaire();
		AISolitaire ai = new AISolitaire(solitaire.getAllPiles(), solitaire.getStockDeck());

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
