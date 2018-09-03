package main;

/**
 * Timer for the game to measure game length. Uses milliseconds.
 * 
 * @author bhavi
 *
 */
public class Timer {

	private long startTime;
	private long endTime;

	/**
	 * Constructor - initialises start time of game
	 */
	public Timer() {
		startTime = System.currentTimeMillis(); // current time in milliseconds
	}

	/**
	 * Invoked when the game ends
	 */
	public void endGame() {
		endTime = System.currentTimeMillis();
	}

	/**
	 * Returns the total length of the game in milliseconds
	 * 
	 * @return Game Duration
	 */
	public long getGameDuration() {
		return (endTime - startTime);
	}

	/**
	 * Convert a time in milliseconds to seconds
	 * 
	 * @param time
	 * @return
	 */
	public static long convertToSeconds(long time) {
		return (time / 1000);
	}

	/**
	 * Convert a time in milliseconds to minutes
	 * 
	 * @param time
	 * @return
	 */
	public static long convertToMinutes(long time) {
		return (convertToSeconds(time) / 60);
	}

}
