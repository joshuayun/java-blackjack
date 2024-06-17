package blackjack;

import java.util.Arrays;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card card)) return false;
        return shape == card.shape && getLetter() == card.getLetter();
    }

    @Override
    public int hashCode() {
        return Objects.hash(shape, getLetter());
    }
}
