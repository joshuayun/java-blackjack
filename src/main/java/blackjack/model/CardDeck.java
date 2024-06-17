package blackjack.model;

public interface CardDeck {
    Card pickCard();

    boolean contains(Card card);
}
