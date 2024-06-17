package blackjack.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CardDeckTest {

    @Test
    void cardDeckTest() {
        Card card = new Card(CardShape.HEARTS, CardLetter.KING);
        CardDeck cardDeck = () -> card;

        Card actual = cardDeck.pickCard();

        assertThat(actual.getLetter()).isEqualTo(CardLetter.KING);
    }
}