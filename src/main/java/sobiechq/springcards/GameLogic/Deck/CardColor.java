package sobiechq.springcards.GameLogic.Deck;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CardColor {
    SPADES(1), HEARTS(2), DIAMONDS(4), CLUBS(8);
    private final int colorId;
}
