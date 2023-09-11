package ua.hryhorenko.springcourse;

import ua.hryhorenko.springcourse.model.Passport;
import ua.hryhorenko.springcourse.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
  public static void main(String[] args) {
    Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Passport.class);
    SessionFactory sessionFactory = configuration.buildSessionFactory();
    Session session = sessionFactory.getCurrentSession();

    try {
      session.beginTransaction();

      Person person = new Person("Test person", 40);
      Passport passport = new Passport(54321);
      person.setPassport(passport);
      session.save(person);

      session.getTransaction().commit();
    } finally {
      sessionFactory.close();
    }
  }
}
