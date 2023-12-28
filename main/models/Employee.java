package main.models;

public class Employee extends AbstractPerson {

    private String position;
    private double salary;
    
    public Employee(){
        super();
        position = "Unknown";
        salary = 0.0;
    }
    

    public Employee(String name, String surname, String position, double salary){
        super(name, surname);
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString(){
        return "Employee: "+ super.toString();
    }

    @Override
    public String getPosition(){
        return position;
    }

    public void setPosition(String position){
        this.position = position;
    }

    public double getSalary(){
        return salary;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    public double getPaymentAmount(){
        return this.getSalary();
    }


}
