//Made by Oskar Andersson
public class DeckDeal{
    public static void main(String[] args) {
        String[] SUITS = {
            "Clubs", "Diamonds", "Hearts", "Spades"
        };

        String[] RANKS = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Jack", "Queen", "King", "Ace"
        };

        // initialize deck
        int n = SUITS.length * RANKS.length;
        String[] deck = new String[n];
        for (int i = 0; i < RANKS.length; i++) {
            for (int j = 0; j < SUITS.length; j++) {
                deck[SUITS.length*i + j] = RANKS[i] + "_of_" + SUITS[j];
            }
        }

        // shuffle
        for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n-i));
            String temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
        }

        // Draw shuffled deck
        /*int posInDeck = 0;
        for (int i = SUITS.length; i > 0; i--)
        {
            for (int j = 0; j < RANKS.length; j++)
          {
            StdDraw.picture(0.066*(j) + 0.1, 0.1*1.4+0.25*(i-1),
            "pngCards/"+deck[posInDeck]+".png", 0.15, 0.15*1.4);
            System.out.println(deck[posInDeck]);
            posInDeck++;
          }
        }*/

        int posInDeck = 0;
        StdDraw.clear(StdDraw.GRAY);
        for(int i = 4; i > 0; i--)
        {
          for(int j = 0; j < 5; j++)
          {
            StdDraw.picture(0.1*(j) + 0.1, 0.1*1.4+0.25*(i-1),
            "pngCards/"+deck[posInDeck]+".png", 0.15, 0.15*1.4);
            posInDeck++;
          }
        }
    }
}
