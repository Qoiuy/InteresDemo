package bean;

public class Register {
	
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Register(String mail, String username, String password, String sex,
			String phone, String descript, String code) {
		super();
		this.mail = mail;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.phone = phone;
		this.descript = descript;
		this.code = code;
	}
	@Override
	public String toString() {
		return "Register [mail=" + mail + ", username=" + username
				+ ", password=" + password + ", sex=" + sex + ", phone="
				+ phone + ", descript=" + descript + ", code=" + code + "]";
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	private String mail;
	private String username;
	private String password;
	private String sex;
	private String phone;
	private String descript;
	private String code;
	
	
	
}
