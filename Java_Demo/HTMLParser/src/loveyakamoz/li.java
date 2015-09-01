package loveyakamoz;import org.junit.Test;public class li{
/**
 * 作者博客地址
 */
@Test
public void  z0(){
	//http://allenj2ee.iteye.com/blog/222454
}
/**
 * 测试网址
 */
@Test
public void z1(){
	//http://roll.news.sina.com.cn/news/gnxw/gdxw1/index.shtml?qq-pf-to=pcqq.c2c
}
/**
 * 大概简介
 */
@Test
public void z2(){
	//HTMLParser具有小巧，快速的优点，缺点是相关文档比较少（英文的也少），很多功能需要自己摸索。对于初学者还是要费一些功夫的，而一旦上手以后，会发现HTMLParser的结构设计很巧妙，非常实用，基本你的各种需求都可以满足。
}
/**
 * 用法
 */


	/**
	 * 获取数据
	 */
	@Test
	public void a1(){
		//1、获取一个url
		//String url = "http://roll.news.sina.com.cn/news/gnxw/gdxw1/index.shtml?qq-pf-to=pcqq.c2c";
		//HttpURLConnection http = (HttpURLConnection) (new URL(url)).openConnection();
		//2.爬取网页文件
		//Parser parser = new Parser(http); 
	}
	/**
	 * 操作数据 之 函数浏览
	 */
	@Test
	public void a2(){
	    //HTMLParser将解析过的信息保存为一个树的结构。Node是信息保存的数据类型基础。
			//Node getParent ()：取得父节点
			//NodeList getChildren ()：取得子节点的列表
			//Node getFirstChild ()：取得第一个子节点
			//Node getLastChild ()：取得最后一个子节点
			//Node getPreviousSibling ()：取得前一个兄弟（不好意思，英文是兄弟姐妹，直译太麻烦而且不符合习惯，对不起女同胞了）
			//Node getNextSibling ()：取得下一个兄弟节点
			//取得Node内容的函数：
			//String getText ()：取得文本
			//String toPlainTextString()：取得纯文本信息。
			//String toHtml () ：取得HTML信息（原始HTML）
			//String toHtml (boolean verbatim)：取得HTML信息（原始HTML）
			//String toString ()：取得字符串信息（原始HTML）
			//Page getPage ()：取得这个Node对应的Page对象
			//int getStartPosition ()：取得这个Node在HTML页面中的起始位置
			//int getEndPosition ()：取得这个Node在HTML页面中的结束位置
			//用于Filter过滤的函数：
			//void collectInto (NodeList list, NodeFilter filter)：基于filter的条件对于这个节点进行过滤，符合条件的节点放到list中。
			//用于Visitor遍历的函数：
			//void accept (NodeVisitor visitor)：对这个Node应用visitor
			//用于修改内容的函数，这类用得比较少：
			//void setPage (Page page)：设置这个Node对应的Page对象
			//void setText (String text)：设置文本
			//void setChildren (NodeList children)：设置子节点列表
			//其他函数：
			//void doSemanticAction ()：执行这个Node对应的操作（只有少数Tag有对应的操作）
			//Object clone ()：接口Clone的抽象函数。
	}
	/**
	 * 操作数据 之 Node处理
	 */
	@Test
	public void a3(){
		//HTML的Node类继承关系  在包里面  node.png
			//AbstractNodes是Node的直接子类，也是一个抽象类  它的三个直接子类
			//RemarkNode，用于保存注释
			//TextNode 用于保存用户可见的文字信息
			//TagNode 包含了HTML语言中的所有标签
			
				//Node getParent ()：取得父节点
				//NodeList getChildren ()：取得子节点的列表
				//Node getFirstChild ()：取得第一个子节点
				//Node getLastChild ()：取得最后一个子节点
				//Node getPreviousSibling ()：取得前一个兄弟（不好意思，英文是兄弟姐妹，直译太麻烦而且不符合习惯，对不起女同胞了）
				//Node getNextSibling ()：取得下一个兄弟节点
				//取得Node内容的函数：
				//String getText ()：取得文本
				//String toPlainTextString()：取得纯文本信息。
				//String toHtml () ：取得HTML信息（原始HTML）
				//String toHtml (boolean verbatim)：取得HTML信息（原始HTML）
				//String toString ()：取得字符串信息（原始HTML）
				//Page getPage ()：取得这个Node对应的Page对象
				//int getStartPosition ()：取得这个Node在HTML页面中的起始位置
				//int getEndPosition ()：取得这个Node在HTML页面中的结束位置	
	}
	/**
	 * 操作数据 之 Filter类
	 */
	@Test
	public void a4(){
		//Filter就是对于结果进行过滤，取得需要的内容。
		//HTMLParser在org.htmlparser.filters包之内一共定义了16个不同的Filter
//----------------------------------------------------------------------------------------------------我是分割线 读代码专用-------------------------------------
			//判断类Filter：
			//TagNameFilter  根据Tag的名字进行过滤。
				//  NodeFilter filter = new TagNameFilter ("DIV");
				//	NodeList nodes = parser.extractAllNodesThatMatch(filter); 
			//HasAttributeFilter 	可以匹配出包含制定名字的属性，或者制定属性为指定值的节点
				//  HasAttributeFilter有3个构造函数：
					//	public HasAttributeFilter ();
						// 	NodeFilter filter = new HasAttributeFilter();
						//	NodeList nodes = parser.extractAllNodesThatMatch(filter);   什么也没有输出。
					//	public HasAttributeFilter (String attribute);
						//	NodeFilter filter = new HasAttributeFilter( "id" );
						//	NodeList nodes = parser.extractAllNodesThatMatch(filter);   
							// 		输出	getText:div id="top_main"		getText:div id="logoindex"
					//	public HasAttributeFilter (String attribute, String value);
						//	NodeFilter filter = new HasAttributeFilter( "id", "logoindex" );
						//	NodeList nodes = parser.extractAllNodesThatMatch(filter);
							// 		输出  getText:div id="logoindex"
			//HasChildFilter	返回有符合条件的子节点的节点，需要另外一个Filter作为过滤子节点的参数。
				//	NodeFilter innerFilter = new TagNameFilter ("DIV");
				//	NodeFilter filter = new HasChildFilter(innerFilter);
				// 	NodeList nodes = parser.extractAllNodesThatMatch(filter);
			//HasParentFilter
			//HasSiblingFilter
			//IsEqualFilter
//----------------------------------------------------------------------------------------------------我是分割线 读代码专用-------------------------------------
			//逻辑运算Filter：
			//AndFilter	把两种Filter进行组合，只有同时满足条件的Node才会被过滤。
				//	NodeFilter filterID = new HasAttributeFilter( "id" );
				//	NodeFilter filterChild = new HasChildFilter(filterA);
				//	NodeFilter filter = new AndFilter(filterID, filterChild);
					// getText:div id="logoindex"
			//NotFilter
			//OrFilter
			//XorFilter
//----------------------------------------------------------------------------------------------------我是分割线 读代码专用-------------------------------------
			//其他Filter：
			//NodeClassFilter 	用于判断节点类型是否是某个特定的Node类型
				//	NodeFilter filter = new NodeClassFilter(RemarkNode.class);
					// 针对注释进行过滤
					
			//StringFilter		过滤可以显示字符串中包含指定内容的Tag
				//	  NodeFilter filter = new StringFilter("www.baizeju.com");
					//	内容字符串和链接的文本字符串的Tag都被输出了，但是注释和链接Tag本身没有输出
			//LinkStringFilter	判断链接中是否包含某个特定的字符串，可以用来过滤出指向某个特定网站的链接。
				//	 NodeFilter filter = new LinkStringFilter("www.baizeju.com");
					//	输出结果	getText:a href="http://www.baizeju.com"
			//LinkRegexFilter
			//RegexFilter
			//CssSelectorNodeFilter

	}
	/**
	 * 操作数据 之 Visitor类
	 */
	@Test
	public void a5(){
		//NodeVisitor 	遍历内容树的每一个节点，对于符合条件的节点进行处理。
	}


/**
 * 嘿嘿
 */
@Test
public void a(){
	//http://allenj2ee.iteye.com/blog/222458
	//垂直搜索引擎，比较了nekohtml和htmlparser 的功能，尽管nekohtml在容错性、性能等方面的口碑好像比htmlparser好（htmlunit也用的是nekohtml），但感觉 nekohtml的测试用例和文档都比htmlparser都少，而且htmlparser基本上能够满足垂直搜索引擎页面处理分析的需求，因此先研究一 下htmlparser的使用，有空再研究nekohtml和mozilla html parser的使用。
}














}
