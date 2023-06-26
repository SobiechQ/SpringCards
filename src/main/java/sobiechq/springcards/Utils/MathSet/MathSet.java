package sobiechq.springcards.Utils.MathSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

public class MathSet<E> extends HashSet<E> {
    public MathSet() {
    }
    public MathSet(Collection<? extends E> c) {
        super(c);
    }

    public MathSet(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    public MathSet(int initialCapacity) {
        super(initialCapacity);
    }

    public <R> MathSet<Pair<E, R>> cartesianProduct(Collection<R> c){
        return this.stream()
                .flatMap(e -> c.stream()
                        .map(c1 ->new Pair<>(e, c1)))
                .collect(Collectors.toCollection(MathSet::new));
    }
}
