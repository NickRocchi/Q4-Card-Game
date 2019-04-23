/**
 * This is a class that tests the Deck class.
 */
public class Dealer {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		// Note: Student solutions will vary.  The following is an example.

		String[] ranks = {"2","3","4","5","6","7","8","9","10","jack", "queen", "king","ace"};
		String[] suits = {"diamonds", "hearts","clubs","spades"};
		int[] pointValues = {2,3,4,5,6,7,8,9,10,11, 12,13,14};
		Deck d = new Deck(ranks, suits, pointValues);

		System.out.println("**** Original Deck Methods ****");
		System.out.println("  toString:\n" + d.toString());
		System.out.println("  isEmpty: " + d.isEmpty());
		System.out.println("  size: " + d.size());
		System.out.println();
		System.out.println();

		System.out.println("**** Split the Deck ****");
		System.out.println("  deal: " + d.split());
		System.out.println("  toString:\n" + d.toString());
		System.out.println("  isEmpty: " + d.isEmpty());
		System.out.println();
		System.out.println();
	}
}
