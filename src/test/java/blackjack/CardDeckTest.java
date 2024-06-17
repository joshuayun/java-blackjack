package blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CardDeckTest {

    @Test
    void cardDeckTest() {
        Card card = new Card(CardShape.HEARTS, CardLetter.K);
        CardDeck cardDeck = new CardDeck() {
            @Override
            public Card pickCard() {
                return card;
            }
        };

        Card actual = cardDeck.pickCard();

        assertThat(actual.getLetter()).isEqualTo(CardLetter.K);
    }
}