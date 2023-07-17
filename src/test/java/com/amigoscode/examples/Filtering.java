package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Filtering {

    @Test
    public void filter() throws Exception {
        //yellow cars less than 20k
        List<Car> cars = MockData.getCars();

        final Predicate<Car> colorPredicate = c -> c.getColor().equals("Yellow");
        final Predicate<Car> pricePredicate = car -> car.getPrice() < 20_000.00;

        List<Car> carsYellowLess20k = cars.stream()
                .filter(colorPredicate)
                .filter(pricePredicate)
                .toList();

        carsYellowLess20k.forEach(System.out::println);

    }

    @Test
    public void dropWhile() throws Exception {
        System.out.println("using filter");

        System.out.println();
        System.out.println("using dropWhile");
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
    }

    @Test
    public void findAny() throws Exception {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 10};
    }

    @Test
    public void allMatch() throws Exception {
        int[] even = {2, 4, 6, 8, 10};
    }

    @Test
    public void anyMatch() throws Exception {
        int[] evenAndOneOdd = {2, 4, 6, 8, 10, 11};
    }

}



