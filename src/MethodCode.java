import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class MethodCode {

    static Scanner sc = new Scanner(System.in);
    static HashMap<Integer, String> menuChoices = new HashMap<>();

    public static void handleMethodMenu(String fileName, String menuTitle) {
        boolean backToMainMenu = false;

        do {
            UI.displaySubMenuName(fileName, menuTitle);
            String subMenuChoice = sc.nextLine();

            backToMainMenu = processMethodMenuChoice(subMenuChoice, fileName);
        } while (!backToMainMenu);
    }

    public static boolean handleNumericMethodChoice(String choice) {
        if (isInteger(choice)) {
            int selectedChoice = Integer.parseInt(choice);
            String folderPath = "AllData/";
            String filePath = folderPath + "m" + selectedChoice + ".txt";
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

    public static boolean processMethodMenuChoice(String choice, String fileName) {
        if (choice.equals("*")) {
            UI.handleExit();
            return true;
        } else if (choice.equals("0")) {
            addLineToMethodTxtFile(fileName);
            return false;
        } else {
            return handleNumericMethodChoice(choice);
        }
    }

    public static void addLineToMethodTxtFile(String fileName) {
        UI.printMsg("Iveskite naujos temos pavadinima: ");
        String name = sc.nextLine();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.newLine();
            writer.append(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Utils.addNewMethodFile();
    }
}

