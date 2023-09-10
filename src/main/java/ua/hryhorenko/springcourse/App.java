package ua.hryhorenko.springcourse;

import ua.hryhorenko.springcourse.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
  public static void main(String[] args) {
    Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
    SessionFactory sessionFactory = configuration.buildSessionFactory();
    Session session = sessionFactory.getCurrentSession();

    try {
      session.beginTransaction();

      session.createQuery("DELETE FROM Person WHERE age = 60").executeUpdate();

      session.getTransaction().commit();
    } finally {
      sessionFactory.close();
    }
  }
}
