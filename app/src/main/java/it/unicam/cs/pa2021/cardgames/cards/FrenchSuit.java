package it.unicam.cs.pa2021.cardgames.cards;

public enum FrenchSuit {

    HEARTS("h"),
    DIAMONDS("d"),
    CLUBS("c"),
    SPADES("s");


    private final String name;

    private FrenchSuit(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}