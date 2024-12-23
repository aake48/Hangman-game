import java.util.List;
import java.util.ArrayList;


public class Hangman {

    private int guesses = 5;
    private List<Character> guessedCharacters = new ArrayList<>();
    private List<Character> correctCharacters = new ArrayList<>();

    public Hangman (String filename){
        WordList wordList = new WordList(filename);

    }


}
