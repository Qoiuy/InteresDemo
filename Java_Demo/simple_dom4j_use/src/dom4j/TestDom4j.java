package dom4j;

import java.util.List;

import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class TestDom4j {

	public static void main(String[] args) throws Exception {
		
		//show_up_p1_name();
		//show_down_p1_age();
		//show_up_p1_name_value();
		//show_p1_down_all_value()
	}
	/*查找 上面的p1标签里面的name的信息*/
	public static void show_up_p1_name() throws Exception{
	     System.out.println(new SAXReader().read("src/person.xml").getRootElement().element("p1").element("name").getText());
	}
	/*查找 下面的p1标签里面的age的信息*/
	public static void show_down_p1_age()throws Exception{
		List<Element> list = new SAXReader().read("src/person.xml").getRootElement().elements("p1");
		System.out.println(list.get(1).element("age").getText());
	}
	/*查找跑p1标签下面所有的标签值*/
	public static void show_p1_down_all_value() throws Exception{
		List<Element> list = new SAXReader().read("src/person.xml").getRootElement().elements("p1");
		for (Element element : list) {
			String value = element.getText();
			System.out.println(value);
		}
	}
	/*查找上面的p1标签里面name的标签值*/
	public static void show_up_p1_name_value() throws Exception{
		System.out.println(new SAXReader().read("src/person.xml").getRootElement().element("p1").element("name").attributeValue("id1"));
	}
	
	
	
}
