package kz.iitu.security.controller;

import kz.iitu.security.entity.User;
import kz.iitu.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello everyone!";
    }

    @GetMapping("/userslist")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    //users/create/?username=aqw&password=123
    @GetMapping("/create")
    public void createUserByUsernameAndPassword(String username,
                                                String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userService.createUser(user);
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        System.out.println("UserController.createUser");
        System.out.println("user = " + user);

        userService.createUser(user);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id,
                           @RequestBody User user) {

        System.out.println("UserController.updateUser");
        System.out.println("id = " + id);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("authentication.getName() = " + authentication.getName());

        userService.updateUser(id, user);
    }


}
