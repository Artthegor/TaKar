package takar.model;

import javax.persistence.*;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long userID;
	
	String username;
	String password;

	
	public User(){}
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}



	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	
}
