package pl.jkuznik.computer.userInterface;

public enum MultiLingualHandler {

    MAIN_MENU ("""
                    
                    1.Wyświetl podzespoły.
                    2.Zarządzanie plikami.
                    8.Powrót.
                    9.Wyjście.
                    """,
            """
                    
                    1.Display components.
                    2.File management.
                    8.Back.
                    9.Exit.
                    """),

    PROGRAM_ENDED ("Program zakończony.", "Program ended."),
    ERROR ("Błąd, spróbuj ponownie!" , "Error, try again!"),

    FILE_MANAGER("""
                    
                    1.Wyświetl pliki.
                    2.Dodaj plik.
                    3.Usuń plik.
                    4.Uruchom program.
                    5.Uruchom grę.
                    8.Powrót.
                    9.Wyjście.
                    """,
            """
                    
                    1.Display files.
                    2.Add file.
                    3.Delete file.
                    4.Run program.
                    5.Run game.
                    8.Back.
                    9.Exit.
                    """),

    RUN_GAME("Wpisz nazwę gry który chcesz uruchomić.",
            "Enter the name of the game you want to launch."),

    RUN_PROGRAM("Wpisz nazwę programu który chcesz uruchomić.",
                "Enter the name of the program you want to launch."),

    ADD_FILE ("""
            Podaj rodzaj pliku:
            1.JPG
            2.GIF
            3.MP3
            """,
            """
            Enter file type:
            1.JPG
            2.GIF
            3.MP3
            """),

    INPUT_NAME("Podaj nazwe", "Enter name"),
    INPUT_SIZE("Podaj rozmiar","Enter size"),
    INPUT_BRAND_NAME("Podaj wykonawcę" , "Enter brand name"),
    INPUT_TITLE("Podaj tytuł" , "Enter title"),
    INPUT_QUALITY("Podaj Jakość" , "Enter quality"),
    INPUT_COMPRESSION("Podaj kompresje" , "Enter compresion"),
    INPUT_NAME_FOR_DELETE("Podaj nazwe pliku który chcesz usunąć" ,
                          "Enter the name of the file you want to delete.");


private final String textPl;
private final String textEng;

    public String getTextPl() {
        return textPl;
    }

    public String getTextEng() {
        return textEng;
    }

    MultiLingualHandler(String textPl, String textEng) {
        this.textPl = textPl;
        this.textEng = textEng;
    }


}