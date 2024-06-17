package blackjack.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TopCardDeckTest {
    @Test
    void constructorTest() {
        CardDeck cardDeck = new TopCardDeck();
        Card actual = new Card(CardShape.CLUBS, CardLetter.ACE);

        assertThat(cardDeck.contains(actual)).isTrue();
    }

    @Test
    void pickCardTest() {
        CardDeck cardDeck = new TopCardDeck();
        Card actual = cardDeck.pickCard();

        assertThat(cardDeck.contains(actual)).isFalse();
    }
}