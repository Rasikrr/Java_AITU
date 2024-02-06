package rasik.group.AITU_answer.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import rasik.group.AITU_answer.entity.UserEntity;
import rasik.group.AITU_answer.entity.repository.UserRepo;
import rasik.group.AITU_answer.entity.service.UserService;
import rasik.group.AITU_answer.exception.UserAlreadyExistException;
import rasik.group.AITU_answer.exception.UserDoesNotExistException;
import rasik.group.AITU_answer.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registration(@Valid @RequestBody UserEntity user){
        try {
            userService.registration(user);
            return ResponseEntity.ok("Пользователь успешно создан.");
        } catch (UserAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("ERROR");
        }
    }

    @GetMapping("/all")
    public @ResponseBody List<User> getAll(){
        return userService.getAll();
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

    @GetMapping("/{username}")
    public ResponseEntity getOneUserByUsername(@PathVariable String username){
        try{
            return ResponseEntity.ok(userService.getOneByUsername(username));
        } catch (UserDoesNotExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("404");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        try{
            return ResponseEntity.ok(userService.delete(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("404");
        }
    }

    @GetMapping("/department/{department}")
    public @ResponseBody List<User> getUserByDepartment(@PathVariable String department){
        return userService.getByDepartmentAndGroup(department);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException e){
        Map<String, String> errors = new HashMap<>();

        e.getBindingResult().getAllErrors().forEach((error) ->{
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
