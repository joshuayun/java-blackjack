package blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DealerTest {

    @Test
    void dealerTest() {
        Dealer dealer = new Dealer();
        CardDeck cardDeck = new CardDeck() {
            @Override
            public Card pickCard() {
                return new Card("하트", "K");
            }
        };

        dealer.receiveCard(cardDeck);

        assertThat(dealer.getCards().size()).isEqualTo(1);

    }

}