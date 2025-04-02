//creata a maven project named quick

//1.app.java
package qwerty.asdfgh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);

    }
}

//2.Controller.java

package qwerty.asdfgh;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controller {
    
    @GetMapping("/")
    public String index() {
       return "index";  // This corresponds to home.html in src/main/resources/templates
    }

    @GetMapping("/home")
    public String home() {
       return "home";  // This corresponds to home.html in src/main/resources/templates
    }

    @GetMapping("/login")
    public String login() {
        return "login";  // This corresponds to login.html in src/main/resources/templates
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";  // This corresponds to signup.html in src/main/resources/templates
    }

    @GetMapping("/about")
    public String about() {
        return "about";  // This corresponds to about.html in src/main/resources/templates
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";  // This corresponds to contact.html in src/main/resources/templates
    }

    // @GetMapping("/nowshowing")
    // public String nowShowing() {
    //     return "nowshowing";
    // }
    
    @GetMapping("/comingsoon")
    public String comingSoon() {
        return "comingsoon";
    }
    
    @GetMapping("/bookings")
    public String bookings() {
        return "bookings";
    }
    
    // @GetMapping("/reviews")
    // public String reviews() {
    //     return "reviews";
    // }
    
    @GetMapping("/pricing")
    public String pricing() {
        return "pricing";
    }
    
    // @GetMapping("/faq")
    // public String faq() {
    //     return "faq";
    // }
}

//3.Counter.java

package qwerty.quick;
import java.util.concurrent.atomic.AtomicInteger;
public class Counter {
private AtomicInteger counter = new AtomicInteger(0);
public void increment() {
counter.incrementAndGet();
}
public int getCounter() {
return counter.get();
}
}

//4.UserServiceTest.java

package qwerty.quick;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class UserServiceTest {
private UserService userService;
private UserRepository userRepository;
@BeforeEach
public void setup() {
userRepository = mock(UserRepository.class);
userService = new UserService(userRepository);
}
@Test
public void testCreateUser() {
User newUser = new User("John", "Doe");
when(userRepository.save(any(User.class))).thenReturn(newUser);
User createdUser = userService.createUser(newUser);
assertNotNull(createdUser);
assertEquals("John", createdUser.getFirstName());
}
}

//5.UserRepositories.java

package qwerty.quick;
public interface UserRepository {
User save(User user);
}

//6.UserService.java

package qwerty.quick;
public class UserService {
private UserRepository userRepository;
public UserService(UserRepository userRepository) {
this.userRepository = userRepository;
}
public User createUser(User user) {
return userRepository.save(user);
}
}

//7.User.java 

package qwerty.quick;
public class User {
private String firstName;
private String lastName;
public User(String firstName, String lastName) {
this.firstName = firstName;
this.lastName = lastName;
}
public String getFirstName() {
return firstName;
}
public String getLastName() {
return lastName;
}
}
