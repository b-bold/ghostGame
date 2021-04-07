import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private ArrayList allPlayers = new ArrayList();
    private Game ghost = new Game();

// get all players to be created at once and
    // put them all in the allPlayers arraylist
    public void populateAllPlayers() {
        Boolean morePlayers = true;

        while (morePlayers) {
            String response = new String();
            response = getUserInput();

            if (response != "y") {
                User newPlayer = new User();
                allPlayers.add(newPlayer);
                morePlayers = false;
            }
        }
    }


    public String getUserInput() {
        Scanner scanner;
        scanner = new Scanner(System.in);
        System.out.println("Are there any other players that will be playing too? (y/n) ");
        String response = new String();
        response = scanner.nextLine();
        return response;
    }
}
