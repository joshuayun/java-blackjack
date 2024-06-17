package blackjack;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class HandTest {
    @Test
    void add() {
        Hand hand = new Hand(Set.of());
        Card card = new Card(CardShape.HEARTS, CardLetter.K);

        hand.add(card);

        int actual = hand.size();

        assertThat(actual).isEqualTo(1);
    }

    @Test
    void duplicateAdd() {
        Hand hand = new Hand(Set.of());
        Card card = new Card(CardShape.HEARTS, CardLetter.K);
        Card duplicatedCard = new Card(CardShape.HEARTS, CardLetter.K);

        hand.add(card);

        assertThatIllegalArgumentException().isThrownBy(() -> hand.add(duplicatedCard));
    }

    @Test
    void size() {
        Hand hand = new Hand(Set.of());
        int actual = hand.size();

        assertThat(actual).isEqualTo(0);
    }

    @Test
    void totalCardPoint() {
        Hand hand = new Hand(Set.of(
                new Card(CardShape.HEARTS, CardLetter.A),
                new Card(CardShape.DIAMONDS, CardLetter.K),
                new Card(CardShape.SPADES, CardLetter.J)
        ));
        int actual = hand.totalCardPoint(cards -> 21);

        assertThat(actual).isEqualTo(21);
    }
}