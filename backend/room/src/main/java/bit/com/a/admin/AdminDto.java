package bit.com.a.admin;

public class AdminDto {
    private int id;
    private String adminId;
    private String adminPassword;
    private String name;
    private String registered_at;
    private String un_registered_at;
    private String auth;

    public AdminDto() {
    }

    public AdminDto(int id, String adminId, String adminPassword, String name, String registered_at, String un_registered_at, String auth) {
		this.id = id;
		this.adminId = adminId;
		this.adminPassword = adminPassword;
		this.name = name;
		this.registered_at = registered_at;
		this.un_registered_at = un_registered_at;
		this.auth = auth;
	}
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegistered_at() {
		return registered_at;
	}
	public void setRegistered_at(String registered_at) {
		this.registered_at = registered_at;
	}
	public String getUn_registered_at() {
		return un_registered_at;
	}
	public void setUn_registered_at(String un_registered_at) {
		this.un_registered_at = un_registered_at;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
    }
    
    public String toString() {
		return "asdf [id=" + id + ", adminId=" + adminId + ", adminPassword=" + adminPassword + ", name=" + name
				+ ", registered_at=" + registered_at + ", un_registered_at=" + un_registered_at + ", auth=" + auth
				+ "]";
	}
}