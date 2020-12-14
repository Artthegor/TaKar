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

	public User addUser(String firstname, String name )
	{
		User usr = addUser(firstname,  name);
		return userRepo.save(usr);
	}
	
	public Iterable<User> getAllUsers()
	{
		return userRepo.findAll();
	}

}
