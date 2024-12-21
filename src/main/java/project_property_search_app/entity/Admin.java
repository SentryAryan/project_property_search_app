package project_property_search_app.entity;

public class Admin {
	private int adminId;
    private String username;
    private String password;
    private String email;
    
    public Admin() {}
    
    

    public Admin(int adminId, String username, String password, String email) {
		super();
		this.adminId = adminId;
		this.username = username;
		this.password = password;
		this.email = email;
	}



	// Getters and setters
    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", username=" + username + ", password=" + password + ", email=" + email
				+ "]";
	}
    
}