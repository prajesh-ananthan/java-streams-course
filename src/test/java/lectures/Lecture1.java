package lectures;

import beans.Person;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import mockdata.MockData;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


public class Lecture1 {

  @Test
  public void imperativeApproach() throws IOException {
    List<Person> people = MockData.getPeople();
    // 1. Find people aged less or equal 18
    // 2. Then change implementation to find first 10 people

    List<Person> youngPeople = Lists.newArrayList();
    final int LIMIT = 10;
    int counter = 0;

    for (Person p : youngPeople) {
      if (p.getAge() <= 18) {
        youngPeople.add(p);
        counter++;
        if (counter == LIMIT) {
          break;
        }
      }
    }
  }

  @Test
  public void declarativeApproachUsingStreams() throws Exception {
    ImmutableList<Person> people = MockData.getPeople();

    List<Person> youngPeople = people.stream()
        .filter(person -> person.getAge() <= 18)
        .limit(10)
        .collect(Collectors.toList());

    youngPeople.forEach(System.out::println);

  }
}
