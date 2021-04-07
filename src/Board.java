

public class Board {
    private StringBuilder wordSoFar = new StringBuilder();
    private User currentPlayer;

    public StringBuilder getWordSoFar() { return this.wordSoFar; }

    public User getCurrentPlayer() { return this.currentPlayer; }

    public String setCurrentPlayer(User player) {

        this.currentPlayer = player;
        return currentPlayer.getName();
    }

    public String viewBoard () {
        System.out.println("*************************");
        System.out.println("Current Player: " + this.currentPlayer.getName());
        System.out.println("Current Word So Far: " + this.getWordSoFar());
        System.out.println("*************************");
        return "let's keep going";
    }

    // for testing purposes
    public static void main(String[] args) {
        Board ghost = new Board();
        User neka = new User();
        ghost.setCurrentPlayer(neka);
        System.out.println(ghost.getCurrentPlayer());
        System.out.println(ghost.getWordSoFar().append('a'));
        System.out.println(ghost.viewBoard());
    }

}
