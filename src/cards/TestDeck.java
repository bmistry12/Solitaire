package cards;

import oldSolitare.SolitareRules;

public class TestDeck {
	public static void main(String[] args){
		Deck newDeck = new Deck();
		newDeck.printDeck();
		newDeck.getTopOfDeck();
		System.out.println(newDeck.getDeckSize());
		newDeck.getTopOfDeck();
		newDeck.removeTopOfDeck();
		System.out.println(newDeck.getDeckSize());
		newDeck.getTopOfDeck();
		
		System.out.println("---------");
		newDeck.shuffleDeck();
		System.out.println(newDeck.getDeckSize());
		newDeck.getTopOfDeck();
		System.out.println("print shuffled deck");
		newDeck.printDeck();
		
		SolitareRules rules = new SolitareRules();
	}

}
