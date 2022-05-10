package controller;

import org.danuja25.springdata.exception.UserNotFoundException;
import org.danuja25.springdata.user.model.User;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.Locale;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user, @RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        User savedUser = userService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/all")
    public ResponseEntity<ArrayList<User>> getUsers()
    {
        ArrayList<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public EntityModel<User> getUser(@PathVariable int id) {
        User user = userService.getUser(id);
        if (user == null) {
            throw new UserNotFoundException("User id : " + id);
        }
        EntityModel<User> userModel = EntityModel.of(user);
        WebMvcLinkBuilder usersLink = linkTo(methodOn(this.getClass()).getUsers());
        userModel.add(usersLink.withRel("all-users"));

        return userModel;
    }


}
