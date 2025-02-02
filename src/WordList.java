import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordList {

    private List<String> words = new ArrayList<>();

    public WordList (String filename){
    String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null){
                words.add(line.toLowerCase());
            }
        } catch(FileNotFoundException e){
            System.out.println("Error: File not found");
        } catch (IOException e){
            System.out.println("IOException Error");
        }
    }

    //Get a random word from the list
    public String getRandomWord(){
        Random rand = new Random();
        return words.get(rand.nextInt(0, words.size()));
    }

    //returns all the words in the list
    public List<String> getWords (){
        return this.words;
    }

    public void printWords (){
        int i  = 1;
        for (String sana : words){
            System.out.println(i + ". " + sana);
            i++;
        }
    }
}
