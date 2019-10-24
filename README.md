# magicLottery
Eine API zur einfachen Erstellung von Minecraft Ingame Lotterien

So nutzt du die magicLottery API in deinem Plugin:

1. Lade dir die [magicLottery.jar](https://github.com/magicbrothers/magicLottery/releases/download/v1.0.0/magicLottery.jar) Datei herunter oder compliere den Quellcode selber.
2. Verschiebe die Datei in den Plugin Ordner deines Servers.
3. Importiere in deiner IDE die magicLottery.jar als Library.
4. Fertig! Jetzt kannst du die API Befehle nutzen!

# API:

Variablen:
- MagicLottery.PREFIX
- MagicLottery.NO_PERMISSION

Funktionen:
static:
 - boolean hasLottery(String p): hat Spieler 'p' eine aktive Lottery?
 - Lottery getLottery(int id): gibt die Lottery mit der ID 'id'.
 - Lottery getLottery(String creator): gibt die Lottery von 'creator'.
 - HashMap<Integer, Lottery> getLotteries(): gibt alle Lotteries und ihre IDs.

non-static:
 - boolean add(String p, int coins): Spieler 'p' zahlt 'coins' Coins in die Lottery ein, wenn der Spieler noch nicht eingezahlt hat und 'coins' > 0 ist.
 - void remove(String p): entfernt den Spieler 'p' aus der Lottery.
 - HashMap<String, Integer> win(ArrayList<String> players): teilt den Gewinn zwischen den Gewinnern 'players' auf und gibt eine HashMap mit 'Name':'Gewinn'
 - HashMap<String, Integer> randomWin(): ruft win() mit einem random Spieler aus der Lottery auf.
 - HashMap<String, Integer> getPlayers(): gibt Spieler und deren Einsatz.
 - String getCreator(): gibt den Creator der Lottery.
 - int getId(): gibt die ID der Lottery.
 - int getJackpot(): gibt die Anzahl der in die Lottery eingzahlten Coins.
