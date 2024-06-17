package blackjack.model;

import org.junit.jupiter.api.Test;

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
        Player player = new Player("james", new Hand(Set.of()));
        CardDeck cardDeck = () -> new Card(CardShape.HEARTS, CardLetter.QUEEN);

        player.receiveCard(cardDeck);



    }
}