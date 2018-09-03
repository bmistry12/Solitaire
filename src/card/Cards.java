package card;

import java.util.Objects;

/**
 * Represents a card
 * 
 * @author bhavi
 *
 */
public class Cards {

	private final Suit suit;
	private final Value value;
	public boolean isFaceUp = false;

	public Cards(Suit suit, Value value) {
		this.suit = suit;
		this.value = value;
	}

	/**
	 * Get the colour of a card given its suit
	 * 
	 * @return
	 */
	public String getColour() {
		if (suit == Suit.CLUBS || suit == Suit.SPADES) {
			return "BLACK";
		} else {
			return "RED";
		}
	}

	/**
	 * Get the suit of the card
	 * 
	 * @return
	 */
	public Suit getSuit() {
		return suit;
	}

	/**
	 * Get the value of the card
	 * 
	 * @return
	 */
	public Value getValue() {
		return value;
	}

	/**
	 * Convert card value to card integer value
	 * 
	 * @param cardValue
	 * @return
	 */
	public int valueToInt(Value cardValue) {
		int value = 0;
		switch (cardValue) {
		case ACE:
			value = 1;
			break;
		case TWO:
			value = 2;
			break;
		case THREE:
			value = 3;
			break;
		case FOUR:
			value = 4;
			break;
		case FIVE:
			value = 5;
			break;
		case SIX:
			value = 6;
			break;
		case SEVEN:
			value = 7;
			break;
		case EIGHT:
			value = 8;
			break;
		case NINE:
			value = 9;
			break;
		case TEN:
			value = 10;
			break;
		case JACK:
			value = 11;
			break;
		case QUEEN:
			value = 12;
			break;
		case KING:
			value = 13;
			break;
		default:
			System.err.println("There has been an error here");
			break;

		}
		return value;
	}

	/**
	 * Returns true if card is face up
	 * 
	 * @return
	 */
	public boolean isFaceUp() {
		return isFaceUp;
	}

	/**
	 * Turn the card up
	 */
	public void turnUp() {
		isFaceUp = true;
	}

	/**
	 * Turn the card down
	 */
	public void turnDown() {
		isFaceUp = false;
	}

	/**
	 * Get the visible file path for the card
	 * 
	 * @param card
	 * @return
	 */
	public String getFileName(Cards card) {
		if (!card.isFaceUp) {
			return "img/back.gif";
		} else {
			return GetCardPath.getPath(card);
		}
	}

	/**
	 * toString method for a card
	 */
	@Override
	public String toString() {
		return value + " of " + suit;
	}
	
	@Override
	public boolean equals(Object o){
		if (o == this){
			return true;
		}
		if (o instanceof Cards){
			Cards card = (Cards) o;
			if((card.getSuit() == this.getSuit()) && (card.getValue() == this.getValue())){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(suit, value);
	}
}