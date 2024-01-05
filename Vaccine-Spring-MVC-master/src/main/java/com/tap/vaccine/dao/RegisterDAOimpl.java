package com.tap.vaccine.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.tap.vaccine.entity.RegisterEntity;

@Component
public class RegisterDAOimpl implements RegisterDAO {

	private SessionFactory sessionFactory;
	@Autowired
	public RegisterDAOimpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Autowired
	private JavaMailSender javaMailSender;
	public RegisterDAOimpl(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	@Override
	public boolean saveRegisterEntity(RegisterEntity entity) throws Exception {
		System.out.println("Invoked saveRegisterEntity()");
		boolean isDataSaved = false;
		Transaction transaction = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(entity);

			String toMail = entity.getEmail();
			String subject = "Vacccine - Registration Successfull";
			String body = "Dear "+entity.getUserName()+",\n"
					+ "Here are the credentails:\n"
					+ "Email: "+entity.getEmail()+"\n"
					+ "Password: "+entity.getPassword()+"\n";
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setTo(toMail);
			simpleMailMessage.setSubject(subject);
			simpleMailMessage.setText(body);
			
			javaMailSender.send(simpleMailMessage);
			System.out.println("Mail sent..");
			
			transaction.commit();
			System.out.println("An Entity has been saved");
			
			isDataSaved = true;
		}
		catch(HibernateException hibernateException) {
			transaction.rollback();
			System.out.println("Transaction has been rolled back "+ hibernateException.getMessage());
		}
		finally {
			if(session!=null) {
				session.close();
				System.out.println("Session is closed");
			}
		}
		return isDataSaved;
	}

}
