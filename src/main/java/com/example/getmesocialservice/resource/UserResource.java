package com.example.getmesocialservice.resource;

import com.example.getmesocialservice.exception.RestrictedInfoException;
import com.example.getmesocialservice.model.FirebaseUser;
import com.example.getmesocialservice.model.User;
import com.example.getmesocialservice.service.FirebaseService;
import com.example.getmesocialservice.service.UserService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200" )
public class UserResource {
    @Autowired
    private UserService userService;
    @Autowired
    private FirebaseService firebaseService;
    @PostMapping
    public User saveUser(@Valid @RequestBody User user, @RequestHeader(name = "idToken") String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authentication(idToken);
        if(firebaseUser != null){
            return userService.saveUser(user);
        }
        return null;
    }

    @GetMapping
    public List<User> getAllUsers() {

            return userService.getAllUsers();
    }

    @PutMapping
    public User updateuser(@Valid @RequestBody User user)
    {
        return userService.updateUser(user);
    }

    @DeleteMapping
    public void deleteUser(@RequestParam(name = "id") String id){
        userService.deleteUser(id);
    }

    @GetMapping("/find")
    public List<User> getByName(@RequestParam(name="name") String name) throws RestrictedInfoException
    {
        if(name.equalsIgnoreCase("root")){
            throw new RestrictedInfoException();
        }
        return userService.getByName(name);

    }

    @GetMapping("/id")

    public List<User> getUserById(@RequestHeader(name = "idToken") String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authentication(idToken);
        if (firebaseUser!= null){
            return userService.getUserByEmail(firebaseUser.getEmail());
        }
        else {
            return userService.getUserById(idToken);
        }
    }

    /*
    @GetMapping("/user")
    public User getuser(){

        return userService.getUser();
    }

    @PostMapping("/user")
    public User saveUser(@RequestBody User user)
    {
        return userService.saveUser(user);

    }

    @GetMapping("/allUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/{userId}")

    public User getUserById(@PathVariable int userId)
    {
        return userService.getUserById(userId);
    }
*/

}
