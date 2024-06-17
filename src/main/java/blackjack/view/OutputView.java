package blackjack.view;

import blackjack.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public void printHandStatus(User dealer, List<User> players) {
        System.out.println("딜러와 "
                + players.stream().map(User::getName).collect(Collectors.joining(","))
                + "에게 2장을 나누었습니다.");
        System.out.println("딜러: " + dealer.openCard());

        players.forEach(
                player -> System.out.println(player.getName() + "카드: " + player.openCard())
        );

    }
}
