import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

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

}