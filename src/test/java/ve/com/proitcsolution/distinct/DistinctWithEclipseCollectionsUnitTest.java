package ve.com.proitcsolution.distinct;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.utility.ListIterate;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ve.com.proitcsolution.distinct.util.PersonDataGenerator;
import ve.com.proitcsolution.dto.Person;

public class DistinctWithEclipseCollectionsUnitTest {
  static List<Person> personList;

  @BeforeAll
  public static void init() {
    personList = PersonDataGenerator.getPersonListWithFakeValues();
  }

  @Test
  public void whenFilterListByName_thenSizeShouldBe4() {
    List<Person> personListFiltered =
        ListIterate.distinct(personList, HashingStrategies.fromFunction(Person::getName));
    assertTrue(personListFiltered.size() == 4);
  }

  @Test
  public void whenFilterListByAge_thenSizeShouldBe2() {
    List<Person> personListFiltered =
        ListIterate.distinct(personList, HashingStrategies.fromIntFunction(Person::getAge));
    assertTrue(personListFiltered.size() == 2);
  }

}
