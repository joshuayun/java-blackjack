package blackjack.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BlackJackPointsTest {
    @ParameterizedTest
    @MethodSource("generateCards")
    void calculate(final Set<Card> cards, final int expectedScore) {
        BlackJackPoints blackJackPoints = new BlackJackPoints();
        int actual = blackJackPoints.calculate(cards);

        assertThat(actual).isEqualTo(expectedScore);
    }

    private static Stream<Arguments> generateCards() {
        return Stream.of(
                Arguments.of(
                        Set.of(
                                new Card(CardShape.CLUBS, CardLetter.ACE),
                                new Card(CardShape.CLUBS, CardLetter.JACK),
                                new Card(CardShape.CLUBS, CardLetter.KING)
                        ),
                        21
                ),
                Arguments.of(
                        Set.of(
                                new Card(CardShape.CLUBS, CardLetter.ACE),
                                new Card(CardShape.CLUBS, CardLetter.TWO),
                                new Card(CardShape.CLUBS, CardLetter.THREE)
                        ),
                        16
                ),
                Arguments.of(
                        Set.of(
                                new Card(CardShape.CLUBS, CardLetter.ACE),
                                new Card(CardShape.CLUBS, CardLetter.KING),
                                new Card(CardShape.CLUBS, CardLetter.NINE)
                        ),
                        20
                )
        );
    }
}