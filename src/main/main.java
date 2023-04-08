/*
  @ Author       : C.Kaligu Jayanath
  @ Prjoect Name : HibernatePropTest
  @ Date         : 4/8/2023
  @ Time         : 11:57 AM
*/
package main;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HbFactoryConfiguration;

public class main {
    public static void main(String[] args){
        //All are done Lets Persist
        //initialise session
        Session session = HbFactoryConfiguration.getInstance().getSession();

        //initialise a transaction
        Transaction transaction = session.beginTransaction();

        //create student object to save database
        Student student = new Student("s001" , "Kaligu Jaynath");

        //pass object to session
        session.save(student);

        //set transaction commit
        transaction.commit();

        //sloase session
        session.close();

    }
}
