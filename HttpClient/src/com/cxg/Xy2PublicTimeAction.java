package com.cxg;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

public class Xy2PublicTimeAction {
	
	//com.opensymphony.xwork2.ActionContext
	public String question;
	public String url = "http://xy2.gm.163.com/cgi-bin/csa/csa_sprite.py";  
	
	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public void queryMessage(){
		HttpServletRequest request = ServletActionContext.getRequest();
		setQuestion(request.getParameter("question"));
        Map<String, String> map = new HashMap<String, String>();  
        map.put("act","ask");
        map.put("question",question);
        map.put("product_name","xy2");
        String msg = UrlUtil.post(url, map);  
        ResponseWriter.writerString(msg);
	}
	
}
