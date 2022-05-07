import java.time.LocalDateTime;

public class Employee {

    private String name;
    private int yearOfBirth;

    public Employee(String name, int yearOfBirth) {
        this.name = name;
        if(yearOfBirth > 2022) {
            throw new IllegalArgumentException("Birthday is not correct!");
        }
        this.yearOfBirth = yearOfBirth;
    }

    public int getAge(int yearOfBirth) {
        return LocalDateTime.now().getYear() - yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
}
