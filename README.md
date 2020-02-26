# magicLottery
Eine API zur einfachen Erstellung von Minecraft Ingame Lotterien

So nutzt du die magicLottery API in deinem Plugin:

1. Lade dir die [magicLottery.jar](https://github.com/magicbrothers/magicLottery/releases/download/v2.0.0/magicLottery.jar) Datei herunter oder compliere den Quellcode selber...
2. Verschiebe die Datei in den Plugin Ordner deines Servers.
3. Importiere in deiner IDE die magicLottery.jar als Library.
4. Fertig! Jetzt kannst du die API Befehle nutzen!

[Hier](https://github.com/magicbrothers/LotteryCMD) findest du eine Beispielanwendung der API auf Commandebene.

# API:

Variablen:
- MagicLottery.PREFIX
- MagicLottery.NO_PERMISSION

Funktionen:

static:
 - Lottery getLottery(int id): gibt die Lottery mit der ID 'id'.
 - Lottery getLottery(String name): gibt die Lottery mit dem Namen 'name'.
 - HashMap<Integer, Lottery> getLotteries(): gibt alle Lotteries und ihre IDs.

non-static:
 - boolean add(String p, double coins): Spieler 'p' zahlt 'coins' Coins in die Lottery ein, wenn der Spieler noch nicht eingezahlt hat und 'coins' > 0 ist.
 - boolean remove(String p): entfernt den Spieler 'p' aus der Lottery und gibt den Erfolgswert zurück.
 - HashMap<String, Double> win(ArrayList<String> players): teilt den Gewinn zwischen den Gewinnern 'players' auf und gibt eine HashMap mit 'Name':'Gewinn'
 - HashMap<String, Double> randomWin(): ruft win() mit einem zufälligen Spieler aus der Lottery auf.
 - HashMap<String, Double> getPlayers(): gibt die Spieler und deren Einsatz.
 - String getName(): gibt den Namen der Lottery.
 - int getId(): gibt die ID der Lottery.
 - int getJackpot(): gibt die Anzahl der in die Lottery eingzahlten Coins.
