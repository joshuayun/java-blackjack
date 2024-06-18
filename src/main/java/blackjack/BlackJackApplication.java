package blackjack;

import blackjack.controller.BlackJackController;
import blackjack.model.*;
import blackjack.view.InputView;
import blackjack.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class BlackJackApplication {

    public static void main(String[] args) {
        BlackJackController blackJackController = new BlackJackController();
        blackJackController.run();
    }
}
