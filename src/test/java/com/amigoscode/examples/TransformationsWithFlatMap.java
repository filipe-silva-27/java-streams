package com.amigoscode.examples;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TransformationsWithFlatMap {

    private static final List<List<String>> arrayListOfNames = List.of(
            List.of("Mariam", "Alex", "Ismail"),
            List.of("John", "Alesha", "Andre"),
            List.of("Susy", "Ali")
    );

    @BeforeEach
    void setUp() {
        System.out.println(arrayListOfNames);
    }

    @Test
    public void withoutFlatMap() throws Exception {
        // [Mariam, Alex, Ismail, John, Alesha, Andre, Susy, Ali]
        List<String> names = new ArrayList<>();
    }

    @Test
    public void withFlatMap() throws Exception {
        // Passar de uma lista de listas para uma lista só:
        // [Maria, Alex, Ismail, John, Alesha, Andre, Susy, Ali]

        List<String> flattedList = arrayListOfNames.stream().flatMap(List::stream).collect(Collectors.toList());

        System.out.println(flattedList);

    }

    @Test
    public void flatMapWithOptionals() {
        List<Optional<String>> optionals = List.of(
                Optional.of("Amigos"),
                Optional.of("Code"),
                Optional.ofNullable(null)
        );

        System.out.println(optionals);

        final List<String> flattedOptionals = optionals.stream().flatMap(Optional::stream).toList();

        System.out.println(flattedOptionals);

    }
}

