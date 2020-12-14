package takar.model;

import javax.persistence.*;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long userID;
	
	String nom;
	String prenom;

	
	public User(){}
	
	public User(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	
}
