package com.cxg.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * QQ客户端。
 */
public class QQClient {
	//3GQQ登陆地址
	private static final String QQ_LOGIN_URL="http://pt.3g.qq.com/handleLogin";
	private static String SID=null;
	static Random random=new Random();
	public QQClient(){
		
	}
	
	/**
	 * QQ登陆
	 */
	public static String login(final String qq,final String password){
		HashMap<String, String> params=new HashMap<String, String>();
		params.put("login_url", "http://pt.3g.qq.com/s?aid=nLogin");
		params.put("sidtype", "1");
		params.put("loginTitle", "手机腾讯网");
		params.put("bid", "0");
		params.put("qq", qq);
		params.put("pwd", password);
		params.put("loginType", "1");
		try {
			String response=WebUtils.doPost(QQ_LOGIN_URL, params, 0, 0);
			System.out.println(response);
			int sidIndex=response.indexOf("sid");
			SID=response.substring(sidIndex+4, sidIndex+28);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SID;
	}
}
