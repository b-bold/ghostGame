import java.util.ArrayList;

public class Board {
    private StringBuilder wordSoFar = new StringBuilder();
    private ArrayList<User> allPlayers = new ArrayList<User>();
    private User currentPlayer;

    public StringBuilder getWordSoFar() { return this.wordSoFar; }

    public void setWordSoFar(char guess) {
        this.wordSoFar.append(guess);
    }

    public User getCurrentPlayer() { return this.currentPlayer; }

    public String setCurrentPlayer(User player) {

        this.currentPlayer = player;
        return currentPlayer.getName();
    }

    public ArrayList getAllPlayers() { return this.allPlayers; }


    public void addPlayer (User newUser) {
        this.allPlayers.add(newUser);
    }

    public static void main(String[] args) {
        // set a new Board object
//        Board neka = new Board();
//
//        // set a few users and put them into the arraylist
//        User naz = new User();
//        naz.setName("naz");
////        naz.setId(1);
//        neka.setCurrentPlayer(naz.getName());
//        neka.addPlayer(naz);
//        User sean = new User();
////        sean.setId(2);
//        sean.setName("sean");
//        neka.addPlayer(sean);
//        System.out.println(neka.getAllPlayers());
//
//        // check currentPlayer
//        System.out.println(neka.getCurrentPlayer());
//
//        // setting up necessary variables
//        char firstGuess = 'a';
//        char secondGuess = 'b';
//
//        // check the wordSoFar methods
//        neka.setWordSoFar(firstGuess);
//        neka.setWordSoFar(secondGuess);
//        System.out.println(neka.getWordSoFar());


    }

}
