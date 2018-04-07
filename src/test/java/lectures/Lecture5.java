package lectures;


import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import mockdata.MockData;
import org.junit.Test;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lecture5 {

  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();
    List<Car> carsFiltered = cars.stream()
        .filter(car -> car.getPrice() < 10000)
        .collect(Collectors.toList());

    carsFiltered.forEach(System.out::println);

  }

  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
    List<Person> people = MockData.getPeople();

    Function<Person, PersonDTO> personToPersonDtofunction = person -> new PersonDTO(person.getId(), person.getFirstName(), person.getAge());

//    List<PersonDTO> collectorsDTO = people.stream()
//        .map(person -> new PersonDTO(person.getId(), person.getFirstName(), person.getAge()))
//        .collect(Collectors.toList());

    List<PersonDTO> collectorsDTO = people.stream()
        .map(PersonDTO::map)
        .collect(Collectors.toList());


    collectorsDTO.forEach(System.out::println);

  }

  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices

  }

  @Test
  public void test() throws Exception {

  }
}



