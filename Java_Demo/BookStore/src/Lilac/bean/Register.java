package Lilac.bean;

public class Register {
	private  String email;
	private  String username;
	private  String password;
	private  String gender;
	private  String telephone;
	private  String introduce;
	
	public Register() {
		super();
	}
	public Register(String email, String username, String password,
			String gender, String telephone, String introduce) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.telephone = telephone;
		this.introduce = introduce;
	}
	@Override
	public String toString() {
		return "Register [email=" + email + ", username=" + username
				+ ", password=" + password + ", gender=" + gender
				+ ", telephone=" + telephone + ", introduce=" + introduce + "]";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
}
