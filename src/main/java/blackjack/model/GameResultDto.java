package blackjack.model;

import java.util.List;

public class GameResultDto {
    private final Dealer dealer;

    private final List<PlayerResultDto> playerResultDtos;

    public GameResultDto(Dealer dealer, List<PlayerResultDto> playerResultDtos) {
        this.dealer = dealer;
        this.playerResultDtos = playerResultDtos;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public List<PlayerResultDto> getPlayerResultDtos() {
        return playerResultDtos;
    }
}
