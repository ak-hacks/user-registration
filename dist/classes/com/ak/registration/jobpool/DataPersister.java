/**
 * 
 */
package com.ak.registration.jobpool;

import org.springframework.core.task.TaskExecutor;

import com.ak.registration.dao.UserDAO;
import com.ak.registration.form.User;

/**
 * A TaskExecutor that uses a thread pool to persist model objects via a DAO
 * implementation
 * 
 * @author anuragkapur
 */
public class DataPersister {

	private TaskExecutor taskExecutor;

	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public DataPersister(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	public void persist(final User user) {
		// TODO: Use Logger
		System.out.println(Thread.currentThread().getId());
		System.out.println(Thread.currentThread().getName());
		taskExecutor.execute(new Runnable() {
			public void run() {
				userDAO.addUser(user);
			}
		});
	}

}
