package blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CardDeckTest {

    @Test
    void cardDeckTest() {
        Card card = new Card("하트", "K");
        CardDeck cardDeck = new CardDeck() {
            @Override
            public Card pickCard() {
                return card;
            }
        };

        Card actual = cardDeck.pickCard();

        assertThat(actual.getLetter()).isEqualTo("K");
    }
}