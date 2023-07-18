package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Filtering {

    @Test
    public void filter() throws Exception {
        //yellow cars less than 20k
        List<Car> cars = MockData.getCars();

        final Predicate<Car> pricePredicate = car -> car.getPrice() < 20_000.00;
        final Predicate<Car> colorPredicate = c -> c.getColor().equals("Yellow");

        List<Car> carsYellowUnder20k = cars.stream()
                .filter(colorPredicate)
                .filter(pricePredicate)
                .toList();

        carsYellowUnder20k.forEach(System.out::println);

    }

    @Test
    public void dropWhile() throws Exception {      //dropWhile() to filter down further, telling the iterator to drop values before a expression
        System.out.println("using filter");
        final List<Integer> integers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter(n -> n % 2 == 0)
                .toList();
        System.out.println(integers);

        System.out.println("\n using dropWhile");
        final List<Integer> integersDropWhile = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .dropWhile(n -> n % 2 != 0)                 //é como o contrário do filtro, um exclude por assim dizer
                .toList();
        System.out.println(integersDropWhile);

    }

    @Test
    public void takeWhile() throws Exception {
        // using filter
        System.out.println("using filter");
        Stream.of(2, 4, 6, 8, 9, 10, 12).filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));

        System.out.println();
        System.out.println("using take while");
    }

    @Test
    public void findFirst() throws Exception {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        final OptionalInt first = Arrays.stream(numbers).filter(n -> n % 2 == 0).findFirst();

        System.out.println(first.orElse(0));
    }

    @Test
    public void findAny() throws Exception {
        // Might not return the same entry every time, but is faster to perform!

        int[] numbers = {1, 3, 4, 5, 6, 7, 8, 9, 2, 9, 10};

        final OptionalInt any = Arrays.stream(numbers).filter(n -> n % 2 == 0).findAny();

        System.out.println(any.orElse(-1));
    }

    @Test
    public void allMatch() throws Exception {
        int[] even = {2, 4, 6, 8, 10};

        final boolean allEven = Arrays.stream(even).allMatch(n -> n % 2 == 0);

        System.out.println(allEven);

    }

    @Test
    public void anyMatch() throws Exception {
        int[] evenAndOneOdd = {2, 4, 6, 8, 10, 11};

        final boolean anyOdd = Arrays.stream(evenAndOneOdd).anyMatch(n -> n % 2 == 0);

        System.out.println(anyOdd);

    }

    //findAny and anyMatch do the same job internally, but their return value is different.
    // Stream#anyMatch() returns a boolean while Stream#findAny() returns an object which matches the predicate.

}



