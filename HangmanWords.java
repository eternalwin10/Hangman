
public class HangmanWords {
	//declaration
	String [] words = { "HIGHSCHOOL", "GOVERNMENT", "CONTINENTS", "PROFESSORS", "PROGRAMMER", "DEALERSHIP", "CONTROLLER", "MOTORCYCLE", "LIGHTSABER"}; 
	String originalWord = null, guessThisWord, hiddenLetter, newHiddenWord, playerChoice, usedLetters, playerOption;
	char playerLetter;
	int guesses = 6; //amount of guesses user starts with
	
	//methods
	public void randomizeWords() {
		//randomize the words
		for (int i = words.length - 1; i > 0; i--) {
			//generate a random index
			int j = (int)(Math.random() * (i + 1));
			
			//swaps list i with list j
			String temp = words[i];
			words[i] = words[j];
			words[j] = temp;
		}
	}
	
	public  String getNextWord () { //gets the next random word
	    for (int i = 0; i < words.length; i++) {
	        
            if (words[i] != null) {
	            String temp = words[i];
	            words[i] = null;
	            return temp;
	        }
	    }
		return null;
        
    }

//hides the randomly picked word from the player 
	public String hideWord () { 
		originalWord = new String(guessThisWord); // keeps original word 
		guessThisWord = guessThisWord.replaceAll(".", "_"); // hides the word from player
	
		return guessThisWord;
}

public int checkLetter() { //checks to see if letter was guessed
	newHiddenWord = "";
	int returnValue = -1; 
	
	if (playerLetter < 'A' || playerLetter > 'Z') {	//checks if player guess is valid
		return 0;
	}
	
	if (usedLetters.indexOf(playerLetter) != -1) {
		return 2;
	}
	usedLetters = usedLetters + playerLetter;
	for (int i = 0; i < originalWord.length(); i++) {
		 
		if (originalWord.charAt(i) == playerLetter) { 
				newHiddenWord = newHiddenWord + playerLetter;
				returnValue = 1;
		}
		else {
				newHiddenWord = newHiddenWord + guessThisWord.charAt(i);
		}
	}
	guessThisWord = newHiddenWord;
	return returnValue; 
	
	}}