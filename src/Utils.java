import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Utils {

    static Scanner sc = new Scanner(System.in);
    static HashMap<Integer, String> menuChoices = new HashMap<>();

    public static void displaySubMenu(String fileName) {
        menuChoices.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int menuItemNumber = 0;
            while ((line = reader.readLine()) != null) {
                menuChoices.put(menuItemNumber, line);
                UI.printMsg(menuItemNumber + ". " + line);
                menuItemNumber++;
            }
        } catch (IOException e) {
            UI.printMsg("Error #4044!!!" + e.getMessage());
        }
    }

    public static void openFile(String fileName) {
        try {
            File file = new File(fileName);
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
        } catch (IOException e) {
            UI.printMsg("Error #4044!!!" + e.getMessage());
        }
    }

    public static void addNewInfoFile() {
        String fileName = String.valueOf(menuChoices.size()) + ".txt";
        File file = new File("AllData/" + fileName);
        boolean result;

        try {
            result = file.createNewFile();
            if (result) {
                UI.printMsg("File created");
            } else {
                UI.printMsg("File already exist at location");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addNewFunctionalityFile() {
        String fileName = "f" + String.valueOf(menuChoices.size()) + ".txt";
        File file = new File("AllData/" + fileName);
        boolean result;

        try {
            result = file.createNewFile();
            if (result) {
                UI.printMsg("File created");
            } else {
                UI.printMsg("File already exist at location");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addNewMethodFile() {
        String fileName = "m" + String.valueOf(menuChoices.size()) + ".txt";
        File file = new File("AllData/" + fileName);
        boolean result;

        try {
            result = file.createNewFile();
            if (result) {
                UI.printMsg("File created");
            } else {
                UI.printMsg("File already exist at location");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}