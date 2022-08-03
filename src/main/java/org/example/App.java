package org.example;


import org.example.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(User.class);


        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            User person = session.get(User.class, 1);
            System.out.println(person.getName());
            System.out.println(person.getAge());

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }


    }
}
