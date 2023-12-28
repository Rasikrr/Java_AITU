package main;

import main.models.Employee;
import main.models.LowGPA;
import main.models.LowGpaException;
import main.models.Student;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Ivan", "Ivanov", 2.67);
        Employee e1 = new Employee("Bek", "Kabiev", "engineer", 500000);
    }
}