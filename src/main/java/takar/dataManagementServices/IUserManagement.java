package takar.dataManagementServices;

import takar.model.User;

public interface IUserManagement {
	public Iterable<User> getAllUsers();
	public User logUser(String username, String password );
	public User findByUsername(String username);
}
