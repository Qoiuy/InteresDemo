package Lilac.action;

import Lilac.domain.Converter;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class ConverterAction extends ActionSupport implements ModelDriven<Converter>{
	Converter converter = new Converter();
	
	
	
	public String converte(){
		System.out.println(converter.getDays());
		return SUCCESS;
	}
	
	@Override
	public Converter getModel() {
		return converter;
	}

//	@Override
//	public void validate() {
//		if(converter.getDays() == null){
//			addFieldError("nonumber", "没有输入日期 请重新输入");
//		}
//	}

}
