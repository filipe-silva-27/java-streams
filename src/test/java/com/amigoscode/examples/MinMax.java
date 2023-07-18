package com.amigoscode.examples;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MinMax {

    @Test
    public void min() {
        List<Integer> numbers = List.of(1, 2, 3, 100, 23, 93, 99);

        final Optional<Integer> min = numbers.stream().min(Integer::compareTo);

        System.out.println(min);

        assert min.get().equals(1);
    }

    @Test
    public void max() {
        List<Integer> numbers = List.of(1, 2, 3, 100, 23, 93, 99);

        final Optional<Integer> max = numbers.stream().max(Integer::compareTo);

        System.out.println(max);

        assert max.get().equals(100);
    }
}
