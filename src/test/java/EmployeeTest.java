import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void testEmployeeAgeInvalid() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> new Employee("Hadik Péter", 131));
        assertEquals("Birthday is not correct! " + 131, iae.getMessage());
    }

}