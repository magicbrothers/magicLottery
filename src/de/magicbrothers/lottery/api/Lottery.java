package de.magicbrothers.lottery.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class Lottery {

    private static HashMap<Integer, Lottery> lotteries = new HashMap<>();
    private String creator;
    private int id;
    private HashMap<String, Integer> players = new HashMap<>();
    private int jackpot;

    public Lottery() {
        id = (int) (new Date().getTime() / 10);
        if(id < 0) id *= -1;
        lotteries.put(id, this);
    }

    public Lottery(String creator) {
        this.creator = creator;
        id = (int) (new Date().getTime() / 10);
        if(id < 0) id *= -1;
        lotteries.put(id, this);
    }

    public boolean add(String p, int coins) {
        if(players.containsKey(p) || coins <= 0) {
            return false;
        }
        players.put(p, coins);
        jackpot += coins;
        return true;
    }

    public void remove(String p) {
        jackpot -= players.get(p);
        players.remove(p);
    }

    public HashMap<String, Integer> win(ArrayList<String> players) {
        HashMap<String, Integer> winners = new HashMap<>();
        int base = 0;

        for(String p : players) {
            base += this.players.get(p);
        }

        for(String p : players) {
            winners.put(p, (jackpot * (this.players.get(p) / base)));
        }

        lotteries.remove(id);

        return winners;
    }

    public HashMap<String, Integer> randomWin() {
        ArrayList<String> winner = new ArrayList<>();
        int random = new Random().nextInt(players.size());

        winner.add((String) players.keySet().toArray()[random]);

        return win(winner);
    }

    public HashMap<String, Integer> getPlayers() {
        return players;
    }

    public String getCreator() {
        return creator;
    }

    public int getId() {
        return id;
    }

    public int getJackpot() {
        return jackpot;
    }

    public static boolean hasLottery(String p) {
        boolean hasLottery = false;
        for (Lottery i : Lottery.getLotteries().values()) {
            if (i.getCreator().equals(p)) {
                hasLottery = true;
                break;
            }
        }

        return hasLottery;
    }

    public static Lottery getLottery(int id) {
        if(!lotteries.containsKey(id)) {
            return null;
        }
        return lotteries.get(id);
    }

    public static Lottery getLottery(String creator) {
        for(Lottery i : lotteries.values()) {
            if(i.getCreator().equals(creator)) {
                return i;
            }
        }
        return null;
    }

    public static HashMap<Integer, Lottery> getLotteries() {
        return lotteries;
    }

}
