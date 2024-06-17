package blackjack.model;

public interface User {
    void receiveCard(CardDeck cardDeck);

    boolean contains(Card card);

    String getName();

    String openCard();
}
