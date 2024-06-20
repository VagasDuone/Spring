package UserCRUD;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/users")
public class UserController {

    private Map<Long, User> users = new HashMap<>();
    private AtomicLong counter = new AtomicLong();

    @PostMapping()
    public User CreateUser(@RequestBody User user) {
        Long id = counter.incrementAndGet();
        User newUser = new User(id, user.getFirstName(), user.getLastName(), false);
        users.put(id, newUser);
        return newUser;
    }

    @GetMapping("/{id}")
    public User GetUser(@RequestParam Long id) {
        return users.get(id);
    }

    @PatchMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        User existingUser = users.get(id);
        if (existingUser != null) {
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
        }
        return existingUser;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        users.remove(id);
    }
}


