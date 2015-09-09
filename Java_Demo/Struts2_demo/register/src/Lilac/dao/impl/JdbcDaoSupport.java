package Lilac.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import Lilac.utils.C3o0Utils;

public class JdbcDaoSupport {
		private QueryRunner runner = new QueryRunner(C3o0Utils.getDataSource());
	 	protected <T> T query(String sql, ResultSetHandler<T> rsh, Object... params) {
	 		try {
	 			return runner.query(sql, rsh, params);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
	    }
	 	protected int update(String sql, Object... params){
	 		try{
	 			return runner.update(sql, params);
	 			}catch(SQLException e) {
	 				throw new RuntimeException(e);
	 			}
	    }
}
