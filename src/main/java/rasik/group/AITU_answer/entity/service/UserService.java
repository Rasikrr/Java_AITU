package rasik.group.AITU_answer.entity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import rasik.group.AITU_answer.entity.UserEntity;
import rasik.group.AITU_answer.entity.repository.UserRepo;
import rasik.group.AITU_answer.exception.UserAlreadyExistException;
import rasik.group.AITU_answer.exception.UserDoesNotExistException;
import rasik.group.AITU_answer.model.User;

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

    public User getOne(Integer id) throws UserDoesNotExistException {
        if(!userRepo.existsById(id)){
            throw new UserDoesNotExistException("Пользователя с таким ID не существует");
        }
        return User.toModel(userRepo.findById(id).get());
    }

//    public UserEntity getOneByUsername(String username) throws UserDoesNotExistException{
//        UserEntity user = userRepo.findByUsername(username).get();
//        if(user == null){
//            throw new UserDoesNotExistException("ользователя с таким именем не существует");
//        }
//        return user;
//    }
}
