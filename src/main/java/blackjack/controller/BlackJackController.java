package blackjack.controller;

import blackjack.model.*;
import blackjack.view.InputView;
import blackjack.view.OutputView;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BlackJackController {

    private static BlackJackGame blackJackGame;
    private static Player player;
    private static Player player2;

    private static  CardDeck cardDeck;

    public void run() {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        List<String> names = inputView.inputPlayersName();

        CardDeck cardDeck = new TopCardDeck();
        Points points = new BlackJackPoints();
        User dealer = new Dealer(new Hand());
        List<User> players = names.stream()
                .map(name -> new Player(name, new Hand()))
                .peek(player -> player.setUpCard(cardDeck))
                .collect(Collectors.toList());

        dealer.setUpCard(cardDeck);
        outputView.printHandStatus(dealer, players);

        players.forEach(player -> {
            boolean canReceiveCard = !player.isBurst(points);
            while (canReceiveCard) {
                canReceiveCard = inputView.inputAdditionalCardCondition(player.getName());
                if (canReceiveCard) {
                    player.receiveCard(cardDeck, points);
                    canReceiveCard = !player.isBurst(points);
                }
                outputView.printUserHandStasus(player);
            }
        });



        //boolean additionalCardCondition = inputView.inputAdditionalCardCondition();



    }

}
