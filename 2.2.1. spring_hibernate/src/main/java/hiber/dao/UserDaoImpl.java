package hiber.dao;


import hiber.model.User;
import org.hibernate.SessionFactory;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

   private final SessionFactory sessionFactory;

   @Autowired
   public UserDaoImpl(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }

   @Override
   public void save(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public User findUserByCar(String model, int series) {
      String hql = "FROM User u WHERE u.car.model = :model AND u.car.series = :series";
      Query<User> query = sessionFactory.getCurrentSession().createQuery(hql, User.class);
      query.setParameter("model", model);
      query.setParameter("series", series);
      return query.uniqueResult();
   }
}
