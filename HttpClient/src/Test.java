import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.cxg.client.QQClient;
import com.cxg.httpclient.RequestRunnable;

public class Test {
	/**
	 *  <input type="hidden" name="aid" value="15000101" />
<input type="hidden" name="u1" value="http://imgcache.qq.com/qzone/v5/loginsucc.html?para=izone" />
<input type="hidden" name="fp" value="loginerroralert" />
<input type="hidden" name="h" value="1" />
<input type="hidden" name="ptredirect" value="1" />
<input type="hidden" name="ptlang" value="2052" />

        <input type="hidden" name="from_ui" value="1" />
        <input type="hidden" name="dumy" value="" />

	 */
	public static String url="http://www.pengyou.com/?http%3A%2F%2Fhome.pengyou.com%2Findex.php%3Fmod%3Dhome";
	public static String url4="http://apps.pengyou.com/607";
	public static String url5="http://ui.ptlogin2.qq.com/cgi-bin/login?link_target=blank&appid=15000101&hide_title_bar=1&no_verifyimg=1&s_url=http%3A%2F%2Fimgcache.qq.com%2Fqzone%2Fv5%2Floginsucc.html%3fpara%3dizone&f_url=loginerroralert&target=top&qlogin_jumpname=jump&ptcss=0#1280797312671_1280797312890";
	public static String url7="http://ui.ptlogin2.pengyou.com/cgi-bin/login?appid=15004601&qlogin_jumpname=&hide_title_bar=1&s_url=http://www.pengyou.com/index.php%3fmod%3Dlogin2%26act%3Dqqlogin&self_regurl=http://reg.pengyou.com/emailreg.html&css=http://imgcache.qq.com/ptcss/b2/pengyou/15000901/login_page.css";
	
	public static String url2="http://captcha.pengyou.com/getimage?aid=15006074601&r=0.709678670624271&uin=274736155";
	public static String url3="http://ptlogin2.pengyou.com/login";//post//u=?,p=?,verifycode=?
	public static String url6="http://ptlogin2.qq.com/login";
	public static void main2(String[] args) {
		String path="http://ptlogin2.qq.com/check?uin=274736155&appid=1003903&r=0.2664082343145449";
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=false;
		new Thread(new RequestRunnable(url7,list,post)).start();
		new Thread(new RequestRunnable(url2,list,post,true)).start();
		Scanner scan=new Scanner(System.in);
		
		
		 list=new ArrayList<NameValuePair>();
		 post=true;
		 list.add(new BasicNameValuePair("u","274736155"));
		 list.add(new BasicNameValuePair("p","shifuxia"));
		 list.add(new BasicNameValuePair("aid","15006074601"));
		 list.add(new BasicNameValuePair("u1","http://www.pengyou.com/index.php?mod=login2&amp;act=qqlogin"));
		 list.add(new BasicNameValuePair("fp","loginerroralert"));
		 list.add(new BasicNameValuePair("h","1"));
		 list.add(new BasicNameValuePair("ptredirect","1"));
		 list.add(new BasicNameValuePair("ptlang","2052"));
		 list.add(new BasicNameValuePair("from_ui","1"));
		 list.add(new BasicNameValuePair("dumy",""));
		 String verifyCode=scan.next();
		 list.add(new BasicNameValuePair("verifycode",verifyCode));
		 
		 
		 
		new Thread(new RequestRunnable(url3,list,post)).start();
	//	String sid=QQClient.login("274736155", "shifuxia");
	//	new Thread(new RequestRunnable("http://apps.pengyou.com/607?via="+sid,new ArrayList<NameValuePair>(),false)).start();
		
		
	}
	public static String url_base="http://localhost:8080/ellassy/";
	public static String url_login="http://localhost:8080/ellassy/login/login";
	public static String url_updateInfo="http://localhost:8080/ellassy/member/updateInfo";
	public static void main(String[] args) {
		rebate();
	}
	public static void login(){
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("phone","123456"));
		list.add(new BasicNameValuePair("password",MD5.getMD5ofStr("123456")));
		new Thread(new RequestRunnable(url_login,list,post)).start();
	}
	public static void update(){
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("member_id","3"));
		list.add(new BasicNameValuePair("nick_name","刘明"));
		list.add(new BasicNameValuePair("sex","1"));
		list.add(new BasicNameValuePair("email","liuming@qq.com"));
		new Thread(new RequestRunnable(url_updateInfo,list,post)).start();
	}
	public static void balance(){
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("member_id","3"));
		new Thread(new RequestRunnable(url_base+"account/balance",list,post)).start();
	
	}
	public static void rebate(){
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("member_id","3"));
		list.add(new BasicNameValuePair("type","tj"));
		new Thread(new RequestRunnable(url_base+"account/rebateList",list,post)).start();
	
	}
}
