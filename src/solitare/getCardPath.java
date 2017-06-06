package solitare;

import cards.Cards;

public class getCardPath {
	public static String getPath (Cards newcard){
		String cardPath = "";
		switch (newcard.getValue()) {
		case ACE:
			switch (newcard.getSuit()) {
			case DIAMONDS:
				cardPath = "img/d1.JPG";
				break;
			case HEARTS:
				cardPath = "img/h1.JPG";
				break;
			case CLUBS:
				cardPath = "img/c1.JPG";
				break;
			case SPADES:
				cardPath = "img/s1.JPG";
				break;
			}
			break;
		case TWO:
			switch (newcard.getSuit()) {
			case DIAMONDS:
				cardPath = "img/d2.JPG";
				break;
			case HEARTS:
				cardPath = "img/h2.JPG";
				break;
			case CLUBS:
				cardPath = "img/c2.JPG";
				break;
			case SPADES:
				cardPath = "img/s2.JPG";
				break;
			}
			break;
		case THREE:
			switch (newcard.getSuit()) {
			case DIAMONDS:
				cardPath = "img/d3.JPG";
				break;
			case HEARTS:
				cardPath = "img/h3.JPG";
				break;
			case CLUBS:
				cardPath = "img/c3.JPG";
				break;
			case SPADES:
				cardPath = "img/s3.JPG";
				break;
			}
			break;
		case FOUR:
			switch (newcard.getSuit()) {
			case DIAMONDS:
				cardPath = "img/d4.JPG";
				break;
			case HEARTS:
				cardPath = "img/h4.JPG";
				break;
			case CLUBS:
				cardPath = "img/c4.JPG";
				break;
			case SPADES:
				cardPath = "img/s4.JPG";
				break;
			}
			break;
		case FIVE:
			switch (newcard.getSuit()) {
			case DIAMONDS:
				cardPath = "img/d5.JPG";
				break;
			case HEARTS:
				cardPath = "img/h5.JPG";
				break;
			case CLUBS:
				cardPath = "img/c5.JPG";
				break;
			case SPADES:
				cardPath = "img/s5.JPG";
				break;
			}
			break;
		case SIX:
			switch (newcard.getSuit()) {
			case DIAMONDS:
				cardPath = "img/d6.JPG";
				break;
			case HEARTS:
				cardPath = "img/h6.JPG";
				break;
			case CLUBS:
				cardPath = "img/c6.JPG";
				break;
			case SPADES:
				cardPath = "img/s6.JPG";
				break;
			}
			break;
		case SEVEN:
			switch (newcard.getSuit()) {
			case DIAMONDS:
				cardPath = "img/d7.JPG";
				break;
			case HEARTS:
				cardPath = "img/h7.JPG";
				break;
			case CLUBS:
				cardPath = "img/c7.JPG";
				break;
			case SPADES:
				cardPath = "img/s7.JPG";
				break;
			}
			break;
		case EIGHT:
			switch (newcard.getSuit()) {
			case DIAMONDS:
				cardPath = "img/d8.JPG";
				break;
			case HEARTS:
				cardPath = "img/h8.JPG";
				break;
			case CLUBS:
				cardPath = "img/c8.JPG";
				break;
			case SPADES:
				cardPath = "img/s8.JPG";
				break;
			}
			break;
		case NINE:
			switch (newcard.getSuit()) {
			case DIAMONDS:
				cardPath = "img/d9.JPG";
				break;
			case HEARTS:
				cardPath = "img/h9.JPG";
				break;
			case CLUBS:
				cardPath = "img/c9.JPG";
				break;
			case SPADES:
				cardPath = "img/s9.JPG";
				break;
			}
			break;
		case TEN:
			switch (newcard.getSuit()) {
			case DIAMONDS:
				cardPath = "img/d10.JPG";
				break;
			case HEARTS:
				cardPath = "img/h10.JPG";
				break;
			case CLUBS:
				cardPath = "img/c10.JPG";
				break;
			case SPADES:
				cardPath = "img/s10.JPG";
				break;
			}
			break;
		case JACK:
			switch (newcard.getSuit()) {
			case DIAMONDS:
				cardPath = "img/dJ.JPG";
				break;
			case HEARTS:
				cardPath = "img/hJ.JPG";
				break;
			case CLUBS:
				cardPath = "img/cJ.JPG";
				break;
			case SPADES:
				cardPath = "img/sJ.JPG";
				break;
			}
			break;
		case QUEEN:
			switch (newcard.getSuit()) {
			case DIAMONDS:
				cardPath = "img/dQ.JPG";
				break;
			case HEARTS:
				cardPath = "img/hQ.JPG";
				break;
			case CLUBS:
				cardPath = "img/cQ.JPG";
				break;
			case SPADES:
				cardPath = "img/sQ.JPG";
				break;
			}
			break;
		case KING:
			switch (newcard.getSuit()) {
			case DIAMONDS:
				cardPath = "img/dK.JPG";
				break;
			case HEARTS:
				cardPath = "img/hK.JPG";
				break;
			case CLUBS:
				cardPath = "img/cK.JPG";
				break;
			case SPADES:
				cardPath = "img/sK.JPG";
				break;
			}
			break;
		}
		return cardPath;
	}
}
