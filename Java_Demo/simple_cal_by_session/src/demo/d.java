package demo;

public class d {
	String string;
	Integer integer;
	public d() {
		super();
		// TODO Auto-generated constructor stub
	}
	public d(String string, Integer integer) {
		super();
		this.string = string;
		this.integer = integer;
	}
	@Override
	public String toString() {
		return "d [string=" + string + ", integer=" + integer + "]";
	}
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	public Integer getInteger() {
		return integer;
	}
	public void setInteger(Integer integer) {
		this.integer = integer;
	}
}
