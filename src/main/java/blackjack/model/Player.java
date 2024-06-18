package blackjack.model;

import java.util.Set;
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
    public void receiveCard(CardDeck cardDeck, CalculatePoints calculatePoints) {
        if (hand.totalCardPoint(calculatePoints) > 21) {
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
    public Set<Card> getCards() {
        return hand.getCards();
    }

    public Score getScore(Dealer dealer, CalculatePoints calculatePoints) {
        int playerPoints = getPoints(calculatePoints);
        int dealerPoints = dealer.getPoints(calculatePoints);

        if ((isBurst(calculatePoints) && dealer.isBurst(calculatePoints))) {
            return Score.draw;
        }
        if (dealer.isBurst(calculatePoints)) {
            return Score.win;
        }
        if (isBurst(calculatePoints)) {
            return Score.lose;
        }
        if (playerPoints > dealerPoints) {
            return Score.win;
        }
        if (playerPoints == dealerPoints) {
            return Score.draw;
        }
        return Score.lose;
    }

    @Override
    public boolean isBurst(CalculatePoints calculatePoints) {
        return hand.isBurst(calculatePoints);
    }

    @Override
    public int getPoints(CalculatePoints calculatePoints) {
        return hand.totalCardPoint(calculatePoints);
    }
}
