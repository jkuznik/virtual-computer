package pl.jkuznik.computer.userInterface;

public enum UserChoice {

    BACK("8", SubMenu.UNIVERSAL),
    EXIT( "9", SubMenu.UNIVERSAL),

    // TODO: dodać rozbudowany komunikat o wprowadzeniu nieprawidłowej wartości, można do tego wykorzystać exception
    DEFAULT( "default", SubMenu.UNIVERSAL),

    PL( "1", SubMenu.LANGUE_MENU),
    EN("2", SubMenu.LANGUE_MENU),
    DE("3", SubMenu.LANGUE_MENU),
    IT("4", SubMenu.LANGUE_MENU),
    FR("5", SubMenu.LANGUE_MENU),
    ES("6", SubMenu.LANGUE_MENU),

    HARDWARE_MENU( "1", SubMenu.MAIN_MENU),
    SOFTWARE_MENU( "2", SubMenu.MAIN_MENU),
    LANGUE_OPTION("3", SubMenu.MAIN_MENU),

    LIST_FILE("1", SubMenu.SOFTWARE_MENU),
    ADD_FILE("2", SubMenu.SOFTWARE_MENU),
    DELETE_FILE("3", SubMenu.SOFTWARE_MENU),
    RUN_PROGRAM("4", SubMenu.SOFTWARE_MENU),
    RUN_GAME("5", SubMenu.SOFTWARE_MENU),

    JPG("1", SubMenu.FILE_MANAGEMENT),
    GIF("2", SubMenu.FILE_MANAGEMENT),
    MP3("3", SubMenu.FILE_MANAGEMENT);

    private final String userChoice;
    private final SubMenu subMenu;

    public String getUserChoice() {
        return userChoice;
    }

    public SubMenu getSubMenu() {
        return subMenu;
    }

    UserChoice(String userChoice, SubMenu subMenu) {
        this.userChoice = userChoice;
        this.subMenu = subMenu;
    }

    public static UserChoice userChoice(String userInput, SubMenu subMenu) {
        if (userInput.equals("8")){
            return BACK;
        } else if (userInput.equals("9")) {
            return EXIT;
        }
        for (UserChoice userChoice : UserChoice.values()) {
            if (userInput.equals(userChoice.getUserChoice()) && subMenu.equals(userChoice.getSubMenu())) {
                return userChoice;
            }
        }
        return DEFAULT;
    }
}

enum SubMenu {
    UNIVERSAL,
    LANGUE_MENU,
    MAIN_MENU,
    HARDWARE_MENU,
    SOFTWARE_MENU,
    FILE_MANAGEMENT
}



