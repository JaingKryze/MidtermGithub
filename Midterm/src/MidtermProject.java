// Jared Hofer  Midterm Project( BlackJack )
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class MidtermProject
	{
	static int playAgain = 1;
	static int hitOrPass;
	static String name;
	static int cash = 1000;
	static int bet;
	static int yourCardValueTotal;
	static int dealerCardValueTotal;
	static int lengthOfNumber;
	static String cardType;
	static int i;
	static String currentCard;
	static ArrayList<String> deck = new ArrayList<String>();
	static String[] listOfCards =
		{ "ace of diamonds", "king of diamonds", "queen of diamonds",
				"jack of diamonds", "ten of diamonds", "nine of diamonds",
				"eight of diamonds", "seven of diamonds", "six of diamonds",
				"five of diamonds", "four of diamonds", "three of diamonds",
				"two of diamonds", "ace of spades", "king of spades",
				"queen of spades", "jack of spades", "ten of spades",
				"nine of spades", "eight of spades", "seven of spades",
				"six of spades", "five of spades", "four of spades",
				"three of spades", "two of spades", "ace of clubs",
				"king of clubs", "queen of clubs", "jack of clubs",
				"ten of clubs", "nine of clubs", "eight of clubs",
				"seven of clubs", "six of clubs", "five of clubs",
				"four of clubs", "three of clubs", "two of clubs",
				"ace of hearts", "king of hearts", "queen of hearts",
				"jack of hearts", "ten of hearts", "nine of hearts",
				"eight of hearts", "seven of hearts", "six of hearts",
				"five of hearts", "four of hearts", "three of hearts",
				"two of hearts" };

	public static void main(String[] args)

		{
//		System.out.println("Welcome to the casino");
//		greetPlayer();
		while ((cash > 0) && (playAgain == 1) && (JPanelDemo.nameStatus == true))
			{
			System.out.println("Please place a bet on the hand. You have $"
					+ cash);
			Scanner userInput1 = new Scanner(System.in);
			bet = userInput1.nextInt();
			for (String cards : listOfCards)
				{
				deck.add(cards);
				}
			Collections.shuffle(deck);
			dealerCardValueTotal = 0;
			yourCardValueTotal = 0;
			for (i = 0; i < 2; i++)
				{
				dealYouACard();
				}
			dealDealerACard();
			dealDealerAnnotherCard();
			System.out.println("This gives you " + yourCardValueTotal
					+ " points");
			hitOrPass = 1;
			while ((hitOrPass == 1) && (yourCardValueTotal < 21))
				{
				System.out.println("Would you like to (1) hit or (2) pass?");
				Scanner userInput2 = new Scanner(System.in);
				hitOrPass = userInput2.nextInt();
				if (hitOrPass == 1)
					{
					dealYouACard();
					System.out.println("This gives you " + yourCardValueTotal
							+ " points");
					}
				// Cheat code to get an assure 21
				// Note: this does not assure a win if the dealer gets 21 as
				// well you will lose
				else if (hitOrPass == 3)
					{
					yourCardValueTotal = 21;
					System.out.println("This gives you " + yourCardValueTotal
							+ " points");
					}
				}
			System.out.println("The dealer has " + dealerCardValueTotal
					+ " points");
			while ((dealerCardValueTotal < 16) && (yourCardValueTotal < 22))
				{
				System.out
						.println("The dealer has a card hand with less than 16 points, he hits");
				dealDealerAnnotherCard();
				System.out.println("The dealer has " + dealerCardValueTotal
						+ " points");
				}
			if ((yourCardValueTotal > dealerCardValueTotal)
					&& (yourCardValueTotal < 22)
					|| ((dealerCardValueTotal > 21) && (yourCardValueTotal < 22)))
				{
				cash = cash + bet;
				System.out.println("You won. You now have $" + cash);
				} else
				{
				cash = cash - bet;
				System.out.println("You lost. You now have $" + cash);
				}
			if (cash > 0)
				{
				System.out
						.println("Would you like to play agian? (1) yes or (2) no");
				Scanner userInput3 = new Scanner(System.in);
				playAgain = userInput3.nextInt();
				}
			}
		if ((cash > 0) && (playAgain == 0))
			{
			System.out.println("You wisely decide to retire with $" + cash);
			} 
		else if (cash < 0)
			{
			System.out.println("You ran out of money you lose");
			}
		}

	public static int dealYouACard()
		{
		currentCard = deck.get(0);
		deck.remove(0);
		System.out.println("You got a " + currentCard);
		lengthOfNumber = currentCard.indexOf(" ");
		cardType = currentCard.substring(0, lengthOfNumber);
		switch (cardType)
			{
			case "ace":
				{
				yourCardValueTotal = yourCardValueTotal + 11;
				break;
				}
			case "two":
				{
				yourCardValueTotal = yourCardValueTotal + 2;
				break;
				}
			case "three":
				{
				yourCardValueTotal = yourCardValueTotal + 3;
				break;
				}
			case "four":
				{
				yourCardValueTotal = yourCardValueTotal + 4;
				break;
				}
			case "five":
				{
				yourCardValueTotal = yourCardValueTotal + 5;
				break;
				}
			case "six":
				{
				yourCardValueTotal = yourCardValueTotal + 6;
				break;
				}
			case "seven":
				{
				yourCardValueTotal = yourCardValueTotal + 7;
				break;
				}
			case "eight":
				{
				yourCardValueTotal = yourCardValueTotal + 8;
				break;
				}
			case "nine":
				{
				yourCardValueTotal = yourCardValueTotal + 9;
				break;
				}
			case "ten":
				{
				yourCardValueTotal = yourCardValueTotal + 10;
				break;
				}
			case "jack":
				{
				yourCardValueTotal = yourCardValueTotal + 10;
				break;
				}
			case "queen":
				{
				yourCardValueTotal = yourCardValueTotal + 10;
				break;
				}
			case "king":
				{
				yourCardValueTotal = yourCardValueTotal + 10;
				break;
				}
			}
		return yourCardValueTotal;
		}

	public static int dealDealerACard()
		{
		currentCard = deck.get(0);
		deck.remove(0);
		lengthOfNumber = currentCard.indexOf(" ");
		cardType = currentCard.substring(0, lengthOfNumber);
		switch (cardType)
			{
			case "ace":
				{
				dealerCardValueTotal = dealerCardValueTotal + 11;
				break;
				}
			case "two":
				{
				dealerCardValueTotal = dealerCardValueTotal + 2;
				break;
				}
			case "three":
				{
				dealerCardValueTotal = dealerCardValueTotal + 3;
				break;
				}
			case "four":
				{
				dealerCardValueTotal = dealerCardValueTotal + 4;
				break;
				}
			case "five":
				{
				dealerCardValueTotal = dealerCardValueTotal + 5;
				break;
				}
			case "six":
				{
				dealerCardValueTotal = dealerCardValueTotal + 6;
				break;
				}
			case "seven":
				{
				dealerCardValueTotal = dealerCardValueTotal + 7;
				break;
				}
			case "eight":
				{
				dealerCardValueTotal = dealerCardValueTotal + 8;
				break;
				}
			case "nine":
				{
				dealerCardValueTotal = dealerCardValueTotal + 9;
				break;
				}
			case "ten":
				{
				dealerCardValueTotal = dealerCardValueTotal + 10;
				break;
				}
			case "jack":
				{
				dealerCardValueTotal = dealerCardValueTotal + 10;
				break;
				}
			case "queen":
				{
				dealerCardValueTotal = dealerCardValueTotal + 10;
				break;
				}
			case "king":
				{
				dealerCardValueTotal = dealerCardValueTotal + 10;
				break;
				}
			}
		return dealerCardValueTotal;
		}

	public static int dealDealerAnnotherCard()
		{
		currentCard = deck.get(0);
		deck.remove(0);
		System.out.println("The dealer was dealt a " + currentCard);
		lengthOfNumber = currentCard.indexOf(" ");
		cardType = currentCard.substring(0, lengthOfNumber);
		switch (cardType)
			{
			case "ace":
				{
				dealerCardValueTotal = dealerCardValueTotal + 11;
				break;
				}
			case "two":
				{
				dealerCardValueTotal = dealerCardValueTotal + 2;
				break;
				}
			case "three":
				{
				dealerCardValueTotal = dealerCardValueTotal + 3;
				break;
				}
			case "four":
				{
				dealerCardValueTotal = dealerCardValueTotal + 4;
				break;
				}
			case "five":
				{
				dealerCardValueTotal = dealerCardValueTotal + 5;
				break;
				}
			case "six":
				{
				dealerCardValueTotal = dealerCardValueTotal + 6;
				break;
				}
			case "seven":
				{
				dealerCardValueTotal = dealerCardValueTotal + 7;
				break;
				}
			case "eight":
				{
				dealerCardValueTotal = dealerCardValueTotal + 8;
				break;
				}
			case "nine":
				{
				dealerCardValueTotal = dealerCardValueTotal + 9;
				break;
				}
			case "ten":
				{
				dealerCardValueTotal = dealerCardValueTotal + 10;
				break;
				}
			case "jack":
				{
				dealerCardValueTotal = dealerCardValueTotal + 10;
				break;
				}
			case "queen":
				{
				dealerCardValueTotal = dealerCardValueTotal + 10;
				break;
				}
			case "king":
				{
				dealerCardValueTotal = dealerCardValueTotal + 10;
				break;
				}
			}
		return dealerCardValueTotal;
		}

//	public static void greetPlayer()
//		{
//		System.out.println("What is your name?");
//		Scanner userInput1 = new Scanner(System.in);
//		name = userInput1.nextLine();
//		System.out.println("Hello, " + name
//				+ " you are going to play blackjack");
//		}
	}
