import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private ArrayList<User> allPlayers = new ArrayList();
    private ArrayList<User> allActivePlayers = new ArrayList();
    private Board ghost = new Board();

// get all players to be created at once and
    // put them all in the allPlayers arraylist
    public void populateAllPlayers() {
        Boolean morePlayers = true;

        while (morePlayers) {
            User newPlayer = new User();
            allPlayers.add(newPlayer);
            allActivePlayers.add(newPlayer);

            String response = getUserInput();

            if (response.equals("y") ) {
                morePlayers = true;
            }
            else if (allActivePlayers.size() <= 1) {
                System.out.println("please add another player");
                morePlayers = true;
            }
            else if (response.equals("n")) {
                morePlayers = false;
            }
        }

        ghost.setCurrentPlayer(allActivePlayers.get(0));
    }

    public void playGhost() {
        populateAllPlayers();

        while (hasWon() == false) {
            for (int i = 0; i <= allActivePlayers.size() - 1; i++) {
                System.out.println(ghost.viewBoard());
                User ele = allActivePlayers.get(i);
                char letter = ele.nextGuess();
                ghost.getWordSoFar().append(letter);

                // get user input to see if any other players challenge
                    // figure out who is challenging
                    // check against dictionary
                    // delete current player from the game and set current player to next
                    // element
                    // break into the next loop

                if (allActivePlayers.get(i + 1) == null ) {
                    continue;
                }

                ghost.setCurrentPlayer(allActivePlayers.get(i + 1));
            }

        }

    }

    public Boolean hasWon() {
        return allPlayers.size() != 1;
    }

    public String getUserInput() {
        Scanner scanner;
        scanner = new Scanner(System.in);
        System.out.println("Are there any other players that will be playing too? (y/n) ");
        String response = new String();
        response = scanner.nextLine();
        return response;
    }

    // for testing purposes
    public static void main(String[] args) {
        Game ghost = new Game();
        ghost.populateAllPlayers();
    }
}
