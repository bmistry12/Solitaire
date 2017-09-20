package cards;

public class Cards {
	private final Suit suit;
	private final Value value;
	public boolean isFaceUp = false;

	public Cards(Suit suit, Value value) {
		this.suit = suit;
		this.value = value;
	}
	
	public String getColour(){
		if (suit == Suit.CLUBS || suit == Suit.SPADES){
			return "BLACK";
		} else {
			return "RED";
		}
	}
	
	public Suit getSuit() {
		return suit;
	}

	public Value getValue() {
		return value;
	}
	
	public int valueToInt(Value cardValue){
		int value = 0;
		switch(cardValue){
		case ACE:
			value = 1;
			break;
		case EIGHT:
			value = 8;
			break;
		case FIVE:
			value = 5;
			break;
		case FOUR:
			value = 4;
			break;
		case JACK:
			value = 11;
			break;
		case KING:
			value = 13;
			break;
		case NINE:
			value = 9;
			break;
		case QUEEN:
			value = 12;
			break;
		case SEVEN:
			value = 7;
			break;
		case SIX:
			value = 6;
			break;
		case TEN:
			value = 10;
			break;
		case THREE:
			value = 3;
			break;
		case TWO:
			value = 2;
			break;
		default:
			System.err.println("There has been an error here");
			break;
			
		}
		return value;
	}

	public boolean isFaceUp() {
		return isFaceUp;
	}

	public void turnUp() {
		isFaceUp = true;
	}

	public void turnDown() {
		isFaceUp = false;
	}
	
	public String getFileName(Cards card){
		if(!card.isFaceUp){
			return "img/back.gif";
		} else {
			return getCardPath.getPath(card);
		}
	}
	
	public String toString() {
		return value + " of " + suit;
	}
}