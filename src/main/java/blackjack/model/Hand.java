package blackjack.model;

import java.util.HashSet;
import java.util.Set;

public class Hand {
    private final Set<Card> cards;

    public Hand() {
        this.cards = new HashSet<>();
    }

    public Hand(Set<Card> cards) {
        this.cards = new HashSet<>(cards);
    }

    public void add(Card card) {
        if (cards.contains(card)) {
            throw new IllegalArgumentException("중복되는 카드는 가질 수 없습니다.");
        }
        cards.add(card);
    }

    public int size() {
        return cards.size();
    }

    public int totalCardPoint(CalculatePoints calculatePoints) {
        return calculatePoints.calculate(cards);
    }

    public boolean isBurst(CalculatePoints calculatePoints) {
        return totalCardPoint(calculatePoints) > 21;
    }

    public boolean contains(Card card) {
        return cards.contains(card);
    }

    public Set<Card> getCards() {
        return new HashSet<>(cards);
    }
}
