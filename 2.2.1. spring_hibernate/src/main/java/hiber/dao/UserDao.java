package hiber.dao;

import hiber.model.User;


public interface UserDao {
   void save(User user);
   User findUserByCar(String model, int series);
}
