import java.io.*;

public class Main {
    public static void main(String[] args) {

        WordList wordList = new WordList("WordList.txt");
        wordList.printWords();

        String sana = wordList.getRandomWord();
    }

}