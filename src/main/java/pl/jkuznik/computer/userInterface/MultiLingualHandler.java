package pl.jkuznik.computer.userInterface;

public enum MultiLingualHandler {

    MAIN_MENU ("""
                              
                    1.Wyświetl podzespoły 
                    2.Zarządzanie plikami
                    8.Powrót.
                    9.Wyjście.
                    """,
                  "eng"),

    PROGRAM_ENDED_PL ("Program zakończony",
                      "eng"),
    ERROR ("Błąd, spróbuj ponownie!" , "eng"),

    FILE_MANAGER("""
                    1.Wyświetl pliki.
                    2.Dodaj plik.
                    3.Usuń plik.
                    4.Uruchom program.
                    5.Uruchom grę.
                    8.Powrót.
                    9.Wyjście.
                    """,
                "eng"),

    RUN_GAME("Wpisz nazwę gry który chcesz uruchomić",
            "eng"),

    RUN_PROGRAM("Wpisz nazwę programu który chcesz uruchomić",
                "eng"),

    ADD_FILE ("""
            Podaj rodzaj pliku:
            1.JPG.
            2.GIF.
            3.MP3.
             """,
            "ENG"),

    INPUT_NAME("Podaj nazwe", "ENG"),
    INPUT_SIZE("Podaj rozmiar","ENG"),
    INPUT_COMPRESION("Podaj kompresje" , "ENG"),
    INPUT_BRAND_NAME("Podaj wykonawcę" , "ENG"),
    INPUT_NAME_FOR_DELETE("Podaj nazwe pliku który chcesz usunąć" , "ENG");




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