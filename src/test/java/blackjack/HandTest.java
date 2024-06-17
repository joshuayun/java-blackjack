package blackjack;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class HandTest {
    @Test
    void add() {
        Hand hand = new Hand(Set.of());
        Card card = new Card(CardShape.HEARTS, CardLetter.KING);

        hand.add(card);

        int actual = hand.size();

        assertThat(actual).isEqualTo(1);
    }

    @Test
    void duplicateAdd() {
        Hand hand = new Hand(Set.of());
        Card card = new Card(CardShape.HEARTS, CardLetter.KING);
        Card duplicatedCard = new Card(CardShape.HEARTS, CardLetter.KING);

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
                new Card(CardShape.HEARTS, CardLetter.ACE),
                new Card(CardShape.DIAMONDS, CardLetter.KING),
                new Card(CardShape.SPADES, CardLetter.JACK)
        ));
        int actual = hand.totalCardPoint(cards -> 21);

        assertThat(actual).isEqualTo(21);
    }
}