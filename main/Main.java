package main;

import main.models.Employee;

public class Main {
    public static void main(String[] args) {
        Employee e = new Employee("Rassul", "Turtulov", "backend", 200000);
        System.out.println(e.getId());

    }
}