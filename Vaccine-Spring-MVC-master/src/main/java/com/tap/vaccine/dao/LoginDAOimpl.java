package com.tap.vaccine.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.vaccine.entity.RegisterEntity;

@Component
public class LoginDAOimpl implements LoginDAO {

	private SessionFactory sessionFactory;
	@Autowired
	public LoginDAOimpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public RegisterEntity getRegisterEntity(String email) {
		Session session = null;
		Query query = null;
		RegisterEntity entity = null;
		String hql= "FROM com.tap.vaccine.entity.RegisterEntity WHERE EMAIL='"+email+"'";
		try {
			session = sessionFactory.openSession();
			query = session.createQuery(hql);
			entity = (RegisterEntity) query.uniqueResult();	
		}finally {
			if(session!=null) {
				session.close();
				System.out.println("session is closed");
			}
		}
		return entity;
	}

	@Override
	public int updateLoginAttemptCount(String email,int loginAttemptCount)throws Exception {
		Session session = null;
		Query query = null;
		Transaction transaction = null;
		int increaseCount = ++loginAttemptCount;
		int count=0;
		String hql= "UPDATE com.tap.vaccine.entity.RegisterEntity set LOGIN_ATTEMPT="+increaseCount+" WHERE EMAIL='"+email+"'";
		try {
			session = sessionFactory.openSession();
			query = session.createQuery(hql);
			transaction = session.beginTransaction();
			count = query.executeUpdate();
			transaction.commit();
		}catch(HibernateException hibernateException) {
			transaction.rollback();
			System.out.println("Transaction has been rolled back "+ hibernateException.getMessage());
		}finally {
			if(session!=null) {
				session.close();
				System.out.println("session is closed");
			}
		}
		return count;
	}
}
