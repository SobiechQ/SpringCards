package sobiechq.springcards.GameLogic.Deck;

import sobiechq.springcards.Utils.MathSet.MathSet;
import sobiechq.springcards.Utils.MathSet.Pair;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Deck implements Iterable<Card>{
    public List<Card> cards = new LinkedList<>();
    public Deck(){

    }
    public void shuffle(){
        this.cards = new MathSet<>(Arrays.stream(CardColor.values()).toList())
                    .cartesianProduct(
                            new MathSet<>(
                                    Arrays.stream(CardValue.values()).toList())
                            ).stream()
                .map(p -> new Card(p.left(), p.right()))
                .distinct()
                .collect(Collectors.toCollection(LinkedList::new));
        Collections.shuffle(cards);
    }

    @Override
    public Iterator<Card> iterator() {
        return cards.iterator();
    }
}
