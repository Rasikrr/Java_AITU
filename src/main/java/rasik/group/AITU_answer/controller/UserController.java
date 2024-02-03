package rasik.group.AITU_answer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rasik.group.AITU_answer.entity.UserEntity;
import rasik.group.AITU_answer.entity.repository.UserRepo;
import rasik.group.AITU_answer.entity.service.UserService;
import rasik.group.AITU_answer.exception.UserAlreadyExistException;
import rasik.group.AITU_answer.exception.UserDoesNotExistException;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user){
        try {
            userService.registration(user);
            return ResponseEntity.ok("Пользователь успешно создан");
        } catch (UserAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("ERROR");
        }
    }

    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Integer id){
        try{
            return ResponseEntity.ok(userService.getOne(id));
        } catch (UserDoesNotExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("404");
        }
    }
}
