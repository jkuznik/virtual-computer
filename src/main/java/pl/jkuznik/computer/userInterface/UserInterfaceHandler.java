package pl.jkuznik.computer.userInterface;

public enum UserInterfaceHandler {

    BACK("back", SubMenu.UNIVERSAL),
    EXIT( "exit", SubMenu.UNIVERSAL),
    DEFAULT( "default", SubMenu.UNIVERSAL),

    PL( "1", SubMenu.LANGUE_MENU),
    EN("2", SubMenu.LANGUE_MENU),
    DE("3", SubMenu.LANGUE_MENU),
    IT("4", SubMenu.LANGUE_MENU),
    FR("5", SubMenu.LANGUE_MENU),
    ES("6", SubMenu.LANGUE_MENU),

    HARDWARE_MENU( "1", SubMenu.MAIN_MENU),
    SOFTWARE_MENU( "2", SubMenu.MAIN_MENU),

    LIST_FILE("1", SubMenu.SOFTWARE_MENU),
    ADD_FILE("2", SubMenu.SOFTWARE_MENU),
    DELETE_FILE("3", SubMenu.SOFTWARE_MENU),
    RUN_PROGRAM("4", SubMenu.SOFTWARE_MENU),
    RUN_GAME("5", SubMenu.SOFTWARE_MENU),

    JPG("1", SubMenu.FILE_MANAGEMENT),
    GIF("2", SubMenu.FILE_MANAGEMENT),
    MP3("3", SubMenu.FILE_MANAGEMENT);


//    USER_INPUT_0(0),
//    USER_INPUT_1(1),
//    USER_INPUT_2(2),
//    USER_INPUT_3(3),
//    USER_INPUT_4(4),
//    USER_INPUT_5(5),
//    USER_INPUT_6(6),
//    USER_INPUT_7(7),
//    USER_INPUT_8(8),
//    USER_INPUT_9(9);

    private final String userChoice;
    private final SubMenu subMenu;

    public String getUserChoice() {
        return userChoice;
    }

    public SubMenu getSubMenu() {
        return subMenu;
    }

    UserInterfaceHandler(String userChoice, SubMenu subMenu) {
        this.userChoice = userChoice;
        this.subMenu = subMenu;
    }

    public static UserInterfaceHandler userChoice(String userInput, SubMenu subMenu) {
        if (userInput.equals("back")){
            return BACK;
        } else if (userInput.equals("exit")) {
            return EXIT;
        }
        for (UserInterfaceHandler userInterfaceHandler : UserInterfaceHandler.values()) {
            if (userInput.equals(userInterfaceHandler.getUserChoice()) && subMenu.equals(userInterfaceHandler.getSubMenu())) {
                return userInterfaceHandler;
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



