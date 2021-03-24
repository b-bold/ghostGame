import java.util.Scanner;


public class User {
    private int id = 1;
    private String name;
    private Boolean isChallenging = false;
    private char lastLetter = '0';
    private int lastId = this.id;

    // build a constructor to ask for name which creates a
    // new player + automatic id (should increase by 1 for every
    // new player
    User () {
        name = getNameFromUser();
        createId();
    }

    public int getId(){
        return this.id;
    }

    private void setId(int newId) {
        this.id = newId;
    }

    private void createId (){
        if (lastId == 1) {
            this.id = 1;
        } else {
             this.id = lastId + 1;
             lastId = this.id;
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    // get user created name then set it to field name
    public String getNameFromUser() {
        Scanner scanner;
        scanner = new Scanner(System.in);

        // CLI request for user generated name
        System.out.println("Type your name: ");
        System.out.flush();
        String proposedName = scanner.nextLine();

        // check that proposedName is all letters
        // if not loop through and get the input again.
        for (int i = 0; i < proposedName.length(); i++)  {
            char lowerLetter = proposedName.charAt(i);
            int ascLetter = lowerLetter;

            if (ascLetter < 97 || ascLetter > 122) {
                System.out.println("Try Again");
                return getNameFromUser();
            }
        }

        // set the checked name as the field name
        this.setName(proposedName);
        return "Welcome to the Ghost Game " + proposedName;
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

        System.out.println("Guess one letter: ");
        System.out.flush();
        String letter = scanner.nextLine();

        if (letter.length() > 1) {
            return nextGuess();
        }

        char lowerLetter = letter.toLowerCase().charAt(0);
        int ascLetter = lowerLetter;

        if (ascLetter < 97 || ascLetter > 122) {
            lowerLetter = nextGuess();
        }

        this.lastLetter = lowerLetter;
        return (char) lowerLetter;
    }

    @Override
    public String toString() {
        return this.name;
    }

    // for testing purposes
    public static void main(String[] args) {
        User neka = new User();
//        System.out.println(neka.id);
//        System.out.println(neka.isChallenging);
//        System.out.println(neka.lastLetter);
//        char letter = neka.nextGuess();
//        System.out.println("your guess is: " + letter);
    }
}
