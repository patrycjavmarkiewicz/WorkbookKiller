import service.WorkbookService;
import ui.UserInput;
import ui.WorkbookUI;

import java.util.Scanner;

public class WorkbookKiller {

    public static void main(String[] args) {
        WorkbookUI workbookUI = new WorkbookUI();
        UserInput userInput = new UserInput(new Scanner(System.in), workbookUI);
        WorkbookService workbookService = new WorkbookService(workbookUI, userInput);
        workbookService.startApp();
    }
}
