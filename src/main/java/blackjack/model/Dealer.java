package blackjack.model;

public class Dealer implements User {
    final Hand hand;

    public Dealer(Hand hand) {
        this.hand = hand;
    }

    @Override
    public void setUpCard(CardDeck cardDeck) {
        for (int i = 0; i < 2; i++) {
            hand.add(cardDeck.pickCard());
        }
    }

    @Override
    public void receiveCard(CardDeck cardDeck, Points points) {
        if (hand.totalCardPoint(points) > 16) {
            throw new IllegalStateException("딜러의 점수가 16을 초과하여 카드를 더이상 받을 수 없습니다.");
        }

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

    @Override
    public Score isWinner(User other, Points points) {
        if (!(other instanceof Player)) {
            throw new IllegalArgumentException("딜러는 플레이어와만 승패를 비교할 수 있습니다.");
        }

        int playerPoints = getPoints(points);
        int dealerPoints = other.getPoints(points);

        if (isBurst(points) || other.isBurst(points) || playerPoints == dealerPoints) {
            return Score.draw;
        }

        if (playerPoints > dealerPoints) {
            return Score.win;
        }

        return Score.lose;
    }

    @Override
    public boolean isBurst(Points points) {
        return hand.isBurst(points);
    }

    @Override
    public int getPoints(Points points) {
        return hand.totalCardPoint(points);
    }
}
