package com.xworkz.vaccine.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.vaccine.entity.AddMemberEntity;

@Component
public class AddMemberDAOImpl implements AddMemberDAO {

	@Autowired
	private SessionFactory factory;

	public AddMemberDAOImpl() {
		System.out.println(this.getClass().getSimpleName() + "Bean Created");

	}

	@Override
	public boolean saveAddMemberEntity(Object MemberEntity) {
		System.out.println("Invoked saveAddMemberEntity ");
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			session.save(MemberEntity);
			session.getTransaction().commit();
			System.out.println("MemberEntity is saved");
			System.out.println(MemberEntity);
			return true;
		} catch (Exception exception) {
			System.out.println("MemberEntity is not saved");
			session.getTransaction().rollback();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("session is closed");
			} else {
				System.out.println("session is not closed");
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AddMemberEntity> getAllAddMemberDetails() {
		System.out.println("Invoked GetAll AddMember Details");
		Session session = null;
		List<AddMemberEntity>list=null;
		try {
			session = factory.openSession();
			Query query = session.getNamedQuery("getAllAddMemberDetails");
			System.out.println("GetAll AddMember Details is saved");
			return (List<AddMemberEntity>) query.getResultList();
//			list=query.list();
		} catch (Exception exception) {
			System.out.println("GetAll AddMember Details is not saved");
		} finally {
			if (session != null) {
				session.close();
				System.out.println("session is closed");
			} else {
				System.out.println("session is not closed");
			}
		}
		return list;
	}

}
