package cards;
import cards.Cards;

public class getCardPath {
	public static String getPath (Cards newcard){
		String cardPath = "";
		switch (newcard.getValue()) {
		case ACE:
			switch (newcard.getSuit()) {
			case DIAMONDS:
				cardPath = "img/d1.gif";
				break;
			case HEARTS:
				cardPath = "img/h1.gif";
				break;
			case CLUBS:
				cardPath = "img/c1.gif";
				break;
			case SPADES:
				cardPath = "img/s1.gif";
				break;
			}
			break;
		case TWO:
			switch (newcard.getSuit()) {
			case DIAMONDS:
				cardPath = "img/d2.gif";
				break;
			case HEARTS:
				cardPath = "img/h2.gif";
				break;
			case CLUBS:
				cardPath = "img/c2.gif";
				break;
			case SPADES:
				cardPath = "img/s2.gif";
				break;
			}
			break;
		case THREE:
			switch (newcard.getSuit()) {
			case DIAMONDS:
				cardPath = "img/d3.gif";
				break;
			case HEARTS:
				cardPath = "img/h3.gif";
				break;
			case CLUBS:
				cardPath = "img/c3.gif";
				break;
			case SPADES:
				cardPath = "img/s3.gif";
				break;
			}
			break;
		case FOUR:
			switch (newcard.getSuit()) {
			case DIAMONDS:
				cardPath = "img/d4.gif";
				break;
			case HEARTS:
				cardPath = "img/h4.gif";
				break;
			case CLUBS:
				cardPath = "img/c4.gif";
				break;
			case SPADES:
				cardPath = "img/s4.gif";
				break;
			}
			break;
		case FIVE:
			switch (newcard.getSuit()) {
			case DIAMONDS:
				cardPath = "img/d5.gif";
				break;
			case HEARTS:
				cardPath = "img/h5.gif";
				break;
			case CLUBS:
				cardPath = "img/c5.gif";
				break;
			case SPADES:
				cardPath = "img/s5.gif";
				break;
			}
			break;
		case SIX:
			switch (newcard.getSuit()) {
			case DIAMONDS:
				cardPath = "img/d6.gif";
				break;
			case HEARTS:
				cardPath = "img/h6.gif";
				break;
			case CLUBS:
				cardPath = "img/c6.gif";
				break;
			case SPADES:
				cardPath = "img/s6.gif";
				break;
			}
			break;
		case SEVEN:
			switch (newcard.getSuit()) {
			case DIAMONDS:
				cardPath = "img/d7.gif";
				break;
			case HEARTS:
				cardPath = "img/h7.gif";
				break;
			case CLUBS:
				cardPath = "img/c7.gif";
				break;
			case SPADES:
				cardPath = "img/s7.gif";
				break;
			}
			break;
		case EIGHT:
			switch (newcard.getSuit()) {
			case DIAMONDS:
				cardPath = "img/d8.gif";
				break;
			case HEARTS:
				cardPath = "img/h8.gif";
				break;
			case CLUBS:
				cardPath = "img/c8.gif";
				break;
			case SPADES:
				cardPath = "img/s8.gif";
				break;
			}
			break;
		case NINE:
			switch (newcard.getSuit()) {
			case DIAMONDS:
				cardPath = "img/d9.gif";
				break;
			case HEARTS:
				cardPath = "img/h9.gif";
				break;
			case CLUBS:
				cardPath = "img/c9.gif";
				break;
			case SPADES:
				cardPath = "img/s9.gif";
				break;
			}
			break;
		case TEN:
			switch (newcard.getSuit()) {
			case DIAMONDS:
				cardPath = "img/td.gif";
				break;
			case HEARTS:
				cardPath = "img/th.gif";
				break;
			case CLUBS:
				cardPath = "img/tc.gif";
				break;
			case SPADES:
				cardPath = "img/ts.gif";
				break;
			}
			break;
		case JACK:
			switch (newcard.getSuit()) {
			case DIAMONDS:
				cardPath = "img/jd.gif";
				break;
			case HEARTS:
				cardPath = "img/jh.gif";
				break;
			case CLUBS:
				cardPath = "img/jc.gif";
				break;
			case SPADES:
				cardPath = "img/js.gif";
				break;
			}
			break;
		case QUEEN:
			switch (newcard.getSuit()) {
			case DIAMONDS:
				cardPath = "img/qd.gif";
				break;
			case HEARTS:
				cardPath = "img/qh.gif";
				break;
			case CLUBS:
				cardPath = "img/qc.gif";
				break;
			case SPADES:
				cardPath = "img/qs.gif";
				break;
			}
			break;
		case KING:
			switch (newcard.getSuit()) {
			case DIAMONDS:
				cardPath = "img/kd.gif";
				break;
			case HEARTS:
				cardPath = "img/kh.gif";
				break;
			case CLUBS:
				cardPath = "img/kc.gif";
				break;
			case SPADES:
				cardPath = "img/ks.gif";
				break;
			}
			break;
		}
		return cardPath;
	}
}