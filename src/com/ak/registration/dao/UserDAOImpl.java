package com.ak.registration.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.ak.registration.form.User;

/**
 * DAO implementation to add and list user model objects
 * 
 * @author anuragkapur
 */
public class UserDAOImpl implements UserDAO {

	private HibernateTemplate hibernateTemplate;

	/**
	 * Sets hibernate session factors
	 * 
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	/**
	 * Adds the user model object to the DB
	 * 
	 * @param user
	 *            model object to persist
	 */
	public void addUser(User user) {
		hibernateTemplate.saveOrUpdate(user);
	}

	/**
	 * Lists all users in the DB
	 * 
	 * @return list of user model objects from the DB
	 */
	public List<User> listUser() {
		return hibernateTemplate.find("from User");
	}
}
