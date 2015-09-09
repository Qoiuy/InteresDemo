package Lilac.domain;

import java.util.Date;

public class Converter {


	@Override
	public String toString() {
		return "Converter [days=" + days + "]";
	}

	public Date getDays() {
		return days;
	}

	public void setDays(Date days) {
		this.days = days;
	}

	private Date days;
}
