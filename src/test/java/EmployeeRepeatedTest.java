import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class EmployeeRepeatedTest {

    int [][] years = {{1999, 23}, {2012, 10}, {2021, 1}};

    @Test
    void testEmployeeAgeInvalid() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> new Employee("Hadik Péter", 2023));
        assertEquals("Birthday is not correct!", iae.getMessage());
    }

    @RepeatedTest(value = 3, name = "Get Age {currentRepetition}/{totalRepetitions}")
    void testGetAge(RepetitionInfo info) {
        Employee employee = new Employee("Péter", 1999);
        int yearOfBirth = years[info.getCurrentRepetition() - 1][0];
        int expected = years[info.getCurrentRepetition() - 1][1];
        assertEquals(expected, employee.getAge(yearOfBirth));
    }

    @ParameterizedTest(name = "Year of birth {0} age {1} now")
    @MethodSource("createAges")
    void testGetAgeWithParams(int yearOfBirth, int age) {
        Employee employee = new Employee("Hadik Péter", 2000);
        assertEquals(age, employee.getAge(yearOfBirth));
    }

    static Stream<Arguments> createAges() {
        return Stream.of(
                arguments(2000, 22),
                arguments(2015, 7),
                arguments(2020, 2)
        );
    }

}