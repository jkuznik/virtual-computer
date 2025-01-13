package userInterface;

public enum PolishUserInterface {
MAIN_MENU_PL ("""
                              
                    1.Wyświetl podzespoły 
                    2.Zarządzanie plikami
                    8.Powrót.
                    9.Wyjście.
                    """);

private final String text;

    public String getText() {
        return text;
    }

    PolishUserInterface(String text) {
        this.text = text;
    }
}
