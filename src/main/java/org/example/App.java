package org.example;


import org.example.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

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

            List<User> list = session.createQuery("FROM User where name='Nick'").getResultList();
            list.stream().forEach(x -> System.out.println(x.getName()));
            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }


    }
}
