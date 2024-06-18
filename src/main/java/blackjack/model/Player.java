package blackjack.model;

import java.util.stream.Collectors;

public class Player implements User {

    final String name;

    final Hand hand;


    public Player(String name, Hand hand) {
        this.name = name.trim();
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
        if (hand.totalCardPoint(points) > 21) {
            throw new IllegalStateException("해당 플레이어의 점수가 21을 넘어 더이상 카드를 받을 수 없습니다.");
        }

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

    public Score getScore(Dealer dealer, Points points) {

        int playerPoints = getPoints(points);
        int dealerPoints = dealer.getPoints(points);

        if (isBurst(points) || dealer.isBurst(points) || playerPoints == dealerPoints) {
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
