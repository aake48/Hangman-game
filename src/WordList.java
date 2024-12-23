import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WordList {

    private List<String> words = new ArrayList<>();

    public WordList (String filename){
    String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null){
                words.add(line);
            }
        } catch(FileNotFoundException e){
            System.out.println("Error: File not found");
        } catch (IOException e){
            System.out.println("IOException Error");
        }
    }


    public String getRandomWord(String filename){
        String randomWord = "";

        return randomWord;
    }

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
