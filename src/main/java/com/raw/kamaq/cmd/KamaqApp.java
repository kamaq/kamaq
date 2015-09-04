package com.raw.kamaq.cmd;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.raw.kamaq.model.User;

public class KamaqApp {

	public static void main(String[] args) {

		User user = new User();
		user.setName("Wil");

		Configuration config = new Configuration()
				.configure(new File("/home/wil/github/kamaq/src/main/resources/hibernate.cfg.xml"));
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(user);

		session.getTransaction().commit();
		session.close();
		sessionFactory.close();

	}

}
