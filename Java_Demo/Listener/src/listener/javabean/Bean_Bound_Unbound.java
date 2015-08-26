package listener.javabean;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionListener;
/**
 * 监听javabean的绑定和解除绑定
 */
public class Bean_Bound_Unbound implements HttpSessionBindingListener{
	private String id;
	private String username;
	
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
	/**
	 * 如果javabean放到session域里面调用这个方法
	 * @author Lilac
	 */
	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		
	}
	/**
	 * 如果javabean从session域里面移除调用这个方法
	 * @author Lilac
	 */
	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		
	}
}
