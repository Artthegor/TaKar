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

	@RequestMapping("registration")
	public String addUser(@RequestParam(value="firstname", required=false) String firstname, @RequestParam(value="lastname", required=false) String lastname,@RequestParam(value="choosenAddress", required=false) Integer idAddress, Model model)
	{
		if(firstname != null && lastname != null)
		{
			userManager.addUser(firstname, lastname);
		}
		//Iterable<User> allUser =userManager.getAllUsers();
		//model.addAttribute("users",allUser);
		return "userView";
	}

}
