package hiber.dao;

import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public void delete(User user) {
      sessionFactory.getCurrentSession().delete(user);
   }

   @Override
   public User getUserByCarModelAndSeries(String model, int series) {
      Session session=sessionFactory.getCurrentSession();
      Query query = session.createQuery("from User u where u.car.model=:model and u.car.series=:series");
      query.setParameter("model", model);
      query.setParameter("series", series);
      return (User) query.getSingleResult();
   }
}