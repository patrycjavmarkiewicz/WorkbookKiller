package ui;

import java.util.Map;

public class WorkbookUI {

    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_RED_BOLD = "\033[1;31m";
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_CYAN = "\u001B[36m";
    public static final String TEXT_YELLOW = "\u001B[33m";

    public void displayGameHeading() {
        System.out.println();
        System.out.printf(TEXT_RED + "--------------------------------------------------------------------------------------------%n");
        System.out.printf("|                       Welcome to the Java WorkbookKiller!                                |%n");
        System.out.printf("|                                       \uD83D\uDC80                                                 |%n");
        System.out.printf("| Rules are simple - answer the questions, earn points and become a JavaMaster.            |%n");
        System.out.printf("| You get 30 points to start with. Correct answer gives you +20 points, wrong answer costs |%n");
        System.out.printf("| you -10 points. You can always pass your question to next player and not loose points.   |%n");
        System.out.printf("| OK, no more bullshit. Run it and see if you fu** ** the exam!                            |%n");
        System.out.printf("--------------------------------------------------------------------------------------------%n" + TEXT_RESET);
    }


    public void startGameMessage() {
        System.out.println(TEXT_RED + "[!] Press S to start the game.");
        System.out.println("[!] Press X to end the game." + TEXT_RESET);
    }


    public void selectGameModeMessage() {
        System.out.println(TEXT_RED + "\nEnter number 1,2 or 3 and press enter to select the game mode: ");
        System.out.println("* 1 - Fixed order of player names && fixed order of questions.");
        System.out.println("* 2 - Fixed order of player names && random order of questions.");
        System.out.println("* 3 - Random order of player names && random order of questions" + TEXT_RESET);
    }

    public void setPlayerNamesMessage() {
        System.out.println(TEXT_CYAN + "Enter players' names (from 1 to 9):");
        System.out.println("Example: Patrycja, Bartek, Magda");
        System.out.println("Numbers and special characters are forbidden. Max name length is 15" + TEXT_RESET);
    }

    public void letTheGameBeginMessage() {
        System.out.println(TEXT_RED_BOLD + "\nLet the game begin ... ");
        System.out.println("""
                    /\\_____/\\
                   /  o   o  \\
                  ( ==  ^  == )
                   )         (
                  (           )
                 ( (  )   (  ) )
                (__(__)___(__)__)""");
        System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo" + TEXT_RESET);
    }

    public void invalidGameModeNumber() {
        System.out.println("Invalid game mode number. Please try again...");
    }

    public void invalidInput() {
        System.out.println("Invalid input. Please try again ...");
    }

    public void displayPlayerName(String playerName) {
        System.out.println("Now is answering: " + TEXT_CYAN + playerName + TEXT_RESET);
    }

    public void displayCurrentQuestion(String question) {
        System.out.println("Question: " + TEXT_CYAN + question + TEXT_RESET);
    }

    public void displayControls() {
        System.out.println(TEXT_RED + "\n[!] Press C to change Game Mode. ");
        System.out.println("[!] Press A to display answer.");
        System.out.println("[!] Press X to end the game." + TEXT_RESET);
    }

    public void displayQuestionNumber(int num) {
        System.out.println("\nQuestion number: " + num);
    }

    public void selectedGameMode(int selectedGameModeNum) {
        System.out.println("* Selected game mode: " + selectedGameModeNum);
    }

    public void setResponse() {
        System.out.println("Answered correctly? Please enter one of the following responses: " + TEXT_CYAN);
        System.out.println(" yes | no | pass" + TEXT_RESET + " (|pass| to pass your question to another player).");
    }

    public void displayCurrentScore(int score) {
        System.out.println(TEXT_CYAN + "Your current score is: " + score + "." + TEXT_RESET);
    }

    public void tooManyPlayersMessage() {
        System.out.println("Too many players. The maximum number is 9.");
    }

    public void emptyUserInputMessage() {
        System.out.println("Enter at least one user name containing at least 2 characters to start a game!");
    }

    public void invalidUserNameFormatMessage() {
        System.out.println("Invalid format - the name should not contain numbers and special characters!");
    }

    public void invalidFormatMessage() {
        System.out.println("Invalid format - the name should not contain numbers!");
    }


    public void exitGame() {
        System.out.println("Buuuu :-( Hope to see you soon ...");
        System.exit(0);
    }


    public void sadMessage(int negativePoints) {
        System.out.println(TEXT_CYAN + "\nOhh c'mon man ...     ( ´•︵•` )  ");
        System.out.println("You've lost " + negativePoints + " points." + TEXT_RESET);
    }

    public void happyMessage(int positivePoints) {
        System.out.println(TEXT_CYAN + "\nGo-Go Power Rangers!!!    ৻(  •̀ ᗜ •́  ৻) ");
        System.out.println("You've got " + positivePoints + " points!" + TEXT_RESET);
    }

    public void neutralMessage() {
        System.out.println(TEXT_CYAN + "\nDon't worry! Maybe next time it will work out  •‿• ");
        System.out.println("You get 0 points." + TEXT_RESET);
    }
    public void displayUnderLine() {
        System.out.println(TEXT_RED + "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo" + TEXT_RESET);
    }

    public void displayWinners(Map<String, Integer> playersMap) {
        System.out.println(TEXT_YELLOW + "\nCONGRATULATIONS TO ALL THE PLAYERS!!!!");
        System.out.println("You're getting closer to becoming a JavaMaster!!!");
        System.out.println("Let's check out the winners...");
        System.out.println("\nTOP3:");
        playersMap.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(3)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
        System.exit(0);
    }

    public void setControlsActions(String userInput) {
        if ("s".equals(userInput)) {
            System.out.println();
        } else if ("c".equals(userInput)) {
            System.out.println("Restart Game Mode");
        } else if ("a".equals(userInput)) {
            System.out.println("Answer");
        } else if ("x".equals(userInput)) {
            System.exit(0);
        }
    }
}

