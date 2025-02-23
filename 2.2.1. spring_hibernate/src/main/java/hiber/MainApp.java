package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("Ivan", "Ivanov", "ivan@mail.ru");
        Car car1 = new Car("BMW", 6);
        user1.setCar(car1);
        userService.add(user1);

        User user2 = new User("Petya", "Petrov", "petya@mail.ru");
        Car car2 = new Car("Toyota", 4);
        user2.setCar(car2);
        userService.add(user2);

        User user3 = new User("Vasya", "Vasilkov", "vasya@mail.ru");
        Car car3 = new Car("Mercedes", 2);
        user3.setCar(car3);
        userService.add(user3);


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
            System.out.println();
        }


        System.out.println("\n" + userService.getUserByCar("Toyota", 4));

        context.close();
    }
}
