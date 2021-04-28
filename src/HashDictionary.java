import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Scanner;


public class HashDictionary implements Dictionaries {
    private HashSet<String> allWords = new HashSet<String>();

    public void createDictionary() {
        try {
            URL appAcademyDictionary =
                    new URL("https://assets.aaonline.io/fullstack/ruby/projects/ghost/dictionary.txt");
            Scanner sc = new Scanner(appAcademyDictionary.openStream());
            while (sc.hasNext()) {
                addPartialWords(sc.next());
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public boolean partialWordExists(String partialWord) {
        return false;
    }

    public void addPartialWords(String word) {
        StringBuilder growingWord = new StringBuilder();

        int i = 0;
        while (i <= word.length() - 1) {
            growingWord.append(word.charAt(i));
            allWords.add(growingWord.toString());

            i++;
        }
    }

    public HashSet getDictionary() {
        for (String word : allWords) {
            System.out.println(word);
        }
        return allWords;
    }

    public static void main(String[] args) {
        HashDictionary allWords = new HashDictionary();
        allWords.addPartialWords("yellow");
        System.out.println(allWords.getDictionary());
    }

}


