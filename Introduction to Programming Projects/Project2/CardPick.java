//Made by: Oskar Andersson
public class CardPick
{
  public static void main(String[] args)
  {
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
    while(true)
    {
      // shuffle
      for (int i = 0; i < n; i++) {
          int r = i + (int) (Math.random() * (n-i));
          String temp = deck[r];
          deck[r] = deck[i];
          deck[i] = temp;
      }

      int favNum = -1;
      //Get the favorite number between 1 and 27 from the player
      while(favNum < 1 || favNum > 27)
      {
        StdOut.print("\nYour favorite number between 1 and 27: ");
        favNum = StdIn.readInt();
        if(favNum < 1 || favNum > 27)
        {
          StdOut.println("That number was not a correct one, please try again.");
          StdOut.println();
        }
      }
      favNum--;
      //Convert the favorite number into base 3
      int favNum3 = toBase3(favNum);

      String[] pile1 = new String[9];
      String[] pile2 = new String[9];
      String[] pile3 = new String[9];
      int posInDeck = 0;
      //Place the deck into 3 piles
      for(int i = 0; i < 9; i++)
      {
        pile1[i] = deck[posInDeck];
        posInDeck++;
        pile2[i] = deck[posInDeck];
        posInDeck++;
        pile3[i] = deck[posInDeck];
        posInDeck++;
      }

      StdDraw.clear(StdDraw.GRAY);
      posInDeck = 0;
      //Draw the piles for the first time so that player can choose a card
      //and also choose the correct pile
      for(int i = 0; i < 9; i++)
      {
        //Pile 1
        StdDraw.picture(0.105*(i) + 0.08, (0.19*1.4)*3,
        "pngCards/"+pile1[i]+".png", 0.15, 0.15*1.4);
        //Pile 2
        StdDraw.picture(0.105*(i) + 0.08, (0.19*1.4)*2,
        "pngCards/"+pile2[i]+".png", 0.15, 0.15*1.4);
        //Pile 3
        StdDraw.picture(0.105*(i) + 0.08, 0.19*1.4,
        "pngCards/"+pile3[i]+".png", 0.15, 0.15*1.4);
      }

      //Do the pile selection 3 times
      for(int i = 2; i >= 0; i--)
      {
        int pileNum = -1;
        //Get a pile number from the player
        while(pileNum < 1 || pileNum > 3)
        {
          StdOut.print("In which pile is your card?(1-3): ");
          pileNum = StdIn.readInt();
          if(pileNum < 1 || pileNum > 3)
          {
            StdOut.println("That number was not a correct one, please try again.");
            StdOut.println();
          }
        }
        pileNum--;
        //Check where the selected pile should be placed
        int deckPlacement = numberInPos(favNum3, i);

        String[] chosenPile = new String[9];
        String[] bufferPile1 = new String[9];
        String[] bufferPile2 = new String[9];
        //Create some temporary piles and give them the correct piles
        switch(pileNum)
        {
          case 0:
            chosenPile = pile1;
            bufferPile1 = pile2;
            bufferPile2 = pile3;
          break;

          case 1:
            chosenPile = pile2;
            bufferPile1 = pile1;
            bufferPile2 = pile3;
          break;

          case 2:
            chosenPile = pile3;
            bufferPile1 = pile1;
            bufferPile2 = pile2;
          break;
        }

        //Place the piles in the correct order in the deck
        switch(deckPlacement)
        {
          case 0:
            for(int j = 0; j < 9; j++)
            {
              deck[j] = chosenPile[j];
              deck[j+9] = bufferPile1[j];
              deck[j+18] = bufferPile2[j];
            }
          break;

          case 1:
            for(int j = 0; j < 9; j++)
            {
              deck[j] = bufferPile1[j];
              deck[j+9] = chosenPile[j];
              deck[j+18] = bufferPile2[j];
            }
          break;

          case 2:
            for(int j = 0; j < 9; j++)
            {
              deck[j] = bufferPile1[j];
              deck[j+9] = bufferPile2[j];
              deck[j+18] = chosenPile[j];
            }
          break;
        }

        //Place the deck into 3 new piles
        posInDeck = 0;
        for(int j = 0; j < 9; j++)
        {
          pile1[j] = deck[posInDeck];
          posInDeck++;
          pile2[j] = deck[posInDeck];
          posInDeck++;
          pile3[j] = deck[posInDeck];
          posInDeck++;
        }

        //Draw the 3 piles
        StdDraw.clear(StdDraw.GRAY);
        posInDeck = 0;
        for(int j = 0; j < 9; j++)
        {
          //Pile 1
          StdDraw.picture(0.105*(j) + 0.08, (0.19*1.4)*3,
          "pngCards/"+pile1[j]+".png", 0.15, 0.15*1.4);
          //Pile 2
          StdDraw.picture(0.105*(j) + 0.08, (0.19*1.4)*2,
          "pngCards/"+pile2[j]+".png", 0.15, 0.15*1.4);
          //Pile 3
          StdDraw.picture(0.105*(j) + 0.08, 0.19*1.4,
          "pngCards/"+pile3[j]+".png", 0.15, 0.15*1.4);
        }
      }

      //Draw the deck as red jokers except on the correct card spot
      //With fancy placement
      posInDeck = 0;
      int horPos = 0;
      int verPos = 3;
      StdDraw.clear(StdDraw.GRAY);
      while(posInDeck <= toBase10(favNum3))
      {
        if(posInDeck == toBase10(favNum3))
        {
          StdDraw.picture(0.105*horPos + 0.08, 0.17+(verPos-1)*0.33,
          "pngCards/"+deck[posInDeck]+".png", 0.15, 0.15*1.4);
        }
        else
        {
          StdDraw.picture(0.105*horPos + 0.08, 0.17+(verPos-1)*0.33,
          "pngCards/red_joker.png", 0.15, 0.15*1.4);
        }
        posInDeck++;
        if(horPos == 8)
        {
          horPos = 0;
          verPos--;
        }
        else
        {
          horPos++;
        }
        StdDraw.pause(350);
      }
      //Without fancy placement
      // for (int k = 27/9; k > 0; k--)
      // {
      //     for (int j = 0; j < 9; j++)
      //   {
      //     if(posInDeck == toBase10(favNum3))
      //     {
      //       StdDraw.picture(0.105*(j) + 0.08, 0.17+(k-1)*0.33,
      //       "pngCards/"+deck[posInDeck]+".png", 0.15, 0.15*1.4);
      //     }
      //     else
      //     {
      //       StdDraw.picture(0.105*(j) + 0.08, 0.17+(k-1)*0.33,
      //       "pngCards/red_joker.png", 0.15, 0.15*1.4);
      //     }
      //     posInDeck++;
      //   }
      // }
    }
  }
  //Converts base 10 into base 3
  private static int toBase3(int num)
  {
    int num3 = 0;
    int factor = 1;
    while(num > 0)
    {
      num3 += num % 3*factor;
      num /= 3;
      factor *= 10;
    }
    return num3;
  }

  //Converts base 3 into base 10
  private static int toBase10(int num)
  {
    //Takes each digit by itself and does 3^i i=the position in the number
    //and multiplies it with the number
    String num3 = Integer.toString(num);
    char[] nums = num3.toCharArray();
    int curNum = 0;
    int num10 = 0;
    for(int i = 0; i < nums.length; i++)
    {
      curNum = Character.getNumericValue(nums[nums.length-1-i]);
      num10 += Math.pow(3,i)*curNum;
    }
    return num10;
  }

  //Gets the number at a specific index in a number(3 digits long only)
  private static int numberInPos(int num, int index)
  {
    //Convert the number into a string so that it can hold zeroes infront of it
    String snum = Integer.toString(num);
    //If the number is less than 3 digits long, add zeros infront of it
    while(snum.length() < 3)
    {
      snum = "0"+ snum;
    }
    //Convert the stringed number into an array
    char[] nums = snum.toCharArray();
    //Return the number at the requested index
    return Character.getNumericValue(nums[index]);
  }
}
