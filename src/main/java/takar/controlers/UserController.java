package takar.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import takar.dataManagementServices.IUserManagment;
import takar.model.User;

@Controller
@RequestMapping("authentication")
public class UserController {
	@Autowired
	private IUserManagment userManager;


	@RequestMapping("connexion")
	public String addUser(@RequestParam(value="username", required=false) String username, @RequestParam(value="password", required=false) String password,@RequestParam(value="choosenAddress", required=false) Integer idAddress, Model model)
	{
		if(username != null && password != null)
		{
			userManager.addUser(username, password);
		}
		//Iterable<User> allUser =userManager.getAllUsers();
		//model.addAttribute("users",allUser);
		return "userView";
	}

}
