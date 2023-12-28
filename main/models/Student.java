package main.models;

public class Student extends AbstractPerson{

    final static double scholarship = 36660;
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

    public double getPaymentAmount(){
        if(gpa <= 2.67)
            return 0.0;
        return scholarship;
    }

    // @Override
    // public int compareTo(AbstractPerson person) {
    //     if (person instanceof Student) {
    //         return Double.compare(this.getPaymentAmount(), person.getPaymentAmount());
    //     }
    //     return super.compareTo(person);
    // }

}