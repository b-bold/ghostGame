

public class Board {
    private StringBuilder wordSoFar = new StringBuilder();
    private User currentPlayer;

    public StringBuilder getWordSoFar() { return this.wordSoFar; }

    public void resetWordSoFar() {
        StringBuilder stringBuilderObj = new StringBuilder();
        stringBuilderObj.setLength(0);
        this.wordSoFar = stringBuilderObj;
    }

    public User getCurrentPlayer() { return this.currentPlayer; }

    public String setCurrentPlayer(User player) {

        this.currentPlayer = player;
        return currentPlayer.getName();
    }

    public StringBuilder viewBoard () {
        StringBuilder view = new StringBuilder();
        view.append("*************************");
        view.append("\n");
        view.append("Current Player: " + this.currentPlayer.getName());
        view.append("\n");
        view.append("Current Word So Far: " + this.getWordSoFar());
        view.append("\n");
        view.append("*************************");
        return view;
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
