package blackjack;

import java.util.Arrays;

public class Card {
    final CardShape shape;
    final CardLetter letter;

    public Card(CardShape shape, CardLetter letter) {
        this.shape = shape;
        this.letter = letter;
    }

    public CardLetter getLetter() {
        return letter;
    }
}
