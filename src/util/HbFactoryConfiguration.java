/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : HibernatePropTest
  @ Date         : 4/8/2023
  @ Time         : 11:48 AM
*/
package util;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

public class HbFactoryConfiguration {
    private static HbFactoryConfiguration hbFactoryConfiguration;
    private SessionFactory sessionFactory; //create session factory

    private HbFactoryConfiguration(){
        //add configuration
        Configuration configuration = new Configuration();

        //add property
        Properties properties = new Properties();

        //add already created hibernate file to properies in current thread
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.properties"));   //set path
        } catch (IOException e) {
            e.printStackTrace();
        }
        //add properties to configure
        configuration.setProperties(properties);

        //add annotated class to configure
        configuration.addAnnotatedClass(Student.class);

        //build session factory
        sessionFactory = configuration.buildSessionFactory();

    }

    public static HbFactoryConfiguration getInstance(){
        return (hbFactoryConfiguration == null ) ? new HbFactoryConfiguration() : hbFactoryConfiguration;
    }

    public Session getSession(){
        return sessionFactory.openSession(); //open session and return it
    }
}
