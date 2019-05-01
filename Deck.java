import java.util.List;
import java.util.ArrayList;

/**
 * The Deck class represents a shuffled deck of cards.
 * It provides several operations including
 *      initialize, shuffle, deal, and check if empty.
 */
public class Deck {

	/**
	 * cards contains all the cards in the deck.
	 */
	private ArrayList<Card> cards;
	private ArrayList<Card> cards2;
	private ArrayList<Card> inPlay;
	boolean win;

	/**
	 * size is the number of not-yet-dealt cards.
	 * Cards are dealt from the top (highest index) down.
	 * The next card to be dealt is at size - 1.
	 */
	private int size, size2;


	/**
	 * Creates a new <code>Deck</code> instance.<BR>
	 * It pairs each element of ranks with each element of suits,
	 * and produces one of the corresponding card.
	 * @param ranks is an array containing all of the card ranks.
	 * @param suits is an array containing all of the card suits.
	 * @param values is an array containing all of the card point values.
	 */
	public Deck(String[] ranks, String[] suits, int[] values) {
		cards = new ArrayList<Card>();
		cards2 = new ArrayList<Card>();
		inPlay = new ArrayList<Card>();
		for (int j = 0; j < ranks.length; j++) {
			for (String suitString : suits) {
				cards.add(new Card(ranks[j], suitString, values[j]));
			}
		}
		size = cards.size();
		size2 = cards2.size();
		shuffle();
	}


	/**
	 * Determines if this deck is empty (no undealt cards).
	 * @return true if this deck is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Accesses the number of undealt cards in this deck.
	 * @return the number of undealt cards in this deck.
	 */
	public int size() {
		return size;
	}

	/**
	 * Randomly permute the given collection of cards
	 * and reset the size to represent the entire deck.
	 */
	public void shuffle() {
		for (int k = cards.size() - 1; k > 0; k--) {
			int howMany = k + 1;
			int start = 0;
			int randPos = (int) (Math.random() * howMany) + start;
			Card temp = cards.get(k);
			cards.set(k, cards.get(randPos));
			cards.set(randPos, temp);
		}
		size = cards.size();
	}

	/**
	 * Deals a card from this deck.
	 * @return the card just dealt, or null if all the cards have been
	 *         previously dealt.
	 */
	public Card deal() {
		if (isEmpty()) {
			return null;
		}
		size--;
		Card c = cards.get(size);
		return c;
	}

	/**
	 * Deals a card from this deck.
	 * @return the card just dealt, or null if all the cards have been
	 *         previously dealt.
	 */
	public List<Card> split(){
            if (isEmpty()){
                return null;
            }
            for(int i = 0; i < size/2; i++){
                cards2.add(cards.get(i));
                cards.remove(i);
            }
            size = cards.size();
            size2 = cards2.size();
            return cards2;
        }

	public ArrayList<Card> putInPlay(){
	    if(size >= 0 && size2 >= 0){
	       inPlay.add(cards.get(0));
	       inPlay.add(cards2.get(0));
	       cards.remove(0);
	       cards2.remove(0);
	       size = cards.size();
	       size2 = cards2.size();
	   }
	   return inPlay;
	}
	
	public String play(){
	   String winner = "";
	    if (inPlay.get(0).pointValue() < inPlay.get(1).pointValue()){
	    winner = "PLAYER'S HAND";
	    win = true;
	   } else {
	    winner = "CPU'S HAND";
	    win = false;
	   }
	   return winner;
	}
	
	public ArrayList<Card> playerHand(){
	    if (win = true){
	        cards.add(0, inPlay.get(0));
	        cards.add(0, inPlay.get(1));
	        inPlay.remove(0);
	    }
	    size = cards.size();
	    return cards;
	}
	
	public ArrayList<Card> cpuHand(){
	    if (win = false){
	        cards2.add(0, inPlay.get(0));
	        cards2.add(0, inPlay.get(1));
	        inPlay.remove(1);
	        inPlay.remove(0);
	    }
	    size2 = cards2.size();
	    return cards2;
	}
        
	/**
	 * Generates and returns a string representation of this deck.
	 * @return a string representation of this deck.
	 */
	@Override
        public String toString() {
		String rtn = "size = " + size + "\nDeck for player 1: \n";

		for (int k = size - 1; k >= 0; k--) {
			rtn = rtn + cards.get(k);
			if (k != 0) {
				rtn = rtn + ", ";
			}
			if ((size - k) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\nDeck for player 2: \n";
		for (int k = cards2.size() - 1; k >= 0; k--) {
			rtn = rtn + cards2.get(k);
			if (k != cards2.size()) {
				rtn = rtn + ", ";
			}
			if ((k - cards2.size()) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
		 	}
		}

		rtn = rtn + "\n";
		return rtn;
	}
}
