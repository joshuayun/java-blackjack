package blackjack.model;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    @Test
    void playerTest() {
        Player player = new Player("james", new Hand(Set.of()));

        String actual = player.getName();
        assertThat(actual).isEqualTo("james");
    }

    @Test
    void receiveCardTest() {
        Card actual = new Card(CardShape.HEARTS, CardLetter.QUEEN);
        Player player = new Player("james", new Hand());
        CardDeck cardDeck = new CardDeck() {
            @Override
            public Card pickCard() {
                return actual;
            }

            @Override
            public boolean contains(Card card) {
                return false;
            }
        };

        player.receiveCard(cardDeck, cards -> cards.stream().mapToInt(card -> card.getLetter().getPoint()).sum());

        assertThat(player.contains(actual)).isTrue();
    }

    @Test
    void setUpCardTest() {
        Card actual1 = new Card(CardShape.HEARTS, CardLetter.QUEEN);
        Card actual2 = new Card(CardShape.CLUBS, CardLetter.QUEEN);
        Player player = new Player("james", new Hand());
        CardDeck cardDeck = new CardDeck() {
            private List<Card> cards = List.of(actual1, actual2);

            @Override
            public Card pickCard() {
                Card card = cards.get(0);

                cards = cards.subList(1, cards.size());

                return card;
            }

            @Override
            public boolean contains(Card card) {
                return cards.contains(card);
            }
        };

        player.setUpCard(cardDeck);

        assertThat(player.contains(actual1)).isTrue();
        assertThat(player.contains(actual2)).isTrue();
    }
}