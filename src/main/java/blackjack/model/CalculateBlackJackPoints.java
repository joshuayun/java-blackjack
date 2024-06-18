package blackjack.model;

import java.util.Set;

public class CalculateBlackJackPoints implements CalculatePoints {
    private static final int BLACK_JACK_MAX_POINT = 21;

    @Override
    public int calculate(Set<Card> cards) {
        int sum = cards.stream().mapToInt(card -> card.getLetter().getPoint()).sum();

        if (hasAceCard(cards)) {
            return calculateFavorableAceCard(sum);
        }

        return sum;
    }

    private boolean hasAceCard(Set<Card> cards) {
        return cards.stream().anyMatch(card -> card.getLetter().equals(CardLetter.ACE));
    }

    private int calculateFavorableAceCard(int sum) {
        if (sum > BLACK_JACK_MAX_POINT) {
            sum -= 10;
        }

        return sum;
    }
}
