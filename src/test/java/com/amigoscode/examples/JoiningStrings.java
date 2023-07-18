package com.amigoscode.examples;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class JoiningStrings {

    @Test
    public void joiningStrings() throws Exception {
        List<String> names = List.of("anna", "john", "marcos", "helena", "yasmin");
        // "Anna, John, Marcos, Helena, Yasmin"

    }

    @Test
    public void joiningStringsWithStream() throws Exception {
        List<String> names = List.of("anna", "john", "marcos", "helena", "yasmin");
        // "Anna, John, Marcos, Helena, Yasmin"

        final String joinedStrings = names.stream().reduce("", (acc, string) -> acc.concat(string));
        System.out.println(joinedStrings);

        final String joinedStrings2 = names.stream().reduce("", String::concat);
        System.out.println(joinedStrings2);

        assert joinedStrings2.equals(joinedStrings);

    }

}
