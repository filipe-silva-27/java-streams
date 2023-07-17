package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.beans.PersonDTO;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TransformationsMapAndReduce {

    @Test
    void yourFirstTransformationWithMap() throws IOException {
        //transform from Person to PersonDTO

        List<Person> people = MockData.getPeople();

        final Function<Person, PersonDTO> personPersonDTOFunction = person ->                      //ctrl + P para ver o que recebe por argumento
                new PersonDTO(person.getId(), person.getFirstName(), person.getAge());

        /*              ALTERNATIVA

        *
        * List<PersonDTO> dtos = people.stream()
                .map(personPersonDTOFunction)
                .toList();
        *
        * */

        List<PersonDTO> dtos = people.stream()
                .map(PersonDTO::map)
                .toList();

        assertThat(people.size()).isEqualTo(dtos.size());

        dtos.forEach(System.out::println);

    }

    @Test
    void mapToDoubleAndFindAverageCarPrice() throws IOException {
        List<Car> cars = MockData.getCars();

        double averageCarPrice = cars.stream().mapToDouble(Car::getPrice).average().orElse(-1.00);

        System.out.println(averageCarPrice);

    }

    @Test
    public void reduce() {
        int[] integers = {1, 2, 3, 4, 99};

        //0 é o valor starting point (o primeiro valor de "start") e
        // com o sum, o reduce "reduz apenas a um Integer" ou seja acumula ao starting point
        // (uma vez que é a Stream é de Integer)
        final int integersSum = Arrays.stream(integers).reduce(0, Integer::sum);
        final int integersSum2 = Arrays.stream(integers).reduce(0, (start, x) -> start + x);

        System.out.println(integersSum);

        assertThat(integersSum).isEqualTo(109);

    }
}

