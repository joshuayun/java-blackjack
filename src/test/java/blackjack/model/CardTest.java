package blackjack.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CardTest {
    @Test
    void duplicateCardTest() {
        Card actual = new Card(CardShape.HEARTS, CardLetter.FOUR);
        Card expected = new Card(CardShape.HEARTS, CardLetter.FOUR);

        assertThat(actual).isEqualTo(expected);
    }
}