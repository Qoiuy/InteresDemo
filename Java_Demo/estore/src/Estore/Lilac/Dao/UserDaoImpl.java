package Estore.Lilac.Dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import Estore.Lilac.Bean.User;

public class UserDaoImpl implements UserDao {

	@Override
	public User login(User user) {
		try {
			QueryRunner runner = new QueryRunner(new ComboPooledDataSource());
			String sql = "select * from tb_user where username=? and password=? and status=?";
			User u = runner.query(sql, new BeanHandler<User>(User.class), user.getUsername(), user.getPassword(), "1");
			return u;
		}catch(Exception e ){
			e.printStackTrace();
		}
		return null;
	}

}
