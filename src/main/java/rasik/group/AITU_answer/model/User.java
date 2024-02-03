package rasik.group.AITU_answer.model;

import rasik.group.AITU_answer.entity.UserEntity;

public class User {
    private Integer id;
    private String username;

    public static User toModel(UserEntity userEntity){
        User user = new User();
        user.setId(userEntity.getId());
        user.setUsername(userEntity.getUsername());
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
}
