import java.io.*;

public class Main {
    public static void main(String[] args) {

        WordList wordList = new WordList("WordList.txt");
        Hangman hangman = new Hangman(wordList);


    }

}