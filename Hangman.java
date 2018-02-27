import java.util.Scanner;

public class Hangman {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in); //create a scanner 
		
		int wins = 0, losses = 0; //declares the wins and losses for player 
		HangmanWords g = new HangmanWords(); //reference to second class
		
		System.out.println("Welcome to Hangman!"); //opening  game

	do {
			g.usedLetters = ""; //players already used letters
			g.guesses = 6; //players guesses
			g.randomizeWords(); //randomly generates a word from the word list
			
				//players first word
			g.guessThisWord = g.getNextWord();
			g.guessThisWord = g.hideWord();//hides the word with _
			
			System.out.println("Here is your first word " + g.guessThisWord);//shows player the hidden word to guess
			System.out.println("You have: " + g.guesses + " guesses");
		do {
			System.out.println("Used letters: " + g.usedLetters);
			
			System.out.println("Enter a letter: "); //asks player for first guess
			g.playerChoice = s.next().toUpperCase(); //player input
			g.playerLetter = g.playerChoice.charAt(0); //assigns string to player's letter
			
	switch (g.checkLetter()) { //checks the players guess
			case -1:	//if player is wrong
					System.out.println(g.guessThisWord);
					System.out.println("Wrong!");
					g.guesses--;// if player is wrong they lose a guess
					System.out.println("Guesses Left: " + g.guesses);
					break;
			case 0: //if player response isn't valid
					System.out.println("Invalid Response! - Try again");
					break;			
				
				case 1: // if player is correct
					System.out.println("Correct!");
					break;
				case 2: //if player repeats a guess
					System.out.println("Letter already used - Try again");
					break;
				
			}
			System.out.println(g.guessThisWord);
			
		if (g.guessThisWord.equals(g.originalWord)) { //checks if guess is correct
				g.guesses = -1;
			}
			
		}	while (g.guesses > 0); //loops while player still has guesses left over
			
		if (g.guesses == -1) { //checks if player guessed the whole word
				System.out.println("You Won!");
				wins++; //adds to total wins
			}
		else {
				System.out.println("You lose!"); //checks if player didn't guess the word in time
				losses++; //adds to total losses
			}
		System.out.println("Wins: " + wins); //prints out total wins
		System.out.println("Losses: " + losses); // prints out total losses
			System.out.println("Do you wish to play again?"); //asks player to play again
			g.playerOption = s.next().toUpperCase(); //players next guess
		}
		while (g.playerOption.equals("YES"));
		System.out.println("Thanks for playing!"); //ends game
	
		s.close(); //closes the scanner
	}
} 