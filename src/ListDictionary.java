import java.util.ArrayList;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class ListDictionary implements Dictionaries {
    private ArrayList<String> allWords = new ArrayList<String>();

    public void createDictionary() {
        try {
            URL appAcademyDictionary =
                    new URL("https://assets.aaonline.io/fullstack/ruby/projects/ghost/dictionary.txt");
            Scanner sc = new Scanner(appAcademyDictionary.openStream());
            while (sc.hasNext()) {
                allWords.add(sc.next());
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    // check each word to see if there exists a word that contains
    // all of current partialWord. This will be proof that
    // it is a valid
    public boolean partialWordExists(String partialWord) {
        boolean found = false;
        String partialLower = partialWord.toLowerCase();

        //check each letter against each word of the dictionary
        // if we get to the end of the partialLower but not the dictionaryLower
        // then we should return true
        for (String word : allWords) {
            if (word.length() < partialLower.length()) {
                continue;
            }
            boolean compareWordsResult = compareWords(word, partialLower);

            if (compareWordsResult) {
                found = true;
                break;
            } else {
                found = false;
            }
        }

    return found; // return false
    }

    public boolean compareWords(String word, String partialLower) {
        boolean exist = false;

        int i = 0;
        while (i <= partialLower.length() - 1) {
            int currentPartialLetter = (int) partialLower.charAt(i); // r
            int currentWordLetter = (int) word.charAt(i);

            if (currentWordLetter == currentPartialLetter) { // same
                exist = true;
            } else {
                exist = false;
                break;
            }
            i++;
        }

        return exist;
    }

    // print every word in dictionary
    public void getDictionary() {
            for (String word : allWords) {
                System.out.println(word);
            }
    }

    //print length of dictionary arrayList
    public int getDictionarySize() {
        return allWords.size();
    }

    public static void main(String[] args) {
        ListDictionary allWords = new ListDictionary();
        allWords.createDictionary();
        System.out.println(allWords.getDictionarySize());
        System.out.println(allWords.partialWordExists("aar"));
        System.out.println(allWords.partialWordExists("randm"));
        System.out.println(allWords.partialWordExists("a"));
    }
}


