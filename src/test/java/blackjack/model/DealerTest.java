package blackjack.model;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class DealerTest {

    @Test
    void dealerTest() {
        Dealer dealer = new Dealer(new Hand(Set.of()));
        Card actual = new Card(CardShape.HEARTS, CardLetter.KING);
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

        dealer.receiveCard(cardDeck, cards -> cards.stream().mapToInt(card -> card.getLetter().getPoint()).sum());

        assertThat(dealer.contains(actual)).isTrue();

    }

    @Test
    void setUpCardTest() {
        Card actual1 = new Card(CardShape.HEARTS, CardLetter.QUEEN);
        Card actual2 = new Card(CardShape.CLUBS, CardLetter.QUEEN);
        Dealer dealer = new Dealer(new Hand());
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

        dealer.setUpCard(cardDeck);

        assertThat(dealer.contains(actual1)).isTrue();
        assertThat(dealer.contains(actual2)).isTrue();
    }
}