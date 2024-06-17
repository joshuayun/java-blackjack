package blackjack.model;

public class Dealer implements User {
    final Hand hand;

    public Dealer(Hand hand) {
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
        return "dealer";
    }

    @Override
    public String openCard() {
        Card card = hand.getCards().stream().findFirst().orElseThrow(() -> new IllegalStateException("카드가 없습니다."));
        return card.getCard();
    }
}
