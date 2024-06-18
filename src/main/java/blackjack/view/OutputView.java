package blackjack.view;

import blackjack.model.*;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public void printHandStatus(User dealer, List<User> players) {
        System.out.println("딜러와 "
                + players.stream().map(User::getName).collect(Collectors.joining(","))
                + "에게 2장을 나누었습니다.");
        printUserHandStasus(dealer);
        players.forEach(this::printUserHandStasus);
    }

    public void printUserHandStasus(User user) {
        String handStatus = "";

        if (user instanceof Dealer) {
            handStatus += user.getCards().stream().toList().get(0).getCard();
        } else {
            handStatus += user.getCards().stream().map(Card::getCard).collect(Collectors.joining(", "));
        }

        System.out.println(user.getName() + " 카드 : " + handStatus);
    }

    public void printDealerReceivedCard() {
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
    }

    public void printUserHandResult(User user, CalculatePoints calculatePoints) {
        String handResult = user.getCards().stream().map(Card::getCard).collect(Collectors.joining(", "));

        System.out.println(user.getName() + " 카드 : " + handResult + " - 결과: " + user.getPoints(calculatePoints));
    }

    public void printGameResult(GameResultDto gameResultDto) {
        List<Score> playerScores = gameResultDto.getPlayerResultDtos().stream()
                .map(PlayerResultDto::getScore)
                .toList();
        long dealerWinCount = getScoreCount(playerScores, Score.lose);
        long drawCount = getScoreCount(playerScores, Score.draw);
        long dealerLoseCount = getScoreCount(playerScores, Score.win);

        System.out.println("## 최종 승패");
        System.out.println(gameResultDto.getDealer().getName() + ": " + dealerWinCount + " " + Score.win + " " + drawCount +  " " + Score.draw + " " + dealerLoseCount +  " " + Score.lose + " ");
        gameResultDto.getPlayerResultDtos()
                .forEach(playerResultDto -> System.out.println(playerResultDto.getPlayer().getName() + ": " + playerResultDto.getScore().name()));
    }

    private long getScoreCount(List<Score> scores, Score expectedScore) {
        return scores.stream()
                .filter(expectedScore::equals)
                .count();
    }
}
