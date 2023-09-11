package ua.hryhorenko.springcourse;

import ua.hryhorenko.springcourse.model.Item;
import ua.hryhorenko.springcourse.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 */
public class App {
  public static void main(String[] args) {
    Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);
    SessionFactory sessionFactory = configuration.buildSessionFactory();
    Session session = sessionFactory.getCurrentSession();

    try {
      session.beginTransaction();



      session.getTransaction().commit();
    } finally {
      sessionFactory.close();
    }
  }
}
