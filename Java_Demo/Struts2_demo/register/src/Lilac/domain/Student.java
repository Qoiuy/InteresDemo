package Lilac.domain;

public class Student {

	/*
	 create database day25 ;
	 use day25;
	 create table students(
	 id int primary key auto_increment,
	 username varchar(50) not null,
	 password varchar(20) not null,
	 email varchar(30) not null unique,
	 telphone varchar(30) default "乱来"
	 );
	 */
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", username=" + username + ", password="
				+ password + ", email=" + email + ", telphone=" + telphone
				+ "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	private Integer id;
	private String username;
	private String password;
	private String email;
	private String telphone;
	
}
