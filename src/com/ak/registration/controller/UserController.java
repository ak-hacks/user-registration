package com.ak.registration.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ak.registration.dao.UserDAO;
import com.ak.registration.form.User;
import com.ak.registration.jobpool.DataPersister;

/**
 * Controller class of the MVC pattern. Exposes methods to add and list users.
 * Uses {@link DataPersister} class to actually persist data to DB and does not
 * interact with the DAO directly for adding users. However, uses DAO directly
 * to list users. This is to demonstrate two approaches of controller
 * interacting with DAO direct and via an abstraction.
 * 
 * @author anuragkapur
 */
public class UserController extends MultiActionController {

	private UserDAO userDAO;
	private DataPersister dataPersister;

	/**
	 * Set a userDAO to use for DB interaction
	 * 
	 * @param userDAO
	 */
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	/**
	 * Set a dataPersister that can handle asynchronous job execution via a
	 * thread pool
	 * 
	 * @param dataPersister
	 */
	public void setDataPersister(DataPersister dataPersister) {
		this.dataPersister = dataPersister;
	}

	/**
	 * Adds a user record to DB via a {@link DataPersister} class that uses a
	 * thread pool to asynchronously submit records
	 * 
	 * @param request
	 *            HTTP request object
	 * @param response
	 *            HTTP response object
	 * @param user
	 *            record to be stored
	 * @return ModelAndView
	 * @throws Exception
	 */
	public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		dataPersister.persist(user);
		// TODO: Use logger
		System.out
				.println("Data submitted to task executor for async persistence");
		return new ModelAndView("redirect:list.htm");
	}

	/**
	 * Lists records in the DB by invoking the DAO {@link UserDAO}
	 * 
	 * @param request
	 *            HTTP request object
	 * @param response
	 *            HTTP response object
	 * @return ModelAndView
	 * @throws Exception
	 */
	public ModelAndView list(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO: Use logger
		System.out.println(Thread.currentThread().getId());
		System.out.println(Thread.currentThread().getName());
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("userList", userDAO.listUser());
		modelMap.addAttribute("user", new User());
		return new ModelAndView("form", modelMap);
	}
}
