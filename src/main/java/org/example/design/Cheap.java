package org.example.design;

enum Suit {
    HEARTS, DIAMONDS, CLUBS, SPADES
}

public class Cheap {

    private static final int LENTH_DECK = 12;
    private final Card[] cards;

    Cheap() {
        Suit[] values = Suit.values();
        cards = new Card[LENTH_DECK * values.length];
        int aux = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < LENTH_DECK; j++) {
                cards[aux] = new Card(values[i], j + 1);

                aux++;
            }
        }
    }

    public static void main(String[] args) {
        Cheap cheap = new Cheap();
        Card[] cards = cheap.getCards();
        for (Card card : cards) {
            System.out.println(card);
        }
    }

    public Card[] getCards() {
        return this.cards;
    }
}

class Card {

    Suit suit;
    Integer value;

    Card(Suit suit, Integer value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s %d", this.suit.toString(), this.value);
    }
}