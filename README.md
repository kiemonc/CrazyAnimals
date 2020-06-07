# CrazyAnimals
Programowanie obiektowe - projekt
Autorzy: Mikołaj Chmielecki i Jakub Mroziński
2020 r.

Główna klasa: Main

Domyślnie aplikacja uruchamia się w trybie graficznym z wykorzystaniem biblioteki Swing.

Aby uruchomić aplikację w konsoli wystarczy uruchomić ją z parametrem -c lub --console.

Aby uruchomić start symulacji zaraz po uruchomieniu programu należy użyc parametru -r lub --run.

Parametry można zadawać w interfejsie graficznym lub za pomocą parsowania.

Plik z wynikiem symulacji zapisuje się automatycznie po zakończeniu symulacji, w miejsciu ustalonym w parametrach początkowych. Można to ustawić za pomocą poarametru --path lub -p. Domyślnie plik zapisuje się w folderze uruchomienia sumylacji pod nazwą data.csv

Kiedy taki plik istnieje to wynik ostatniej symulacji jest dopisywany na końcu pliku, zatem można przeprowadzać automatycznie z wykorzystaniem pętli w cmd, całą serię symulacji i badać wyniki dla większej liczby wyników. 

Parametry można zadawać używając parsowania. Szczegółowe informacje po wpisaniu --help.

Parametry domyślne zapisane są w klasie Parameters. Warunki jakie powinny spełniać parametry opisane są w klasie Parameters.

Pogram korzysta z biblioteki JCommander do parsowania argumentów. W pliku build.gradle jest dopisana linijka odpowiedzialna za dodawanie tej biblioteki do projetku.
