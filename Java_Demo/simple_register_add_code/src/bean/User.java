package bean;

public class User {
	private String id;
	private String username;
	private String password;
	private String addr;
	public User() {
		super();
	}
	public User(String id, String username, String password, String addr) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", addr=" + addr + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}
