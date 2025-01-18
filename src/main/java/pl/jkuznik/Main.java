package pl.jkuznik;

import pl.jkuznik.computer.userInterface.UserInterface;
import pl.jkuznik.utils.persistentState.StateReader;

public class Main {

    public static void main(String[] args) {

        StateReader stateReader = new StateReader();

        stateReader.readFile();
        UserInterface.userInterface();
    }
}
