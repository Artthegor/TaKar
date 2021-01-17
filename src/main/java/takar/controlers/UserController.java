package takar.controlers;

import com.unboundid.ldap.sdk.LDAPConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import takar.dataManagementServices.IClientManagement;
import takar.dataManagementServices.IUserManagment;
import takar.model.User;

import takar.repositories.UserRepository;

import java.util.regex.Pattern;


@Controller
@RequestMapping("authentication")
public class UserController {
	@Autowired
	private IUserManagment userManager;

	@Autowired
	private IClientManagement clientManager;

	@Autowired
	private UserRepository userRepo;

	String erreur = "";


	@RequestMapping("registration")
	public String registerUser(
			@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "firstname", required = false) String firstname,
			@RequestParam(value = "lastname", required = false) String lastname,
			@RequestParam(value = "password", required = false) String password,
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
				sexe != null &&
				mail != null &&
				telephone != null &&
				adresse != null &&
				ville != null &&
				departement != null &&
				cp != null &&
				pays != null &&
				!username.trim().isEmpty() &&
				!firstname.trim().isEmpty() &&
				!lastname.trim().isEmpty() &&
				password.length() >= 4 &&
				password.length() < 20 &&
				!sexe.trim().isEmpty() &&
				isValidEMail(mail) &&
				isValidPhone(telephone) &&
				!adresse.trim().isEmpty() &&
				!ville.trim().isEmpty() &&
				!departement.trim().isEmpty() &&
				isValidCP(cp) &&
				!pays.trim().isEmpty()
		)
		{
			if(!clientManager.isUsernameExist(username)){
				clientManager.registerUser(username, firstname, lastname, password, sexe,
						mail, telephone, adresse, ville, departement, cp, pays);

				return "formConnexion";
			}else{
				model.addAttribute("erreur", "Username déjà utilisé");
				return "registrationView";
			}




		}else{
			if(username != null ||
					firstname != null ||
					lastname != null ||
					password != null ||
					sexe != null ||
					mail != null ||
					telephone != null ||
					adresse != null ||
					ville != null ||
					departement != null ||
					cp != null ||
					pays != null){
				model.addAttribute("erreur", "Erreur dans un des champs saisis");
			}
			return "registrationView";
		}


	}
	public static boolean isValidEMail(String email)
	{
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
				"[a-zA-Z0-9_+&*-]+)*@" +
				"(?:[a-zA-Z0-9-]+\\.)+[a-z" +
				"A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}
	public static boolean isValidPhone(String phone)
	{
		String emailRegex = "^[0-9]{1,15}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (phone == null)
			return false;
		return pat.matcher(phone).matches();
	}
	public static boolean isValidCP(String cp)
	{
		String emailRegex = "^[0-9]{1,10}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (cp == null)
			return false;
		return pat.matcher(cp).matches();
	}
}
