package de.magicbrothers.lottery.api;

import java.util.*;

public class Lottery {

    private static HashMap<Integer, Lottery> lotteries = new HashMap<>();
    private int id;
    private String name;
    private HashMap<String, Double> players = new HashMap<>();
    private double jackpot;

    public Lottery(String name) {
        this.name = name;
        lotteries.put(lotteries.size(), this);
    }

    public boolean add(String p, double coins) {
        if(players.containsKey(p) || coins <= 0) {
            return false;
        }
        players.put(p, coins);
        jackpot += coins;
        return true;
    }

    public boolean remove(String p) {
        if (players.containsKey(p)) {
            jackpot -= players.remove(p);
            return true;
        }

        return false;
    }

    public HashMap<String, Double> win(ArrayList<String> winners) {
        HashMap<String, Double> wins = new HashMap<>();
        double base = 0;

        for (String p : winners) {
            base += players.get(p);
        }

        System.out.println("Base: " + (29.0 / base));

        for (String p : winners) {
            wins.put(p, jackpot * (players.get(p) / base));
        }

        lotteries.remove(id);

        return wins;
    }

    public HashMap<String, Double> randomWin() {
        return win(new ArrayList<String>(Collections.singletonList((String) players.keySet().toArray()[new Random().nextInt(players.size())])));
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getJackpot() {
        return jackpot;
    }

    public HashMap<String, Double> getPlayers() {
        return players;
    }

    public static HashMap<Integer, Lottery> getLotteries() {
        return lotteries;
    }

    public static Lottery getLottery(int id) {
        return lotteries.get(id);
    }

    public static Lottery getLottery(String name) {
        return lotteries.values().stream().filter(lottery -> lottery.getName().equals(name)).findFirst().orElse(null);
    }

}
