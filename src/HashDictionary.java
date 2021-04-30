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

    public void addPartialWords(String word) {
        StringBuilder growingWord = new StringBuilder();

        int i = 0;
        while (i <= word.length() - 1) {
            growingWord.append(word.charAt(i));
            allWords.add(growingWord.toString());

            i++;
        }
    }

    public boolean partialWordExists(StringBuilder partialWord) {
        if (allWords.contains(partialWord)) {
            return true;
        }
        return false;
    }

    public HashSet getDictionary() {
        for (String word : allWords) {
            System.out.println(word);
        }
        return allWords;
    }

    public int getDictionarySize() {
        return allWords.size();
    }

    public static void main(String[] args) {
        HashDictionary allWords = new HashDictionary();
        allWords.createDictionary();
        System.out.println(allWords.getDictionarySize());
    }

}


