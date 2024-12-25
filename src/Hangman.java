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


    /**
     * Start the game and loop while the game is not over
     * after game ends check if the user won or lost
     */
    public void startGame(){
        System.out.println("Welcome to the Hangman game!\n");

        while (!isGameOver()){
            System.out.println("You have " + getAmountOfGuesses() + " guesses left");
            System.out.println("The word to guess is: " + getMaskedWord());
            System.out.println("You have guessed characters: " + getGuessedCharacters());
            System.out.println("Enter a letter: ");

            String userInput = scanner.nextLine();
            if (userInput.length() == 1 && Character.isLetter(userInput.charAt(0))) {
                guess(userInput.charAt(0));
            }else {
                System.out.println("Make sure your input is 1 letter, no special characters or numbers");
            }

            if (isGameWon()){
                System.out.println("Congratulations, you won!!");
                System.out.println("The hidden word was: " + word);
            }else{
                System.out.println("Sorry, you lost!");
                System.out.println("The hidden word was: " + word);
            }
        }

    }

    /**
     * Masks the word with * for the user. EX. java --> ****
     * @return the masked word in String format
     */
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

    /**
     * Checks the guessed character and if the guess from user is correct, add it to correctCharacters list
     * @param c the guess of the user
     * @return true if answer is correct, false if not
     */
    private boolean guess(Character c){
        c = Character.toLowerCase(c);

        if (!guessedCharacters.contains(c)){
            guessedCharacters.add(c);
        }

        if (word.contains(Character.toString(c))){
            correctCharacters.add(c);
            return true;
        }else{
            guesses--;
            return false;
        }
    }

    /**
     *
     * @return true if user has used all guesses or guessed the word correctly
     */
    private boolean isGameOver(){
        if (guesses <= 0){
            return true;
        }

        for (char letter : word.toCharArray()){
            if (!correctCharacters.contains(letter)){
                return false;
            }
        }
        return true;
    }

    public int getAmountOfGuesses() {
        return guesses;
    }

    public List<Character> getGuessedCharacters() {
        return guessedCharacters;
    }

    /**
     *
     * @return true if game is won, else false
     */
    private boolean isGameWon(){

        for (char letter : word.toCharArray()){
            if (!correctCharacters.contains(letter)){
                return false;
            }
        }
        return true;
    }


}
