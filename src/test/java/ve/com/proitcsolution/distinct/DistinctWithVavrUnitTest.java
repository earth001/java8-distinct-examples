package ve.com.proitcsolution.distinct;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ve.com.proitcsolution.distinct.util.PersonDataGenerator;
import ve.com.proitcsolution.dto.Person;

public class DistinctWithVavrUnitTest {
    static List<Person> personList;

    @BeforeAll
    public static void init() {
        personList = PersonDataGenerator.getPersonListWithFakeValues();
    }

    @Test
    public void whenFilterListByName_thenSizeShouldBe4() {
        List<Person> personListFiltered = io.vavr.collection.List.ofAll(personList)
            .distinctBy(Person::getName)
            .toJavaList();
        assertTrue(personListFiltered.size() == 4);
    }

    @Test
    public void whenFilterListByAge_thenSizeShouldBe2() {
        List<Person> personListFiltered = io.vavr.collection.List.ofAll(personList)
            .distinctBy(Person::getAge)
            .toJavaList();
        assertTrue(personListFiltered.size() == 2);
    }

}
