//Made by Oskar Andersson
public class DeckValue{
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

        int posInDeck = 0;
        StdDraw.clear(StdDraw.GRAY);
        for (int i = 0; i < RANKS.length; i++)
        {
            for (int j = 0; j < SUITS.length; j++)
          {
            StdDraw.picture(0.066*j + 0.05, 0.03*1.4+0.076*i,
            "pngCards/"+deck[posInDeck]+".png", 0.06, 0.06*1.4);
            posInDeck++;
          }
        }
    }
}
