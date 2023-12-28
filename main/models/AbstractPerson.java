package main.models;

public abstract class AbstractPerson {
    private static int counter = 0;
    private int id = 0;
    private String name;
    private String surname;

    public AbstractPerson(){
        id = counter++;
        name = "Unknown";
        surname = "Unknown";
    }

    public AbstractPerson(String name, String surname){
        id = counter++;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString(){
        return String.format("%d. %s %s", id, name, surname);
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public String getPosition(){
        return "Student";
    }

}
