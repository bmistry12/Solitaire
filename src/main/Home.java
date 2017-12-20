package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author bhavi
 */
public class Home extends javax.swing.JFrame {

	private JButton chooseSolitare;
	private JLabel jLabel1;
	private JMenu jMenu1;
	private JMenuBar jMenuBar1;
	private JMenuItem jMenuItem1;
	private JPanel jPanel1;

	public Home() {
		initComponents();
	}

	private void initComponents() {
		jPanel1 = new JPanel();
		jLabel1 = new JLabel();
		chooseSolitare = new JButton();
		jMenuBar1 = new JMenuBar();
		jMenu1 = new JMenu();
		jMenuItem1 = new JMenuItem();
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new Font("Copperplate Gothic Light", 0, 16)); 
		jLabel1.setText("WELCOME");
		jLabel1.setText("<html>WELCOME<br/>Please choose a card game to play</html>");

		chooseSolitare.setIcon(new ImageIcon("img/buttons/solitare.gif"));
		chooseSolitare.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
		chooseSolitare.setActionCommand("Solitare");
		chooseSolitare.setBackground(new Color(0, 0, 0));
		chooseSolitare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				chooseSolitareActionPerformed(evt);
			}
		});

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(
						jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup().addGap(25, 25, 25)
										.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 429,
												Short.MAX_VALUE)
										.addContainerGap())
								.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
										.addComponent(chooseSolitare)
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 50,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18).addComponent(chooseSolitare).addContainerGap(120, Short.MAX_VALUE)));

		jMenu1.setText("File");

		jMenuItem1.setText("Exit");
		jMenuItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jMenuItem1ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem1);
		jMenuBar1.add(jMenu1);

		
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}

	private void jMenuItem1ActionPerformed(ActionEvent evt) {
		System.exit(0);
	}

	private void chooseSolitareActionPerformed(ActionEvent evt) {
		solitare.RunSolitare.main(null);
	}


	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting
		// code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.
		 * html
		 */
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {			
		} catch (InstantiationException ex) {			
		} catch (IllegalAccessException ex) {			
		} catch (UnsupportedLookAndFeelException ex) {
		}

		// Create and display the form
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Home().setVisible(true);
			}
		});
	}
}