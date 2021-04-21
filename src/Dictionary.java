import java.util.ArrayList;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Dictionary {
    private ArrayList<String> dictionary= new ArrayList<String>();

    public void createDictionary() {
        try {
            URL appAcademyDictionary =
                    new URL("https://assets.aaonline.io/fullstack/ruby/projects/ghost/dictionary.txt");
            Scanner sc = new Scanner(appAcademyDictionary.openStream());
            while (sc.hasNext()) {
                dictionary.add(sc.next());
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    // check each word to see if there exists a word that contains
    // all of current partialWord. This will be proof that
    // it is a valid
//    public boolean searchDictionary(String partialWord) {
//        boolean found = false;
//        String partialLower = partialWord.toLowerCase();
//
//        //check each letter against each word of the dictionary
//        // if we get to the end of the partialLower but not the dictionaryLower
//        // then we should return true
//        for (String word : dictionary) {
//
//            int i = 0;
//            while (i <= partialLower.length() - 1) {
//                int currentPartialLetter = (int) partialLower.charAt(i);
//                int currentWordLetter = (int) word.charAt(i);
//
//
//        }
//
//    }
    // print every word in dictionary
    public void getDictionary() {
            for (String str : dictionary) {
                System.out.println(str);
            }
    }

    //print length of dictionary arrayList
    public int getDictionarySize() {
        return dictionary.size();
    }

    public static void main(String[] args) {
        Dictionary allWords = new Dictionary();
        allWords.createDictionary();
        System.out.println(allWords.getDictionarySize());
//        System.out.println(allWords.searchDictionary("reca")); // true
    }
}


