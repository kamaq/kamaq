package com.raw.kamaq.cmd;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.raw.kamaq.model.Component;
import com.raw.kamaq.model.Function;
import com.raw.kamaq.model.Module;
import com.raw.kamaq.model.Profile;
import com.raw.kamaq.model.ProfileDetail;
import com.raw.kamaq.model.User;

public class KamaqApp {

	public static void main(String[] args) {

		User user = new User();
		user.setName("Wil");

		Module module = new Module();
		module.setName("Commerce");

		Component component1 = new Component();
		component1.setName("Customer Master");
		component1.setModule(module);

		Function functionA1 = new Function();
		functionA1.setName("Create");
		functionA1.setComponent(component1);
		Function functionA2 = new Function();
		functionA2.setName("Modify");
		functionA2.setComponent(component1);
		(component1.getFunctions()).add(functionA1);
		(component1.getFunctions()).add(functionA2);

		Component component2 = new Component();
		component2.setName("Prices Master");
		component2.setModule(module);

		Function functionB1 = new Function();
		functionB1.setName("Generate");
		functionB1.setComponent(component2);
		Function functionB2 = new Function();
		functionB2.setName("Enable");
		functionB2.setComponent(component2);
		(component2.getFunctions()).add(functionB1);
		(component2.getFunctions()).add(functionB2);

		(module.getComponents()).add(component1);
		(module.getComponents()).add(component2);

		Profile profile = new Profile();
		profile.setName("Manager");

		ProfileDetail profileDetail1 = new ProfileDetail();
		profileDetail1.setInserted(new Date());
		profileDetail1.setUpdated(new Date());
		profileDetail1.setFunction(functionA1);
		profileDetail1.setProfile(profile);

		(profile.getProfileDetail()).add(profileDetail1);

		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(user);
		session.save(module);
		session.save(profile);

		user.getProfiles().add(profile);

		session.getTransaction().commit();
		session.close();
		sessionFactory.close();

	}

}
