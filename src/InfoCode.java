import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class InfoCode {

    static Scanner sc = new Scanner(System.in);
    static HashMap<Integer, String> menuChoices = new HashMap<>();

    public static void handleInfoMenu(String fileName, String menuTitle) {
        boolean backToMainMenu = false;

        do {
            UI.displaySubMenuName(fileName, menuTitle);
            String subMenuChoice = sc.nextLine();

            backToMainMenu = processInfoMenuChoice(subMenuChoice, fileName);
        } while (!backToMainMenu);
    }

    public static boolean handleNumericInfoChoice(String choice) {
        if (isInteger(choice)) {
            int selectedChoice = Integer.parseInt(choice);
            String folderPath = "AllData/";
            String filePath = folderPath + selectedChoice + ".txt";
            Utils.openFile(filePath);
        } else {
            UI.handleInvalidChoice();
        }
        return false;
    }

    private static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean processInfoMenuChoice(String choice, String fileName) {
        if (choice.equals("*")) {
            UI.handleExit();
            return true;
        } else if (choice.equals("0")) {
            addLineToInfoTxtFile(fileName);
            return false;
        } else {
            return handleNumericInfoChoice(choice);
        }
    }

    public static void addLineToInfoTxtFile(String fileName) {
        UI.printMsg("Iveskite naujos temos pavadinima: ");
        String name = sc.nextLine();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.newLine();
            writer.append(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Utils.addNewInfoFile();
    }
}
