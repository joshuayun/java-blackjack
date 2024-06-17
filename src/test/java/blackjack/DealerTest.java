package blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DealerTest {

    @Test
    void dealerTest() {
        Dealer dealer = new Dealer();
        CardDeck cardDeck = () -> new Card(CardShape.하트, CardLetter.K);

        dealer.receiveCard(cardDeck);

        assertThat(dealer.getCards().size()).isEqualTo(1);

    }

}