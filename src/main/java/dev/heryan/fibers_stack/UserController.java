package dev.heryan.fibers_stack;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String get() {
        System.out.println(Thread.currentThread().isVirtual());
        System.out.println(Thread.currentThread().getThreadGroup().getName());
        return Thread.currentThread().isVirtual() ? Thread.currentThread().getName() : "Hello World";
    }

    @PostMapping("/user")
    public User post(@RequestBody SaveUserWebRequest saveUserWebRequest) {
        log.info("Saving user {}", saveUserWebRequest);
        try {
            User user = User.builder()
                    .id(saveUserWebRequest.getId())
                    .username(saveUserWebRequest.getUsername())
                    .name(saveUserWebRequest.getName())
                    .email(saveUserWebRequest.getEmail())
                    .phone(saveUserWebRequest.getPhone())
                    .address(saveUserWebRequest.getAddress())
                    .dateOfBirth(saveUserWebRequest.getDateOfBirth())
                    .build();
            user = userRepository.save(user);
            log.info("User saved: {}", user);
            return user;
        } catch (Exception e) {
            log.error("Error while saving user:", e);
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/users")
    public List<User> getAll() {
        log.info("Getting all users");
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            log.error("Error while getting all users:", e);
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody SaveUserWebRequest saveUserWebRequest) {
        log.info("Updating user {}", saveUserWebRequest);
        try {
            User user = User.builder()
                    .id(saveUserWebRequest.getId())
                    .username(saveUserWebRequest.getUsername())
                    .name(saveUserWebRequest.getName())
                    .email(saveUserWebRequest.getEmail())
                    .phone(saveUserWebRequest.getPhone())
                    .address(saveUserWebRequest.getAddress())
                    .dateOfBirth(saveUserWebRequest.getDateOfBirth())
                    .build();
            user = userRepository.save(user);
            log.info("User updated: {}", user);
            return user;
        } catch (RuntimeException e) {
            log.error("Error while updating user:", e);
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/users")
    Boolean deleteUsers() {
        log.info("Deleting all users");
        try {
            userRepository.deleteAll();
            log.info("Users deleted");
            return true;
        } catch (Exception e) {
            log.error("Error while deleting all users:", e);
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/user")
    Boolean deleteUser(@RequestParam("id") String id) {
        log.info("Deleting user {}", id);
        try {
            userRepository.deleteById(id);
            log.info("User deleted");
            return true;
        } catch (RuntimeException e) {
            log.error("User deleted:", e);
            throw new RuntimeException(e);
        }
    }

}
