package com.tap.vaccine.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.vaccine.entity.AddMemberEntity;
import com.tap.vaccine.entity.RegisterEntity;

@Component
public class AddMemberDAOimpl implements AddMemberDAO {

	private SessionFactory sessionFactory;
	
	@Autowired
	public AddMemberDAOimpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public boolean saveAddMemberEntity(AddMemberEntity entity) {
		System.out.println("Involed saveAddMemberEntity()");
		boolean isDataSaved = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(entity);
			transaction.commit();
			System.out.println("An entity has been saved");
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

	@Override
	public int updateMemberCount(String email, int memberCount)throws Exception {
		Session session = null;
		Query query = null;
		Transaction transaction = null;
		int increaseCount = ++memberCount;
		int count=0;
		String hql= "UPDATE com.tap.vaccine.entity.RegisterEntity set MEMBER_COUNT="+increaseCount+" WHERE EMAIL='"+email+"'";
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

	@Override
	public int getMemberCount(String email) {
		Session session = null;
		Query query = null;
		RegisterEntity entity = null;
		int count=0;
		String hql= "FROM com.tap.vaccine.entity.RegisterEntity WHERE EMAIL='"+email+"'";
		try {
			session = sessionFactory.openSession();
			query = session.createQuery(hql);
			entity = (RegisterEntity) query.uniqueResult();
			count = entity.getMemberCount();
		}finally {
			if(session!=null) {
				session.close();
				System.out.println("session is closed");
			}
		}
		return count;
	}

	
	@Override
	public int decreaseMemberCount(String email, int memberCount) {
		Session session = null;
		Query query = null;
		Transaction transaction = null;
		int increaseCount = --memberCount;
		int count=0;
		String hql= "UPDATE com.tap.vaccine.entity.RegisterEntity set MEMBER_COUNT="+increaseCount+" WHERE EMAIL='"+email+"'";
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
	
	@Override
	public List<AddMemberEntity> viewAllMemberDetails(String userEmail) {
		System.out.println("Invoked view All Members Entity");
	    Session session = null;
	    String hql = "from com.tap.vaccine.entity.AddMemberEntity WHERE USER_EMAIL ='"+userEmail+"'";
	    Query query = null;
	    List<AddMemberEntity> resultList;
	    try {
	        session = sessionFactory.openSession();
	        query = session.createQuery(hql);  
	        resultList = query.getResultList(); 
	        return resultList;
	    } finally {
	        if (session != null) {
	            session.close();
	            System.out.println("session is closed");
	        }
	    }

	}
	
	@Override
	public AddMemberEntity getAddMemberEntityById(int id) {
		System.out.println("Invoked get AddMemberEntity by ID");
		Session session = null;
		AddMemberEntity entity = null;
		try {
			session = sessionFactory.openSession();
			entity = session.get(AddMemberEntity.class, id);
			if(entity!=null) {
				return entity;
			}
		}finally {
			if(session!=null)
				session.close();
			System.out.println("session is closed");
		}
		return entity;
	}

	@Override
	public boolean updateAddMemberEntity(AddMemberEntity entity) {
	    System.out.println("Invoked update AddMember Entity");
	    boolean isDataSaved = false;
	    Session session = null;
	    Transaction transaction = null;

	    try {
	        session = sessionFactory.openSession();
	        transaction = session.beginTransaction();
	        session.update(entity);
	        transaction.commit();
	        System.out.println("Entity has been updated");
	        isDataSaved = true;
	    } catch (HibernateException hibernateException) {
	        if (transaction != null && transaction.isActive()) {
	            transaction.rollback();
	        }
	        System.err.println("Error updating entity: " + hibernateException.getMessage());
	    } finally {
	        if (session != null) {
	            session.close();
	            System.out.println("Session is closed");
	        }
	    }

	    return isDataSaved;
	}

	
	@Override
	public boolean deleteAddMemberEntity(String idProofNo) throws Exception {
		System.out.println("Invoked delete AddMember Entity By Id");
		boolean isDataDeleted = false;
		Session session = null;
		Transaction transaction = null;
		Query query = null;
		AddMemberEntity entity = null;
		String hql="delete from com.tap.vaccine.entity.AddMemberEntity WHERE ID_PROOF_NO='"+idProofNo+"'";
		try {
			 session = sessionFactory.openSession();
			 transaction = session.beginTransaction();
			 query = session.createQuery(hql);
			 query.executeUpdate();
			 transaction.commit();
			 System.out.println("Entity has deleted");
			 isDataDeleted = true;
		}catch(HibernateException hibernateException) {
			transaction.rollback();
			System.out.println("Transaction has been rolled back "+ hibernateException.getMessage());
		}finally {
			if(session!=null) {
				session.close();
				System.out.println("session is closed");	
			}
		}
		return isDataDeleted;	
	}

}
