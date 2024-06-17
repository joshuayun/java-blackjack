package blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DealerTest {

    @Test
    void dealerTest() {
        Dealer dealer = new Dealer();
        CardDeck cardDeck = () -> new Card(CardShape.HEARTS, CardLetter.KING);

        dealer.receiveCard(cardDeck);

        assertThat(dealer.getCards().size()).isEqualTo(1);

    }

}