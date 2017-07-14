package solitare;

import java.util.Scanner;
import java.util.Stack;

import cards.Cards;

public class Main {
	Scanner scanner = new Scanner(System.in);
	
	public Main(SolitareRules solitare){
		inputChoice(optionPrint(), solitare);
	}
	
	public String optionPrint(){
		System.out.println("D - Deal New Card \n"
				+ "M - Move A Cards Position \n Q- Quit");
		return scanner.nextLine();
	}
	
	public void inputChoice(String choice, SolitareRules solitare){
		switch (choice) {
			case "D":
				//deal a new card from waste pile
				solitare.dealCard();
				break;
			case "M":
				System.out.println("Enter pile number of card to move");
				String toMove = scanner.nextLine();
				System.out.println("Enter pile number where to move card");
				String toPile = scanner.nextLine();
				Cards card = getCard(toMove, solitare);
				Stack<Cards> stacktoAdd = getStack(toPile, solitare);
				Stack<Cards> stackToRemFrom = getStack(toMove, solitare);
				solitare.addCardToStack(card, stacktoAdd);
				//ONLY DO THIS IF MOVE IS VALID
				stackToRemFrom.pop();
				stackToRemFrom.peek().turnUp();
				break;
			case "Q":
				System.out.println("Game Ended");
				System.exit(0);
				break;
			default:
				break;
		}
	}
	
	private Stack<Cards> getStack(String string, SolitareRules solitare) {
		// int
		Stack<Cards> toStack = null;
		if(string.equals("1")){
			toStack = solitare.col1;
		} else if(string.equals("2")){
			toStack = solitare.col2;
		} else if(string.equals("3")){
			toStack = solitare.col3;
		} else if(string.equals("4")){
			toStack = solitare.col4;
		} else if(string.equals("5")){
			toStack = solitare.col5;
		} else if(string.equals("6")){
			toStack = solitare.col6;
		}else if(string.equals("7")){
			toStack = solitare.col7;
		}
		return toStack;
	}

	private Cards getCard(String string, SolitareRules solitare) {
		//either be integer of stack or dealt card
		Cards moveCard = null;
		if(string.equals("1")){
			moveCard = solitare.col1.peek();
		} else if(string.equals("2")){
			moveCard = solitare.col2.peek();
		} else if(string.equals("3")){
			moveCard = solitare.col3.peek();
		} else if(string.equals("4")){
			moveCard = solitare.col4.peek();
		} else if(string.equals("5")){
			moveCard = solitare.col5.peek();
		} else if(string.equals("6")){
			moveCard = solitare.col6.peek();
		} else if(string.equals("7")){
			moveCard = solitare.col7.peek();
		} else if(string.equals("D")){
			moveCard = solitare.wasteDeck.getTopOfDeck();
		}
		return moveCard;		
	}

	public static void main (String[] args){
		SolitareRules solitare = new SolitareRules();
		System.out.println("this is the start state of the game");
		while (true){
			new Main(solitare);
			solitare.printCurrentCol();
		}
	}
}
