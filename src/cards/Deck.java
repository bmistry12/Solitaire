package cards;
import java.util.Random;

public class Deck {
	private Cards cards[];
	private Suit suits[];
	private Value values[];
	private int deckSize = 0;
	
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
	
	public void printDeck(){
		int counter = 0; 
		for (int i = 0; i < suits.length; i++){
			for (int j = 0; j < values.length; j++){
				System.out.println(cards[counter]);
				counter++;
			}
		}
	}
	
	public int getDeckSize(){
		return deckSize;
	}
	
	public Cards getTopOfDeck(){
		return cards[deckSize-1];
	}
	
	public Cards removeTopOfDeck(){
		return cards[(deckSize--)-1];
	}
	
	public void shuffleDeck(){
		System.out.println("everyday im shuffling");
		Random rand= new Random();
		for (int i = 0; i < 52; i++){
			int indexCard1 = rand.nextInt(deckSize-1);
			int indexCard2 = rand.nextInt(deckSize-1);
			Cards tempCard = cards[indexCard1];
			cards[indexCard1] = cards[indexCard2];
			cards[indexCard2] = tempCard;
		}				
	}
	
	public void increaseDeckSize(){
		deckSize++;
	}

	public void addCard(Cards temp) {
		cards[deckSize+1] = temp;	
	}
}
