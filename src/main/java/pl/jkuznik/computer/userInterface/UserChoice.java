package pl.jkuznik.computer.userInterface;

public enum UserChoice {

    BACK("back", SubMenu.UNIVERSAL),

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

    private final String userinput;
    private final SubMenu subMenu;

    UserChoice(String userinput, SubMenu subMenu) {
        this.userinput = userinput;
        this.subMenu = subMenu;
    }

//    public static UserChoice userChoice(int userChoiceInput) {
//        for (UserChoice choice : UserChoice.values()) {
//            if (choice.userinput == userChoiceInput) {
//                return choice;
//            }
//
//        }
//
//        return UserChoice.USER_INPUT_0;
//    }
}

enum SubMenu {
    UNIVERSAL,
    LANGUE_MENU,
    MAIN_MENU,
    HARDWARE_MENU,
    SOFTWARE_MENU,
}


