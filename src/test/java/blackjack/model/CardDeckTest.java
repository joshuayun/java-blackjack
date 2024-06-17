package blackjack.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CardDeckTest {

    @Test
    void cardDeckTest() {
        Card card = new Card(CardShape.HEARTS, CardLetter.KING);
        CardDeck cardDeck = new CardDeck() {
            @Override
            public Card pickCard() {
                return card;
            }

            @Override
            public boolean contains(Card card) {
                return false;
            }
        };

        Card actual = cardDeck.pickCard();

        assertThat(actual.getLetter()).isEqualTo(CardLetter.KING);
    }
}