package blackjack;

import java.util.Collection;

public interface User {
    void receiveCard(CardDeck cardDeck);

    Collection<Card> getCards();
}
