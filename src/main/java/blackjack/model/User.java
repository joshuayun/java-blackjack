package blackjack.model;

public interface User {
    void setUpCard(CardDeck cardDeck);

    void receiveCard(CardDeck cardDeck, Points points);

    boolean contains(Card card);

    String getName();

    String openCard();

    boolean isBurst(Points points);

    int getPoints(Points points);
}
