package Lilac.utils;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3o0Utils {

	private static final ComboPooledDataSource datasource = new ComboPooledDataSource();
	public static DataSource getDataSource() {
		return datasource;
	}

}
