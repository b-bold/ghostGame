import java.util.Scanner;


public class User {
    private int id = 0;
    private String name;
    private Boolean isChallenging = false;
    private char lastLetter = '0';
    static int lastId = 0;

    // build a constructor to ask for name which creates a
    // new player + automatic id (should increase by 1 for every
    // new player
    User () {
        name = getNameFromUser();
        this.createId();
    }

    public int getId(){
        return this.id;
    }

    private void createId () {
       lastId += 1;
       this.id = lastId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public Boolean getIsChallenging() {
        return this.isChallenging;
    }

    public char getLastLetter() {
        return this.lastLetter;
    }

    private void setLastLetter(char newLastLetter) {
        this.lastLetter = newLastLetter;
    }

    public char nextGuess() {
        Scanner scanner;
        scanner = new Scanner(System.in);
        Boolean loopAgain = true;
        char lowerLetter = '-';

        while (loopAgain == true) {

            System.out.println("Guess one letter: ");
            System.out.flush();
            String letter = scanner.nextLine(); // .chatAt(0)

            if (letter.length() > 1) {
                continue;
            }

            lowerLetter = letter.toLowerCase().charAt(0);
            int ascLetter = lowerLetter;

            if (ascLetter < 97 || ascLetter > 122) {
                continue;
            }
            loopAgain = false;
        }

        this.lastLetter = lowerLetter;
        return (char) lowerLetter;
    }

    @Override
    public String toString() {
        return this.name;
    }


    // get user created name then set it to field name
    public String getNameFromUser() {
        Scanner scanner;
        scanner = new Scanner(System.in);
        Boolean loopAgain = true;

        // CLI request for user generated name
        System.out.println("Type your name: ");
        String proposedName = scanner.nextLine();


        while (loopAgain == true) {
            // check that proposedName is all letters
            // if not loop through and get the input again.
            for (int i = 0; i < proposedName.length(); i++) {
                // lower the letter
                proposedName.toLowerCase();
                char lowerLetter = proposedName.toLowerCase().charAt(i);
                int ascLetter = lowerLetter;

                if (ascLetter < 97 || ascLetter > 122) {
                    System.out.println("Try Again");
                    System.out.println("Type your name: ");
                    proposedName = scanner.nextLine();
                    continue;
                }
                loopAgain = false;
            }
        }

        // set the checked name as the field name
        this.setName(proposedName);
        return "Welcome to the Ghost Game " + proposedName;
    }


    // for testing purposes
    public static void main(String[] args) {
        User neka = new User();
        System.out.println(neka.getName());
        System.out.println(neka.getId());
        User nazy = new User();
        System.out.println(nazy.getName());
        System.out.println(nazy.getId());
    }
}
