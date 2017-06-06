package cards;

public class Cards {
	private final Suit suit;
	private final Value value;
	public boolean isFaceUp = false;

	public Cards(Suit suit, Value value) {
		this.suit = suit;
		this.value = value;
	}

	public Suit getSuit() {
		return suit;
	}

	public Value getValue() {
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

	public String toString() {
		return value + " of " + suit;
	}
}