package solitaire;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import main.Timer;

/**
 * A JOptionPane dialog triggered by file>exit. Shows a few game stats.
 * 
 * @author bhavi
 *
 */
public class EndDialog {

	private JLabel text;
	private JFrame frame;

	/**
	 * Constructor for the End Game dialog
	 * 
	 * @param frame
	 * @param sol
	 * @param comp
	 */
	public EndDialog(JFrame frame, Solitaire sol, int comp) {
		this.frame = frame;
		initComponents(sol, comp);
	}

	/**
	 * Gets  and displays the relevant data via a message dialog
	 * @param sol
	 * @param comp
	 */
	private void initComponents(Solitaire sol, int comp) {
		String message;
		if (comp == 1) {
			message = ("Congratulations, You Win!!");
		} else {
			message = ("Better Luck Next Time!");
		}

		StringBuilder sb = new StringBuilder(250);
		sb.append("<html>");
		sb.append("<text-align='centre'>" + message + "</br></br>");
		sb.append("<table>");
		sb.append(String.format("<tr><td align='centre'>%s</td><td>:</td><td>%s</td></tr>", "Game Duration: ",
				Timer.convertToSeconds(sol.getTimer().getGameDuration()) + "s"));
		sb.append(String.format("<tr><td align='centre'>%s</td><td>:</td><td>%s</td></tr>", "Game Duration: ",
				Timer.convertToMinutes(sol.getTimer().getGameDuration()) + "mins"));
		sb.append(String.format("<tr><td align='centre'>%s</td><td>:</td><td>%s</td></tr>", "Total Number of Moves: ",
				sol.getMoves()));
		sb.append("</table></html>");

		text = new JLabel(sb.toString());
		text.setVisible(true);

		JOptionPane.showMessageDialog(this.frame, text, "GAME OVER", JOptionPane.PLAIN_MESSAGE);

	}

}
