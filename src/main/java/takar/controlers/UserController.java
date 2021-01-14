package takar.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import takar.dataManagementServices.IClientManagement;
import takar.dataManagementServices.IUserManagment;

import java.util.Date;

@Controller
@RequestMapping("authentication")
public class UserController {
	@Autowired
	private IUserManagment userManager;

	@Autowired
	private IClientManagement clientManager;


	@RequestMapping("connexion")
	public String connexionUser(@RequestParam(value="username", required=false) String username, @RequestParam(value="password", required=false) String password, Model model) {

		if(username != null && password != null) {
			userManager.logUser(username, password);
		}
		//Iterable<User> allUser = userManager.getAllUsers();
		//model.addAttribute("users",allUser);
		return "userView";
	}

	@RequestMapping("registration")
	public String registerUser(
			@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "firstname", required = false) String firstname,
			@RequestParam(value = "lastname", required = false) String lastname,
			@RequestParam(value = "password", required = false) String password,
			//@RequestParam(value = "anniversaire", required = false) Date anniversaire,
			@RequestParam(value = "sexe", required = false) String sexe,
			@RequestParam(value = "mail", required = false) String mail,
			@RequestParam(value = "telephone", required = false) String telephone,
			@RequestParam(value = "adresse", required = false) String adresse,
			@RequestParam(value = "ville", required = false) String ville,
			@RequestParam(value = "departement", required = false) String departement,
			@RequestParam(value = "cp", required = false) String cp,
			@RequestParam(value = "pays", required = false) String pays,
			Model model
	) {
		System.out.println("Controller client");
		System.out.println(username+ " " +firstname+ " " +lastname+ " " +password+ " " +sexe+ " " +mail+ " " +telephone+ " " +adresse+ " " +ville+ " " +departement+ " " +cp+ " " +pays);
		if(username != null &&
				firstname != null &&
				lastname != null &&
				password != null &&
				//anniversaire != null &&
				sexe != null &&
				mail != null &&
				telephone != null &&
				adresse != null &&
				ville != null &&
				departement != null &&
				cp != null &&
				pays != null
		)
		{
			clientManager.registerUser(username, firstname, lastname, password, sexe,
					mail, telephone, adresse, ville, departement, cp, pays); //anniversaire à ajouter
		}
		return "registrationView";
	}

}
