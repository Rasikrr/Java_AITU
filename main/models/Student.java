package main.models;

public class Student extends AbstractPerson{

    private double gpa;

    public Student(){
        super();
        gpa = 0.0;
    }

    public Student(String name, String surname, double gpa){
        super(name, surname);
        this.gpa = gpa;
    }
    
    @Override
    public String toString(){
        return "Student: " + super.toString();
    }

    public double getGpa(){
        return gpa;
    }

    public void setGpa(double gpa){
        this.gpa = gpa;
    }

    
}