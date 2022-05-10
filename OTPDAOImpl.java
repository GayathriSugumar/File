package com.xworkz.vaccine.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.xworkz.vaccine.entity.UserEntity;

@Component
public class OTPDAOImpl implements OTPDAO{
	@Autowired
	private SessionFactory factory;
	
	public OTPDAOImpl() {
		System.out.println(this.getClass().getSimpleName()+"Bean Created");
	}
	
	@Override
	public int getOTPFromTable(int otp) {
		System.out.println("Invoked getOTPFromTableByEmail");
		Session session = null;
		int OTP=0;
		try {
			session = factory.openSession();
			session.beginTransaction();
			Query query = session.getNamedQuery("getOTPFromTable");
			query.setParameter("OTP",otp);
			OTP = (int) query.uniqueResult();
			System.out.println("OTP From DB : " + OTP);
			return OTP;
		} catch (Exception e) {
			session.getTransaction().rollback();
		}finally {
			if(session!=null) {
				session.close();
				System.out.println("session is closed");
			} else {
				System.out.println("session is not closed");
			}
		}
		return OTP;
	}
	
	

}
