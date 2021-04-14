import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private ArrayList<User> allPlayers = new ArrayList<>();
    private ArrayList<User> allActivePlayers = new ArrayList<>();
    private Board ghost = new Board();

// get all players to be created at once and
    // put them all in the allPlayers arraylist
    public void populateAllPlayers() {
        boolean morePlayers = true;

        while (morePlayers) {
            User newPlayer = new User();
            allPlayers.add(newPlayer);
            allActivePlayers.add(newPlayer);

            String response = userInputAboutMorePlayers();

            if (response.equals("y") ) {
                morePlayers = true;
            } else if (allActivePlayers.size() <= 1) {
                System.out.println("please add another player");
                morePlayers = true;
            } else if (response.equals("n")) {
                System.out.println("ok let's play!");
                morePlayers = false;
            } else {
                morePlayers = loopForUsableInput();
            }
        }

        ghost.setCurrentPlayer(allActivePlayers.get(0));
    }

    public boolean loopForUsableInput() {
        // infinite while loop
        // tell then to try again
        // print a prompt
        // get user input
        // check to see if it's 'y' or 'n'
        // if 'y' return true
        // elsif 'n' return false
        boolean invalidInput = true;
        boolean returnStatement = false;

        while (invalidInput) {
            System.out.println("please enter either 'y' or 'n' to choose if another player needs to be added");
            Scanner scanner;
            scanner = new Scanner(System.in);
            String response = scanner.nextLine();

            if (response.equals("y")) {
                returnStatement = true;
                invalidInput = false;
            } else if (response.equals("n")) {
                invalidInput = false;
            }
        }
        return returnStatement;
    }

    public void playGhost() {
        populateAllPlayers();

        while (hasNotWon() == true) {
            for (int i = 0; i <= allActivePlayers.size() - 1; i++) {
                System.out.println(ghost.viewBoard());
                User ele = allActivePlayers.get(i);
                ghost.setCurrentPlayer(ele);
                char letter = ele.nextGuess();
                ghost.getWordSoFar().append(letter);

                // get user input to see if any other players challenge
                    // figure out who is challenging
                    // check against dictionary
                    // delete current player from the game and set current player to next
                    // element
                    // break into the next loop
            }

        }

    }

    public Boolean hasNotWon() {
        return allPlayers.size() != 1;
    }

    public String userInputAboutMorePlayers() {
        Scanner scanner;
        scanner = new Scanner(System.in);
        System.out.println("Are there any other players that will be playing too? (y/n) ");
        String response = scanner.nextLine();
        return response;
    }

    // for testing purposes
    public static void main(String[] args) {
        Game ghost = new Game();
        ghost.playGhost();
    }
}
