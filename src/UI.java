import java.util.Scanner;

public class UI {

    static Scanner sc = new Scanner(System.in);

    public static void printZeroPointMenu() {
        printMsg("");
        printMsg("******Welcome to  Ultimate Command Center******");
        printMsg("1 - Info");
        printMsg("2 - Functionality");
        printMsg("3 - Examples of your code");
        printMsg("Important!!! Use symbol '*' to comeback to main menu");
        printMsg("");
    }

    public static int getUsersNumber(String msg) {
        printMsg(msg);
        String res = sc.nextLine();
        try {
            int digit = Integer.parseInt(res);
            return digit;
        } catch (Exception e) {
            return -1;
        }
    }

    public static void printMsg(String str) {
        System.out.println(str);
    }

    public static void displaySubMenuName(String fileName, String menuTitle) {
        UI.printMsg(menuTitle + " Menu:");
        Utils.displaySubMenu(fileName);
        UI.printMsg("Your choice: ");
    }

    public static void handleInvalidChoice() {
        UI.printMsg("Wrong Answer, try again!");
    }

    public static void handleExit() {
        UI.printMsg("Exit");
    }

}