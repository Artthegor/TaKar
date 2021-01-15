package takar.dataManagementServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import takar.model.User;
import takar.repositories.UserRepository;

import java.util.List;


@Service
public class UserManagment implements IUserManagment {

	@Autowired
	UserRepository userRepo;
	
	public UserManagment()
	{	}

	public User logUser(String username, String password ) {
		System.out.println(username + "   " + password);
		System.out.println(userRepo.findByUsername(username).getUsername());

		User user = userRepo.findByUsername(username);
		return user;
	}

	public Iterable<User> getAllUsers()
	{
		return userRepo.findAll();
	}

}
