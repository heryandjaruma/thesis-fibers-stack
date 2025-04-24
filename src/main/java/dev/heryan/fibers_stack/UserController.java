package dev.heryan.fibers_stack;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping
    public String get() {
        System.out.println(Thread.currentThread().isVirtual());
        return Thread.currentThread().isVirtual() ? Thread.currentThread().getName() : "Hello World";
    }

    @PostMapping()
    public String post(@RequestBody User user) {
        return user.toString();
    }
}
