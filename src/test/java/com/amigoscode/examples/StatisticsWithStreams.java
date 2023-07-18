package com.amigoscode.examples;


import com.amigoscode.beans.Car;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Stream;

public class StatisticsWithStreams {

    @Test
    public void count() throws Exception {
        List<Car> cars = MockData.getCars();

        final long count = cars.size();
        System.out.println(count);

        //ou para usar metodo count
        final long countFilter = cars.stream().filter(car -> car.getPrice() < 20000).count();
        System.out.println(countFilter);

    }

    @Test
    public void min() throws Exception {
        List<Car> cars = MockData.getCars();

        //quando quero comparar por um field do Car, mas o Car não tem CompareTo, então usar Comparator.comparing(field)

        final Optional<Car> min = cars.stream().min(Comparator.comparing(Car::getYear));

        System.out.println(min.orElse(null));


    }

    @Test
    public void max() throws Exception {
        List<Car> cars = MockData.getCars();

        final Optional<Car> sorted = cars.stream().max(Comparator.comparing(Car::getPrice));

        System.out.println(sorted.orElse(null));

    }


    @Test
    public void average() throws Exception {
        List<Car> cars = MockData.getCars();

        //calcula o preco médio dos carros
        final double asDouble = cars.stream().mapToDouble(Car::getPrice).average().orElse(0.00);

        System.out.println(asDouble);
    }

    @Test
    public void sum() throws Exception {
        List<Car> cars = MockData.getCars();

        //calcula o valor total dos carros da concessionaria
        final double sum = cars.stream().mapToDouble(Car::getPrice).sum();

        System.out.println(sum);


    }

    @Test
    public void statistics() throws Exception {
        List<Car> cars = MockData.getCars();

        final DoubleSummaryStatistics intSummaryStatistics = cars.stream().mapToDouble(Car::getPrice).summaryStatistics();

        System.out.println(intSummaryStatistics);
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getAverage());
    }

}