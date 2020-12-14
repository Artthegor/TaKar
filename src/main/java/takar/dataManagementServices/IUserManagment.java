package takar.dataManagementServices;

import takar.model.User;

public interface IUserManagment {
	public Iterable<User> getAllUsers();
	public User addUser(String username, String password);
}
