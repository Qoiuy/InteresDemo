package listener.javabean;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
/**
 * 监听javabean的钝化和活化
 * @author Lilac
 *
 */

public class Bean_DidActivate_WillPassivate implements
	Serializable,HttpSessionActivationListener {
	
	private String id;
	private String name ;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 活化  把本地硬盘session序列化文件反序列化到项目里面
	 * @param arg0
	 */
	@Override
	public void sessionDidActivate(HttpSessionEvent arg0) {

	}

	/**
	 * 钝化  把session序列化本地硬盘
	 * @param arg0
	 */
	@Override
	public void sessionWillPassivate(HttpSessionEvent arg0) {

	}

}
