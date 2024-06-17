package blackjack;

public class Card {
    final String shape;
    final String letter;

    public Card(String shape, String letter) {
        this.shape = shape;
        this.letter = letter;
    }


    public String getLetter() {
        return letter;
    }
}
