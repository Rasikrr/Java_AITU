package rasik.group.AITU_answer.model;

import rasik.group.AITU_answer.entity.UserEntity;

public class User {
    private Integer id;
    private String username;
    private String department;
    private Integer group_number;

    private Integer course;
    public static User toModel(UserEntity userEntity){
        User user = new User();
        user.setId(userEntity.getId());
        user.setUsername(userEntity.getUsername());
        user.setGroup_number(userEntity.getGroup_number());
        user.setDepartment(userEntity.getDepartment());
        user.setCourse(userEntity.getCourse());
        return user;
    }

    private User(){}

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
    public Integer getGroup_number() {
        return group_number;
    }

    public String getDepartment() {
        return department;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setGroup_number(Integer group_number) {
        this.group_number = group_number;
    }
}
