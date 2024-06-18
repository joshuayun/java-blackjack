package blackjack.controller;

import blackjack.model.*;
import blackjack.view.InputView;
import blackjack.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BlackJackController {
    public void run() {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        List<String> names = inputView.inputPlayersName();

        CardDeck cardDeck = new TopCardDeck();
        CalculatePoints calculatePoints = new CalculateBlackJackPoints();
        Dealer dealer = new Dealer(new Hand());
        List<Player> players = names.stream()
                .map(name -> new Player(name, new Hand()))
                .peek(player -> player.setUpCard(cardDeck))
                .collect(Collectors.toList());
        BlackJackGame blackJackGame = new BlackJackGame(players, dealer, calculatePoints);

        dealer.setUpCard(cardDeck);
        outputView.printHandStatus(dealer, new ArrayList<>(players));

        players.forEach(player -> {
            boolean canReceiveCard = !player.isBurst(calculatePoints);
            while (canReceiveCard) {
                canReceiveCard = inputView.inputAdditionalCardCondition(player.getName());
                if (canReceiveCard) {
                    player.receiveCard(cardDeck, calculatePoints);
                    canReceiveCard = !player.isBurst(calculatePoints);
                }
                outputView.printUserHandStasus(player);
            }
        });

        boolean canDealerReceivedCard = dealer.getPoints(calculatePoints) < 16 && !dealer.isBurst(calculatePoints);

        while (canDealerReceivedCard) {
            outputView.printDealerReceivedCard();
            dealer.receiveCard(cardDeck, calculatePoints);

            canDealerReceivedCard = dealer.getPoints(calculatePoints) < 16 && !dealer.isBurst(calculatePoints);
        }

        outputView.printUserHandResult(dealer, calculatePoints);
        players.forEach(player -> outputView.printUserHandResult(player, calculatePoints));

        GameResultDto gameResultDto = blackJackGame.play();
        outputView.printGameResult(gameResultDto);
    }
}
