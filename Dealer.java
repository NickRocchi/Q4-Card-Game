/**
 * This is a class that tests the Deck class.
 */
public class Dealer {
    /**
     * The main method in this class checks the Deck operations for consistency.
     *  @param args is not used.
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
        System.out.println("  split: " + d.split());
        System.out.println("  the decks:\n" + d.toString());
        System.out.println("  isEmpty: " + d.isEmpty());
        System.out.println();
        System.out.println();
        
        d.shuffle();
        d.shuffle();
        
        d.winCondition();
            while (d.gameOver == false){
            d.winCondition();
            System.out.println("two sizes: \n size of your deck:" + size() +
            System.out.println("new round: \n " + d.putInPlay());
            System.out.println("\n \n Now FIGHT: " + d.play());
            System.out.println("your new hands! \n" + "Player! \n" + d.playerHand() + "\n and computer! \n" + d.cpuHand());
            System.out.println();
            System.out.println();
        }
          
    }
}
