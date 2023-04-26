package ui;

import data.BaseQuestions;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserInput {
    private final Scanner scanner;
    private final WorkbookUI workbookUI;

    public UserInput(Scanner scanner, WorkbookUI workbookUI) {
        this.scanner = scanner;
        this.workbookUI = workbookUI;
    }

    private String getUserInput() {
        return scanner.nextLine().toLowerCase();
    }

    private boolean isPlayerNameValid(String name) {
        return name.matches("^[a-zA-Z,\\s]+$");
    }

    private String capitalisePlayerName(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }

    private String formatPlayerNames(String userInput) {
        return Arrays.stream(userInput.split("\\s*,\\s*"))
                .map(name -> capitalisePlayerName(name.trim()))
                .collect(Collectors.joining(", "));
    }

    public String getPlayerNames() {
        while (true) {
            String userInput = getUserInput().trim().replaceAll("\\s+", " ");
            if (userInput.isEmpty()) {
                workbookUI.emptyUserInputMessage();
            } else if (!isPlayerNameValid(userInput)) {
                workbookUI.invalidUserNameFormatMessage();
            } else if ((userInput.split("\\s*,\\s*").length > 9)) {
                workbookUI.tooManyPlayersMessage();
            } else {
                return formatPlayerNames(userInput);
            }
        }
    }

    public void startGame() {
        String userInput;
        boolean isCorrectInput = true;
        do {
            userInput = getUserInput();
            if (userInput.isEmpty()) {
                continue;
            } else if (userInput.equals("s") || userInput.equals("x")) {
                workbookUI.setControlsActions(userInput);
                isCorrectInput = false;
            } else {
                workbookUI.invalidInput();
            }
        } while (isCorrectInput);
    }

    public int getGameModeNumber() {
        String userInput;
        do {
            userInput = getUserInput();
            if (!userInput.equals("1") && !userInput.equals("2") && !userInput.equals("3")) {
                workbookUI.invalidGameModeNumber();
            } else {
                return Integer.parseInt(userInput);
            }
        } while (true);
    }

    public void getAnswerFromPlayer(int i, String playerName, Map<String, Integer> playersMap, int positivePoints, int negativePoints) {
        String userInput;
        boolean isValidInput = false;

        do {
            userInput = getUserInput();

            if (userInput.isEmpty()) {
                continue;
            } else if (userInput.matches(".*\\d+.*")) {
                workbookUI.invalidFormatMessage();
                continue;
            }
            isValidInput = processAnswer(userInput, playerName, playersMap, positivePoints, negativePoints);

            if (isValidInput && i == getBaseQuestionsSize()) {
                workbookUI.displayUnderLine();
                workbookUI.displayWinners(playersMap);
                break;
            }
            workbookUI.setControlsActions(userInput);
            if(isValidInput) {
                workbookUI.displayUnderLine();}

        } while (!isValidInput);
    }

    private boolean processAnswer(String userInput, String playerName, Map<String, Integer> playersMap, int positivePoints, int negativePoints) {
        if ("yes".equals(userInput)) {
            updatePlayerScore(playerName, playersMap, positivePoints);
            workbookUI.happyMessage(positivePoints);
            workbookUI.displayCurrentScore(playersMap.get(playerName));
            return true;
        } else if ("no".equals(userInput)) {
            updatePlayerScore(playerName, playersMap, -negativePoints);
            workbookUI.sadMessage(negativePoints);
            workbookUI.displayCurrentScore(playersMap.get(playerName));
            return true;
        } else if ("pass".equals(userInput)) {
            workbookUI.neutralMessage();
            workbookUI.displayCurrentScore(playersMap.get(playerName));
            return true;
        } else {
            return false;
        }
    }

    public void updatePlayerScore(String playerName, Map<String, Integer> playersMap, int points) {
        playersMap.compute(playerName, (key, value) -> value + points);
    }

    private int getBaseQuestionsSize() {
        int baseQuestionsLength = 0;
        for (BaseQuestions questions : BaseQuestions.values()) {
            baseQuestionsLength += questions.getQuestions().size();
        }
        return baseQuestionsLength;
    }

}

