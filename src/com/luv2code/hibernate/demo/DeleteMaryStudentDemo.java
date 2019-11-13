package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteMaryStudentDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {


            session.beginTransaction();

            int theId = 2;
            Student tempStudent = session.get(Student.class, theId);

            System.out.println("\nLoaded student: " + tempStudent);
            System.out.println("Course: " + tempStudent.getCourses());


            System.out.println("\nDeleting student: " + tempStudent);
            session.delete(tempStudent);


            session.getTransaction().commit();
            System.out.println("Done!!!");


        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
