package utils;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import bean.Account;



public class dbutils {
	
	/**
	 * 向数据库中添加一条记录
	 * @author Lilac
	 * @throws Exception
	 */
	public void add_account() throws Exception {
		QueryRunner runner = new QueryRunner(C3p0.getConnection()); 
		int rows = runner.update("insert into account values(?,?,?)", "101","lisi",500);
		System.out.println(rows);
	}
	
	@Test 
	public void test_add_account() throws Exception{
		add_account();
	}
	/** 
	 * 向数据库中删除一条记录
	 * @author Lilac
	 * @throws Exception
	 */

	public void del_account() throws Exception{
		QueryRunner runner = new QueryRunner(C3p0.getConnection());
		int rows = runner.update("delete from account where name=?", "lisi");
		System.out.println(rows);
	}
	
	@Test
	public void test_del_account()throws Exception{
		del_account();
	}
	
	/**
	 * 向数据库中修改一条数据
	 * @author lilac
	 */
	public void change_account() throws Exception{
		QueryRunner runner = new QueryRunner(C3p0.getConnection());
		int rows = runner.update("update account set sal=? where name=?", 400,"alisi");
		System.out.println(rows);
	}
	@Test
	public void test_change_account()throws Exception{
		change_account();
	}
	/**
	 * 在数据库中查找数据
	 * @author Lilac
	 * @throws Exception
	 */
	public void search_account() throws Exception{
		QueryRunner runner = new QueryRunner(C3p0.getConnection());
		List<Account> account = runner.query("select * from account", new BeanListHandler<Account>(Account.class));
		for (Account account2 : account) {
			System.out.println(account2.getId()+" ::"+account2.getName()+" ::"+ account2.getSal());
		}
	}
	@Test
	public void test_search_account() throws Exception{
		search_account();
	}

	
	
}


