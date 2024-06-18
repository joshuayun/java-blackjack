package blackjack.model;

import java.util.List;

public class BlackJackGame {
    private List<Player> players;
    private Dealer dealer;
    private Points points;
    private CardDeck cardDeck;

    public BlackJackGame(List<Player> players, Dealer dealer) {
        this.players = players;
        this.dealer = dealer;
    }


}
