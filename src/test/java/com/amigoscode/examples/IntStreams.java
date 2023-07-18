package com.amigoscode.examples;


import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreams {

    @Test
    public void range() throws Exception {
    }

    // Loop through people using IntStream
    @Test
    public void rangeIteratingLists() throws Exception {
        List<Person> people = MockData.getPeople();

        IntStream.range(0, people.size()).forEach(personId -> System.out.println(people.get(personId)));

        //ainda não percebi a aplicabilidade disto, uma vez que podemos fazer
        //que como é people.size() até nem precisamos do limit

        //pelo que percebi a aplicabilidade é a mesma quando discutimos
        //for vs foreach aka for ( ; ; ) ou for ( : )

        people.stream().limit(people.size()).forEach(System.out::println);
    }

    @Test
    public void intStreamIterate()  {
        //bem, o iterate parece fazer o mesmo que range
        IntStream.iterate(0, value -> ++value)
                .limit(11)  // Exclusive, so this loop will print out 10 but not 11!
                .forEach(System.out::println);
    }
}
