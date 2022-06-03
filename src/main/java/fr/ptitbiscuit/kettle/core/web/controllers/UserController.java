package fr.ptitbiscuit.kettle.core.web.controllers;

import fr.ptitbiscuit.kettle.core.applicationServices.ports.IUserRepository;
import fr.ptitbiscuit.kettle.core.domain.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final IUserRepository userRepository;

    public UserController(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(path = "users/add")
    public ResponseEntity<HttpStatus> addNewUser(
        @RequestParam String firstname,
        @RequestParam String lastname
    ) {
        var user = new User();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        userRepository.save(user);

        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "users/all")
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @DeleteMapping(path = "users/delete")
    public ResponseEntity<HttpStatus> deleteUser(@RequestParam Integer id) {
        if (userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);

            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
