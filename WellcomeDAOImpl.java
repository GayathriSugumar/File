package com.xworkz.vaccine.dao;

import java.util.Random;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.xworkz.vaccine.entity.UserEntity;

@Component
public class WellcomeDAOImpl implements WellcomeDAO {

	@Autowired
	private SessionFactory factory;
	
	public WellcomeDAOImpl() {
		System.out.println(this.getClass().getSimpleName()+"Bean Created");
	}


	@Override
	public boolean saveUserEntity(Object userEntity) {
		System.out.println("Invoked saveUserEntity() ");
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			session.save(userEntity);
			session.getTransaction().commit();
			System.out.println("Entity is saved");
			System.out.println(userEntity);
			return true;
		} catch (Exception exception) {
			System.out.println("Entity is not saved");
			session.getTransaction().rollback();
		}finally {
			if(session!=null) {
				session.close();
				System.out.println("session is closed");
			} else {
				System.out.println("session is not closed");
			}
		}
		return false;
	}


	@Override
	public String getEmailFromTable(String email) {
		System.out.println("Invoked getEmailFromTable");
		Session session = null;
		String Email =email;
		try {
			session = factory.openSession();
			session.beginTransaction();
			Query query = session.getNamedQuery("getEmailFromTable");
			query.setParameter("Email",email);
			Email= (String) query.uniqueResult();
			System.out.println("Email From DB : " + email);
			return email;
		} catch (Exception emailException) {
			session.getTransaction().rollback();
		}finally {
			if(session!=null) {
				session.close();
				System.out.println("session is closed");
			} else {
				System.out.println("session is not closed");
			}
		}
		return email;
	}

}
