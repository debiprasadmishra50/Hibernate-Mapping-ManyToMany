package demo.application.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import demo.entity.Course;
import demo.entity.Instructor;
import demo.entity.InstructorDetail;
import demo.entity.Review;
import demo.entity.Student;

public class DeleteCoursesForDebi 
{
	// Debi was only in the Hibernate Course, now add courses
	public static void main(String[] args) 
	{
		// create a factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			Transaction tx = session.beginTransaction();
			
			// get the Hibernate course from database
			int courseId = 10;
			Course theCourse = session.get(Course.class, courseId);
			
			// delete the course
			System.out.println("Deleting Course : "+theCourse);
			session.delete(theCourse);
			
			//commit transaction
			tx.commit();
			System.out.println("Done");
			
		}finally {
			// clean up the resources
			session.close();
			factory.close();
		}
		
	}
}
