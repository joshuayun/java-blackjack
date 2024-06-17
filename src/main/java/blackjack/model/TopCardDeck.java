package blackjack.model;


import java.util.*;
import java.util.stream.Collectors;

public class TopCardDeck implements CardDeck {
    private final List<Card> cards;

    public TopCardDeck() {
        cards = Arrays.stream(CardShape.values())
                .flatMap(cardShape -> Arrays.stream(CardLetter.values())
                        .map(cardLetter -> new Card(cardShape, cardLetter))
                )
                .collect(Collectors.toList());
    }

    @Override
    public Card pickCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("모든 카드를 뽑았습니다.");
        }

        return cards.remove(0);
    }

    @Override
    public boolean contains(Card card) {
        return cards.contains(card);
    }
}
