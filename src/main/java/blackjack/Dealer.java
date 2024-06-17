package blackjack;

import java.util.Collection;
import java.util.Set;

public class Dealer implements User {
    @Override
    public void receiveCard(CardDeck cardDeck) {

    }

    @Override
    public Collection<Card> getCards() {
        return Set.of(new Card(CardShape.HEARTS, CardLetter.K));
    }
}
