import java.util.*;

public class Human implements Comparable<Human> {
    String name;
    String lastName;
    int age;

    public Human(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    // сортировка по фамилии (по умолчанию)
    @Override
    public int compareTo(Human other) {
        return this.lastName.compareTo((other.lastName));
    }

    @Override
    public String toString() {
        return name + " " + lastName + ", " + age + " лет.";
    }
}
