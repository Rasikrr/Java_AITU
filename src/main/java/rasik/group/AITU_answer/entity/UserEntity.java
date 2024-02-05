package rasik.group.AITU_answer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import java.time.Year;
import java.time.LocalDate;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "username is required")
    @NotBlank(message = "username is required")
    private String username;

    @NotNull(message = "password is required")
    @NotBlank(message = "password is required")
    @Size(min = 5, max=25, message = "password must be between 5 and 25 characters")
    private String password;

    @NotNull(message = "choose course 1-3")
    @Min(value = 1, message = "Minimum possible value - 1")
    @Max(value = 3, message = "Maximum possible value - 3")
    private Integer course;

    @NotNull(message = "email is required")
    @NotBlank(message = "email is required")
    private String email;
    @NotNull(message = "department is required")
    @NotBlank(message = "department is required")
    private String department;
    @NotNull(message = "group number is required")
    private Integer group_number;



    public UserEntity(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getGroup_number() {
        return group_number;
    }

    public void setGroup_number(Integer group_number) {
        this.group_number = group_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public String toString(){
        return String.format("%s %s %s\n", getUsername(), getEmail(), getPassword());
    }
}
