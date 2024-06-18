package blackjack.model;

import java.util.Set;

public class Dealer implements User {
    final Hand hand;

    public Dealer(Hand hand) {
        this.hand = hand;
    }

    @Override
    public void setUpCard(CardDeck cardDeck) {
        for (int i = 0; i < 2; i++) {
            hand.add(cardDeck.pickCard());
        }
    }

    @Override
    public void receiveCard(CardDeck cardDeck, CalculatePoints calculatePoints) {
        if (hand.totalCardPoint(calculatePoints) > 16) {
            throw new IllegalStateException("딜러의 점수가 16을 초과하여 카드를 더이상 받을 수 없습니다.");
        }

        hand.add(cardDeck.pickCard());
    }

    @Override
    public boolean contains(Card card) {
        return hand.contains(card);
    }

    @Override
    public String getName() {
        return "dealer";
    }

    @Override
    public Set<Card> getCards() {
        return hand.getCards();
    }

    @Override
    public boolean isBurst(CalculatePoints calculatePoints) {
        return hand.isBurst(calculatePoints);
    }

    @Override
    public int getPoints(CalculatePoints calculatePoints) {
        return hand.totalCardPoint(calculatePoints);
    }
}
