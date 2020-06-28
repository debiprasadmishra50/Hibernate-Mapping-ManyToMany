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

public class CreateCourseAndStudentsDemo 
{
	public static void main(String[] args) 
	{
		// create a factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			Transaction tx = session.beginTransaction();
			
			// Create a course
			Course course = new Course("Hibernate");
			
			// save the course
			System.out.println("\nSaving the course");
			session.save(course);
			System.out.println("\nSaved Course : "+course);
			
			// create the Students
			Student s1 = new Student("Debi", "prasad", "debi@prasad.com");
			Student s2 = new Student("Vicky", "Debi", "Vicky@prasad.com");
			Student s3 = new Student("Mishra", "prasad", "Mishra@prasad.com");
			
			// add students to the course
			course.addStudent(s1);
			course.addStudent(s2);
			course.addStudent(s3);
			
			// save the students
			System.out.println("\nSaving the students");
			session.save(s1);
			session.save(s2);
			session.save(s3);
			System.out.println("\nSaved Students : "+course.getStudents());
			
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
