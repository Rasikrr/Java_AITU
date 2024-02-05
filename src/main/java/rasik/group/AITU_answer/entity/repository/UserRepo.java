package rasik.group.AITU_answer.entity.repository;

import org.springframework.data.repository.CrudRepository;
import rasik.group.AITU_answer.entity.UserEntity;
import rasik.group.AITU_answer.model.User;

public interface UserRepo extends CrudRepository<UserEntity, Integer> {
    UserEntity findByUsername(String username);
    UserEntity findByEmail(String email);
    Iterable<UserEntity> findByDepartment(String department);
    Iterable<UserEntity> findAll();

}
