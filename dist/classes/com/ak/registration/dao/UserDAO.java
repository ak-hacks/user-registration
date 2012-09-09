package com.ak.registration.dao;

import java.util.List;

import com.ak.registration.form.User;

/**
 * Simple DAO interface that declared methods to add and list model objects
 * 
 * @author anuragkapur
 */
public interface UserDAO {
	public void addUser(User user);

	public List<User> listUser();
}
