import java.sql.SQLOutput;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


public class Hangman {

    //***Attributes***//
    private int guesses = 5;
    private String word;
    private Scanner scanner = new Scanner(System.in);
    private List<Character> guessedCharacters = new ArrayList<>();
    private List<Character> correctCharacters = new ArrayList<>();

    //***Constructors***//
    public Hangman (WordList words){
        word = words.getRandomWord();
        startGame();
    }

    //***Methods***//

    public void startGame(){
        System.out.println("Welcome to the Hangman game!\n");

        while (!isGameOver()){
            System.out.println("You have " + getAmountOfGuesses() + " guesses left");
            System.out.println("The word to guess is: " + getMaskedWord());
            System.out.println("You have guessed characters: " + getGuessedCharacters());
            System.out.println("Correct characters are: " + getCorrectCharacters());
            System.out.println("Enter a letter: ");

            String userInput = scanner.nextLine();
            if (userInput.length() == 1 && Character.isLetter(userInput.charAt(0))) {
                guess(userInput.charAt(0));
            }else {
                System.out.println("Make sure your input is 1 letter, no special characters or numbers");
            }
        }

    }
    //Masks the word to guess for the user, ex: Java --> ****
    private String getMaskedWord() {
        StringBuilder mask = new StringBuilder();
        for (char letter : word.toCharArray()) {
            if (correctCharacters.contains(letter)) {
                mask.append(letter);
            } else {
                mask.append("*");
            }
        }
        return mask.toString();
    }
    //User guess, returns true if the guess is correct, else false
    public boolean guess(Character c){
        c = Character.toLowerCase(c);

        if (!guessedCharacters.contains(c)){
            guessedCharacters.add(c);
        }

        if (word.contains(Character.toString(c))){
            return true;
        }else{
            guesses--;
            return false;
        }
    }

    private boolean isGameOver(){
        //|| maskedWord.equalsIgnoreCase(word)
        if (guesses <= 0 ){
            return true;
        }
        return false;
    }

    public int getAmountOfGuesses() {
        return guesses;
    }

    public List<Character> getGuessedCharacters() {
        return guessedCharacters;
    }

    public List<Character> getCorrectCharacters() {
        return correctCharacters;
    }

}
