package takar.dataManagementServices;

import takar.model.User;

public interface IUserManagment {
	public Iterable<User> getAllUsers();
	public User logUser(String username, String password );
	public User findByUsername(String username);
}
