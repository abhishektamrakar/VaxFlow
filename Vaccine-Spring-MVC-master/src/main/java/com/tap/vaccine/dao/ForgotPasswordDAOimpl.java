package com.tap.vaccine.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.tap.vaccine.entity.RegisterEntity;

@Component
public class ForgotPasswordDAOimpl implements ForgotPasswordDAO{

	private SessionFactory sessionFactory;
	@Autowired
	public ForgotPasswordDAOimpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Autowired
	private JavaMailSender javaMailSender;
	public ForgotPasswordDAOimpl(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	@Override
	public boolean resetPasswordByEmail(String email, String password) throws Exception
	{
		boolean isDataChanged = false;
		Session session = null;
		Query query = null;
		Transaction transaction = null;
		RegisterEntity entity = null;
		String hql="From com.tap.vaccine.entity.RegisterEntity where EMAIL ='"+email+"'";
		try {
			session = sessionFactory.openSession();
			query = session.createQuery(hql);
			entity = (RegisterEntity) query.uniqueResult();
			
			transaction = session.beginTransaction();
			System.out.println("hiii");
			entity.setLoginAttempt(0);
			entity.setPassword(password);
			transaction.commit();
			
			String toMail = entity.getEmail();
			String subject = "Vacccine - Reset Password Succesfull";
			String body = "Dear "+entity.getUserName()+",\n"
					+ "Here are the credentails:\n"
					+ "Email: "+entity.getEmail()+"\n"
					+ "New Password: "+entity.getPassword()+"\n";
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setTo(toMail);
			simpleMailMessage.setSubject(subject);
			simpleMailMessage.setText(body);
			
			javaMailSender.send(simpleMailMessage);
			System.out.println("Mail sent..");

			isDataChanged = true;
		}catch(HibernateException hibernateException) {
			transaction.rollback();
			System.out.println("Transaction has been rolled back "+ hibernateException.getMessage());
		}finally {
			if(session!=null) {
				session.close();
				System.out.println("session is closed");			
			}
		}
		return isDataChanged;
	}
}
