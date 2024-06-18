package blackjack.model;

import java.util.List;

public class BlackJackGame {
    private List<Player> players;
    private Dealer dealer;
    private CalculatePoints calculatePoints;
    private CardDeck cardDeck;

    public BlackJackGame(List<Player> players, Dealer dealer, CalculatePoints calculatePoints) {
        this.players = players;
        this.dealer = dealer;
        this.calculatePoints = calculatePoints;
    }

    public GameResultDto play() {
        List<PlayerResultDto> playerResultDtos = players.stream().map(player -> {
                    Score score = player.getScore(dealer, calculatePoints);
                    return new PlayerResultDto(
                            player,
                            score
                    );
                })
                .toList();
        return new GameResultDto(
                dealer,
                playerResultDtos
        );
    }
}
