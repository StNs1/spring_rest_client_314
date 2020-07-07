package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import web.model.User;
import web.service.UserService;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        UserService userService = SpringApplication.run(Application.class, args).getBean(UserService.class);
        String sessionId = userService.getUsers();
        System.out.println(sessionId);
        System.out.print(userService.add(new User(3L, "James", "Brown", (byte) 19), sessionId));
        System.out.print(userService.put(new User(3L, "Thomas", "Shelby", (byte) 19), sessionId));
        System.out.println(userService.delete(new User(3L, "Thomas", "Shelby", (byte) 19), sessionId));
    }
}
