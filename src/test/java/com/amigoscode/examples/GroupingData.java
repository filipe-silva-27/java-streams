package com.amigoscode.examples;


import com.amigoscode.beans.Car;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingData {

    //fazem se groups no collect()

    @Test
    public void simpleGrouping() throws Exception {
        List<Car> cars = MockData.getCars();

        //ATENÇÃO!!!! isto fica num Map e não numa list
        final Map<String, List<Car>> collectionByMake = cars.stream().collect(Collectors.groupingBy(Car::getMake));

        collectionByMake.forEach((make,groupedCars) -> {        //percorre mapa!
            System.out.println("Cars from make " + make + ":");
            groupedCars.forEach(System.out::println);
        });
    }

    @Test
    public void groupingAndCounting() throws Exception {
        List<String> names = List.of(
                "John",
                "John",
                "Mariam",
                "Alex",
                "Mohammado",
                "Mohammado",
                "Vincent",
                "Alex",
                "Alex"
        );

        Map<String, Long> map = names.stream()
                .collect(Collectors.groupingBy(
                                    Function.identity(),
                                    Collectors.counting()
                        )
                );
    }

}