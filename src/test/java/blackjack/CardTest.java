package blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CardTest {
    @Test
    void duplicateCardTest() {
        Card actual = new Card(CardShape.HEARTS, CardLetter.FOUR);
        Card expected = new Card(CardShape.HEARTS, CardLetter.FOUR);

        assertThat(actual).isEqualTo(expected);
    }
}