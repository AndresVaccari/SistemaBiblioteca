package finalLibros;

public class User {

	private String user;
	private String password;
	private Boolean admin;
	
	public String getUser() {
		return user;
	}
	
	public User(String user, String password, boolean admin) {
		this.user = user;
		this.password = password;
		this.admin = admin;
	}
	
	public String getPassword() {
		return password;
	}
	
	public Boolean getAdmin() {
		return admin;
	}
	
	
}


