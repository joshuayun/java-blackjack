package blackjack.model;

import java.util.stream.Collectors;

public class Player implements User{

    final String name;

    final Hand hand;

    public Player(String name, Hand hand) {
        this.name = name;
        this.hand = hand;
    }

    @Override
    public void receiveCard(CardDeck cardDeck) {
        hand.add(cardDeck.pickCard());
    }

    @Override
    public boolean contains(Card card) {
        return hand.contains(card);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String openCard() {
        return hand.getCards().stream().map(Card::getCard).collect(Collectors.joining(","));
    }
}
