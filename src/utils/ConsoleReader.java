package utils;

import java.util.Scanner;

public class ConsoleReader {

    private Scanner scanner = new Scanner(System.in);

    private static ConsoleReader instance;

    private ConsoleReader() {
    }
}
