package blackjack;

import blackjack.model.*;
import blackjack.view.InputView;
import blackjack.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class BlackJackApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        List<String> names = inputView.inputPlayersName();

        CardDeck cardDeck = new TopCardDeck();
        User dealer = new Dealer(new Hand());
        List<User> players = names.stream()
                .map(name -> new Player(name, new Hand()))
                .peek(player -> player.setUpCard(cardDeck))
                .collect(Collectors.toList());

        dealer.setUpCard(cardDeck);

        outputView.printHandStatus(dealer, players);
        //boolean additionalCardCondition = inputView.inputAdditionalCardCondition();
    }
}
