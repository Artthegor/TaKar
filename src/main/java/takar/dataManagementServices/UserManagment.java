package takar.dataManagementServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import takar.model.User;
import takar.repositories.UserRepository;

@Service
public class UserManagment implements IUserManagment {
	@Autowired
	UserRepository userRepo;

	
	public UserManagment()
	{	}

	public User addUser(String username, String password )
	{
		User usr = addUser(username,  password);
		return userRepo.save(usr);
	}
	
	public Iterable<User> getAllUsers()
	{
		return userRepo.findAll();
	}

}
