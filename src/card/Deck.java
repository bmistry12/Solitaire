package card;

import java.util.Random;

/**
 * A Deck Of Cards
 * @author bhavi
 *
 */
public class Deck {
	
	private Cards cards[];
	private Suit suits[];
	private Value values[];
	private int deckSize = 0;
	
	/**
	 * Constructor for a new deck of cards
	 */
	public Deck(){
		cards = new Cards[52];
		suits = Suit.values();
		values = Value.values();
		int count = 0; 
		for (int i = 0; i < suits.length; i++){
			for (int j = 0; j < values.length; j++){
				cards[count] = new Cards(suits[i], values[j]);
				count++;
			}
		}
		deckSize = count;
	}
	
	/**
	 * Prints contents of a deck to console
	 */
	public void printDeck(){
		int counter = 0; 
		for (int i = 0; i < suits.length; i++){
			for (int j = 0; j < values.length; j++){
				System.out.println(cards[counter]);
				counter++;
			}
		}
	}
	
	/**
	 * Returns deck side
	 * @return deckSize
	 */
	public int getDeckSize(){
		return deckSize;
	}
	
	/**
	 * Returns the card at the top of the deck - doesn't remove
	 * @return
	 */
	public Cards getTopOfDeck(){
		return cards[deckSize-1];
	}
	
	/**
	 * Returns the card at the top of the deck - removes it
	 * @return
	 */
	public Cards removeTopOfDeck(){
		return cards[(deckSize--)-1];
	}
	
	/**
	 * Shuffles the deck
	 */
	public void shuffleDeck(){
		Random rand= new Random();
		for (int i = 0; i < 104; i++){
			int indexCard1 = rand.nextInt(deckSize-1);
			int indexCard2 = rand.nextInt(deckSize-1);
			Cards tempCard = cards[indexCard1];
			cards[indexCard1] = cards[indexCard2];
			cards[indexCard2] = tempCard;
		}				
	}
	
	/**
	 * Increments the size of the deck by one
	 */
	public void increaseDeckSize(){
		deckSize++;
	}

	/**
	 * Adds a card to the top of the deck
	 * @param temp
	 */
	public void addCard(Cards temp) {
		cards[deckSize+1] = temp;	
	}
}
