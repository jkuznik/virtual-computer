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
    SOFTWARE_MENU( "2", SubMenu.MAIN_MENU);

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
        for (UserChoice choice : UserChoice.values()) {
            if () {
                return choice;
            }

        }

        return UserChoice.USER_INPUT_0;
    }
}

enum SubMenu {
    UNIVERSAL,
    LANGUE_MENU,
    MAIN_MENU,
    HARDWARE_MENU,
    SOFTWARE_MENU,
}


