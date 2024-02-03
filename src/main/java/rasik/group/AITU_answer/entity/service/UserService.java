package rasik.group.AITU_answer.entity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rasik.group.AITU_answer.entity.UserEntity;
import rasik.group.AITU_answer.entity.repository.UserRepo;
import rasik.group.AITU_answer.exception.UserAlreadyExistException;
import rasik.group.AITU_answer.exception.UserDoesNotExistException;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public void registration(UserEntity user) throws UserAlreadyExistException {
        if(userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("Пользователь с таким именем уже существует");
        }
        if(userRepo.findByEmail(user.getEmail()) != null) {
            System.out.println(user);
            throw new UserAlreadyExistException("Пользователь с таким email уже существует");
        }
        userRepo.save(user);
    }

    public UserEntity getOne(Integer id) throws UserDoesNotExistException {
        if(!userRepo.existsById(id)){
            throw new UserDoesNotExistException("Пользователя с таким ID не существует");
        }
        return userRepo.findById(id).get();
    }
}
