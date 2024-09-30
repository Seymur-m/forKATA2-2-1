package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car();
      car1.setModel("BMW");
      car1.setSeries(525);

      User user1 = new User();
      user1.setName("Jack Lee");
      user1.setCar(car1);

      userService.addUser(user1);

      User retrievedUser = userService.getUserByCar("Mercedes", 222);
      System.out.println("Retrieved User: " + retrievedUser.getName());

      context.close();
   }
}
