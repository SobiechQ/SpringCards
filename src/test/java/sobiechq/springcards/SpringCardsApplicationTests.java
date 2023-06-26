package sobiechq.springcards;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sobiechq.springcards.GameLogic.Deck.CardColor;
import sobiechq.springcards.GameLogic.Deck.CardValue;
import sobiechq.springcards.GameLogic.Deck.Deck;
import sobiechq.springcards.Utils.MathSet.MathSet;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class SpringCardsApplicationTests {

    @Test
    void contextLoads() {
        Deck deck = new Deck();
        deck.shuffle();
        deck.forEach(System.out::println);

    }
}
