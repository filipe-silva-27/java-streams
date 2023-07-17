package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.beans.PersonDTO;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TransformationsMapAndReduce {

    @Test
    void yourFirstTransformationWithMap() throws IOException {
        //transform from Person to PersonDTO

        List<Person> people = MockData.getPeople();

        final Function<Person, PersonDTO> personPersonDTOFunction = person ->                      //ctrl + P para ver o que recebe por argumento
                new PersonDTO(person.getId(), person.getFirstName(), person.getAge());


        List<PersonDTO> dtos = people.stream()
                .map(PersonDTO::map)
                .toList();

        /*              ALTERNATIVA
        *
        * List<PersonDTO> dtos = people.stream()
                .map(personPersonDTOFunction)
                .toList();
        *
        * */

        assertThat(people.size()).isEqualTo(dtos.size());

        dtos.forEach(System.out::println);

    }

    @Test
    void mapToDoubleAndFindAverageCarPrice() throws IOException {
        List<Car> cars = MockData.getCars();
    }

    @Test
    public void reduce() {
        int[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};
    }
}

