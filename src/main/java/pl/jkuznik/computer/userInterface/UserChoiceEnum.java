package pl.jkuznik.computer.userInterface;

public enum UserChoiceEnum {

    USER_INPUT_0(0),
    USER_INPUT_1(1),
    USER_INPUT_2(2),
    USER_INPUT_3(3),
    USER_INPUT_4(4),
    USER_INPUT_5(5),
    USER_INPUT_6(6),
    USER_INPUT_7(7),
    USER_INPUT_8(8),
    USER_INPUT_9(9);

    public int getUserinput() {
        return userinput;
    }

    private final int userinput;


    UserChoiceEnum(int userinput) {
        this.userinput = userinput;
    }

    public static UserChoiceEnum userChoice(int userChoiceInput) {
        for (UserChoiceEnum choice : UserChoiceEnum.values()) {
            if (choice.userinput == userChoiceInput) {
                return choice;
            }

        }

        return UserChoiceEnum.USER_INPUT_0;
    }
}


