package blackjack.model;

import java.util.Set;

public interface Points {
    int calculate(Set<Card> cards);
}
