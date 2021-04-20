import java.util.HashSet;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Dictionary {
    private HashSet<String> dictionary= new HashSet<String>();

    public void createDictionary() throws IOException {
        try {
            URL appAcademyDictionary = new URL("https://assets.aaonline.io/fullstack/ruby/projects/ghost/dictionary.txt");
            Scanner sc = new Scanner(appAcademyDictionary.openStream());
            while (sc.hasNext()) {
                dictionary.add(sc.next());
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public HashSet<String> getDictionary() {
        return this.dictionary;
    }

    public static void main(String[] args) {
        Dictionary allWords = new Dictionary();
        try {
            allWords.createDictionary();
        } catch(IOException ex) {
            ex.printStackTrace();
        }

        System.out.println(allWords.getDictionary());
    }
}


