import java.util.ArrayList;

public class Board {
    private StringBuilder wordSoFar = new StringBuilder();
    private User currentPlayer;

    public StringBuilder getWordSoFar() { return this.wordSoFar; }

    public User getCurrentPlayer() { return this.currentPlayer; }

    public String setCurrentPlayer(User player) {

        this.currentPlayer = player;
        return currentPlayer.getName();
    }

    // for testing purposes
    public static void main(String[] args) {
        System.out.println();
    }

}
