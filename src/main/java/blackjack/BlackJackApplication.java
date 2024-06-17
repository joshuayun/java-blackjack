package blackjack;

import blackjack.model.*;
import blackjack.view.InputView;
import blackjack.view.OutputView;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BlackJackApplication {

    private static InputView inputView;
    private static OutputView outputView;

    public static void main(String[] args) {
        inputView = new InputView();
        outputView = new OutputView();

        List<String> names = inputView.inputPlayersName();

        User dealer = new Dealer(new Hand(Set.of(new Card(CardShape.CLUBS, CardLetter.ACE))));
        List<User> players = names.stream().map(name -> new Player(name, new Hand(Set.of(new Card(CardShape.CLUBS, CardLetter.ACE))))).collect(Collectors.toList());
        outputView.printHandStatus(dealer, players);
        //boolean additionalCardCondition = inputView.inputAdditionalCardCondition();
    }
}
