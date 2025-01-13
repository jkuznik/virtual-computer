Język: <br>
[EN](../README.md)

# Virtual-computer

Projekt został stworzony, aby umożliwić osobom uczącym się Javy wspólną pracę nad jedną aplikacją już od początku ich przygody z programowaniem. <br>
Wymaga to zrozumienia podstaw działania Gita, co w efekcie dostarcza dodatkowego doświadczenia oraz jest kluczową umiejętnością dla przyszłych programistów.

#  Jak zacząć

Pierwsze kroki jako collaborator sprawdź [tutaj](instructions/howToStart/collaboratorHowToStart-pl.md). <br>
Pierwsze kroki jako contributor sprawdź [tutaj](instructions/howToStart/contributorHowToStart-pl.md).

# Zintegrowane aplikacje

Najlepszym sposobem nauki jest praktyka. Ten projekt umożliwia wprowadzenie własnych zmian, które w zauważalny sposób wpłyną na całość projektu, a same
zmiany będą realnie dostępne po uruchomieniu aplikacji. Mowa tutaj o prostych programach lub grach typu CLI własnego autorstwa, które można zintegrować
z projektem, a te będą później dostępne z poziomu interfejsu użytkownika głównej aplikacji "Komputer". 
Podstawowe [informacje](instructions/inAppPrograms/inAppInterfaces-pl.md), które musisz wiedzieć.

# Pakiet chatServer

W pakiecie tym jest dostępny kod całej aplikacji pełniącą funkcję dla czatu dostępnego jako
podprogram głównej aplikacji "Komputer". Aby podprogram czatu zadziałał prawidłowo, należy
w pierwszej kolejności uruchomić instancję serwera w lokalnym środowisku. Każda z klas pakietu
chatServer posiada domyślny modyfikator dostępu, co chroni przed korzystaniem z tych klas w klasach
głównej aplikacji.