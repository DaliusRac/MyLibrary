public class Program {

    public void startProgram() {
        while (true) {
            zeroPointStart();
        }
    }

    public void zeroPointStart() {
        int choice;
        do {
            UI.printZeroPointMenu();
            choice = UI.getUsersNumber("Your choice:");
        } while (!processZeroPointMenu(choice));
    }

    public boolean processZeroPointMenu(int choice) {
        switch (choice) {
            case 0:
                UI.printMsg("The program ends work;");
                return false;
            case 1:
                InfoCode.handleInfoMenu("Info.txt", "Info");
                return true;
            case 2:
                FunctionalityCode.handleFunctionalityMenu("Functionality.txt", "Functionality");
                return true;
            case 3:
                MethodCode.handleMethodMenu("Examples of your code.txt", "Examples of methods");
                return true;
            default:
                return false;
        }
    }

}