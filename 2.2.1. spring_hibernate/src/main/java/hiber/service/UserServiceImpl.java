package hiber.service;


import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

   private final UserDao userDao;

   @Autowired
   public UserServiceImpl(UserDao userDao) {
      this.userDao = userDao;
   }

   @Override
   @Transactional
   public void addUser(User user) {
      userDao.save(user);
   }

   @Override
   @Transactional
   public User getUserByCar(String model, int series) {
      return userDao.findUserByCar(model, series);
   }
}
