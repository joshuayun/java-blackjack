package blackjack.model;

public interface User {
    void setUpCard(CardDeck cardDeck);

    void receiveCard(CardDeck cardDeck, Points points);

    boolean contains(Card card);

    String getName();

    String openCard();

    Score isWinner(User other, Points points);

    boolean isBurst(Points points);

    int getPoints(Points points);
}
