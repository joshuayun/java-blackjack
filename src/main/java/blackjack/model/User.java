package blackjack.model;

import java.util.Set;

public interface User {
    void setUpCard(CardDeck cardDeck);

    void receiveCard(CardDeck cardDeck, CalculatePoints calculatePoints);

    boolean contains(Card card);

    String getName();

    Set<Card> getCards();

    boolean isBurst(CalculatePoints calculatePoints);

    int getPoints(CalculatePoints calculatePoints);
}
