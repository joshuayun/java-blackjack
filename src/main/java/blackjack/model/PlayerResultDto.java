package blackjack.model;

public class PlayerResultDto {
    private final Player player;

    private final Score score;


    public PlayerResultDto(Player player, Score score) {
        this.player = player;
        this.score = score;
    }

    public Player getPlayer() {
        return player;
    }

    public Score getScore() {
        return score;
    }
}
