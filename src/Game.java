import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private ArrayList<User> allPlayers = new ArrayList<>();
    private ArrayList<User> allActivePlayers = new ArrayList<>();
    private Board ghost = new Board();
    private HashDictionary dictionary = new HashDictionary();
    private User challenger = new User();

    private User getChallenger() { return this.challenger; }

    public void setChallenger(User activePlayer) { this.challenger = activePlayer; }

// get all players to be created at once and
    // put them all in the allPlayers arraylist
    public void populateAllPlayers() {
        boolean morePlayers = true;

        while (morePlayers) {
            User player = new User();
            String proposedName = player.getNameFromUser();
            player.setName(proposedName);
            player.createId();
            allPlayers.add(player);
            allActivePlayers.add(player);

            String response = userInputAboutMorePlayers();

            if (response.equals("y") ) {
                morePlayers = true;
            } else if (allActivePlayers.size() <= 1) {
                System.out.println("You need at least 2 players for this game. Please add another player");
                morePlayers = true;
            } else if (response.equals("n")) {
                System.out.println("ok let's play!");
                morePlayers = false;
            } else {
                morePlayers = loopForUsableInput("please enter either 'y' or 'n' to choose if another player needs to be added");
            }
        }

        ghost.setCurrentPlayer(allActivePlayers.get(0));
    }

    public boolean loopForUsableInput(String printLine) {
        boolean invalidInput = true;
        boolean returnStatement = false;

        while (invalidInput) {
            System.out.println(printLine);
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
        // setup behind the scenes setup
        dictionary.createDictionary();

        // player setup
        populateAllPlayers();
        System.out.println(ghost.getCurrentPlayer());

        while (hasNotWon()) {
            for (int i = 0; i <= allActivePlayers.size() - 1; i++) {
                User ele = allActivePlayers.get(i);
                ghost.setCurrentPlayer(ele);
                System.out.println(ghost.viewBoard());

                char letter = ele.nextGuess();
                ghost.getWordSoFar().append(letter);

                if (hasChallenged()) {
                    String potentialPlayer = this.promptingChallengerName();
                    this.findChallenger(potentialPlayer);
                    if (dictionary.partialWordExists(ghost.getWordSoFar())) {
                        allActivePlayers.remove(this.challenger);
                        System.out.println("sorry but " + this.challenger + " is out of the game because " +
                                "you can continue making a word from here.");
                    } else {
                        allActivePlayers.remove(ghost.getCurrentPlayer());
                        System.out.println("sorry but " + ghost.getCurrentPlayer() + " is out of the game because " +
                                "you cannot continue making a word from here.");
                        // start another round
                            // reset word
                            //??
                    }
                } else {
                    continue;
                }

                System.out.println("THAT WAS 1 FULL ROUND");

                // get user input to see if any other players challenge
                    // figure out who is challenging
                    // check against dictionary
                    // delete current player from the game and set current player to next
                    // element
                    // break into the next loop
            }

        }

    }

    public boolean hasNotWon() {
        return allPlayers.size() != 1;
    }


    public String promptingChallengerName() {
        Scanner scanner;
        scanner = new Scanner(System.in);
        System.out.println("please type your name ");
        String potentialUser = scanner.nextLine();
        return potentialUser;
    }

    public void findChallenger(String potentialPlayer) {
        for (User player: allActivePlayers) {
            if (player.getName().equals(potentialPlayer.toLowerCase())) {
                setChallenger(player);
            }
        }
    }

    public boolean hasChallenged() {
        return loopForUsableInput("does anyone challenge?");
    }

    public String userInputAboutMorePlayers() {
        Scanner scanner;
        scanner = new Scanner(System.in);
        System.out.println("Are there any other players that will be playing too? (y/n) ");
        return scanner.nextLine();
    }

    // for testing purposes
    public static void main(String[] args) {
        Game ghost = new Game();
        ghost.playGhost();
    }
}
