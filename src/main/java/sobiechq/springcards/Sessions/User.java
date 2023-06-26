package sobiechq.springcards.Sessions;

import lombok.Data;
import sobiechq.springcards.GameLogic.Deck.Deck;
import sobiechq.springcards.GameLogic.Deck.Hand;

@Data
public class User {
    private final String nickname;
    private int money = 0;
    private final Hand hand = new Hand();
}
