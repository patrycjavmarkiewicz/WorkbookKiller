package service;

import data.BaseQuestions;
import ui.UserInput;
import ui.WorkbookUI;

import java.util.*;

public class WorkbookService {
    private final WorkbookUI workbookUI;
    private final UserInput userInput;
    public WorkbookService(WorkbookUI workbookUI, UserInput userInput) {
        this.workbookUI = workbookUI;
        this.userInput = userInput;
    }
    public void startApp() {
        workbookUI.displayGameHeading();
        workbookUI.startGameMessage();
        userInput.startGame();
        workbookUI.setPlayerNamesMessage();
        String playerNames = userInput.getPlayerNames();
        workbookUI.selectGameModeMessage();
        int gameModeNumber = userInput.getGameModeNumber();
        runGameMode(gameModeNumber, playerNames);
    }

    private void runGameMode(int selectedGameModeNum, String playerNames) {

        final int positivePoints = 20;
        final int negativePoints = 10;

        workbookUI.selectedGameMode(selectedGameModeNum);
        workbookUI.letTheGameBeginMessage();

        List<String> allQuestions = Arrays.stream(BaseQuestions.values())
                .flatMap(bq -> bq.getQuestions().stream())
                .toList();

        List<String> questions = new ArrayList<>(allQuestions);
        List<String> playersList = new ArrayList<>(Arrays.asList(playerNames.split(", ")));
        Map<String, Integer> playersNameAndScore = new HashMap<>();
        playersList.forEach(player -> playersNameAndScore.put(player, 30));

        switch (selectedGameModeNum) {
            case 1 -> questions = allQuestions;
            case 2 -> Collections.shuffle(questions);
            case 3 -> {
                Collections.shuffle(playersList);
                Collections.shuffle(questions);
            }
            case 4 -> {
                workbookUI.exitGame();
                return;
            }
            default -> throw new IllegalArgumentException("Invalid game mode number: " + selectedGameModeNum);
        }

        int i = 0;
        int playerIndex = 0;

        for (String question : questions) {
            String playerName = playersList.get(playerIndex);
            workbookUI.displayQuestionNumber(++i);
            workbookUI.displayPlayerName(playerName);
            workbookUI.displayCurrentQuestion(question);
            workbookUI.setResponse();  //+
            workbookUI.displayControls(); //+
            userInput.getAnswerFromPlayer(i, playerName, playersNameAndScore, positivePoints, negativePoints);
            playerIndex++;

            if (playerIndex == playersNameAndScore.size()) {
                playerIndex = 0;
                if (selectedGameModeNum == 3) {
                    Collections.shuffle(playersList);
                }
            }
        }
    }
}




