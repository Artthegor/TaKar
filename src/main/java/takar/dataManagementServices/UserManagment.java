package takar.dataManagementServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import takar.model.User;
import takar.repositories.UserRepository;


import java.util.List;


@Service
public class UserManagment implements IUserManagment {

	@Autowired
	UserRepository userRepo;
	
	public UserManagment()
	{	}

	@Override
	@Transactional(readOnly = true)
	public User findByUsername(String username){
		User user = null;

		try {
			user = userRepo.findByUsername(username);
		} catch (Exception e) {
			throw e;
		}
		return user;
	}

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
