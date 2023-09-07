import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class FunctionalityCode {

        static Scanner sc = new Scanner(System.in);
        static HashMap<Integer, String> menuChoices = new HashMap<>();

        public static void handleFunctionalityMenu(String fileName, String menuTitle) {
            boolean backToMainMenu = false;

            do {
                UI.displaySubMenuName(fileName, menuTitle);
                String subMenuChoice = sc.nextLine();

                backToMainMenu = processFunctionalityMenuChoice(subMenuChoice, fileName);
            } while (!backToMainMenu);
        }

        public static boolean handleNumericFunctionalityChoice(String choice) {
            if (isInteger(choice)) {
                int selectedChoice = Integer.parseInt(choice);
                String folderPath = "AllData/";
                String filePath = folderPath + "f" + selectedChoice + ".txt";
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

        public static boolean processFunctionalityMenuChoice(String choice, String fileName) {
            if (choice.equals("*")) {
                UI.handleExit();
                return true;
            } else if (choice.equals("0")) {
                addLineToFunctionalityTxtFile(fileName);
                return false;
            } else {
                return handleNumericFunctionalityChoice(choice);
            }
        }

        public static void addLineToFunctionalityTxtFile(String fileName) {
            UI.printMsg("Iveskite naujos temos pavadinima: ");
            String name = sc.nextLine();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                writer.newLine();
                writer.append(name);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Utils.addNewFunctionalityFile();
        }
    }

