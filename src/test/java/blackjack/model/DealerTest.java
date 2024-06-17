package blackjack.model;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class DealerTest {

    @Test
    void dealerTest() {
        Dealer dealer = new Dealer(new Hand(Set.of()));
        Card card = new Card(CardShape.HEARTS, CardLetter.KING);
        CardDeck cardDeck = () -> card;

        dealer.receiveCard(cardDeck);

        assertThat(dealer.contains(card)).isTrue();

    }

}