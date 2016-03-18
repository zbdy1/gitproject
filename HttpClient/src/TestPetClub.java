import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import com.cxg.httpclient.RequestRunnable;


public class TestPetClub {
	public static String url_base="http://115.28.180.91:9080/petClub/";
	//public static String url_base="http://127.0.0.1:8080/superMom/";
	//public static String url_base="http://106.37.191.116:9080/ellassy/";
	public static void login(){
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("phone","1234569"));
		list.add(new BasicNameValuePair("password",MD5.getMD5ofStr("123456")));
		new Thread(new RequestRunnable(url_base+"login/login",list,post)).start();
	}
	public static void register(){
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("phone","1234569"));
		list.add(new BasicNameValuePair("password","123456"));
		new Thread(new RequestRunnable(url_base+"member/register",list,post)).start();
	}
	public static void introduction(){
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("rank_id","12"));
		new Thread(new RequestRunnable(url_base+"member/introduction",list,post)).start();
	}
	public static void addr(){
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("member_id","237"));
		new Thread(new RequestRunnable(url_base+"goodsAddr/addrs",list,post)).start();
	}
	public static void addAddr(){
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("member_id","237"));
		list.add(new BasicNameValuePair("addr","����·19��B��"));
		list.add(new BasicNameValuePair("consignee","����Ů"));
		list.add(new BasicNameValuePair("phone","12311231345"));
		list.add(new BasicNameValuePair("province","��"));
		list.add(new BasicNameValuePair("city","һ"));
		list.add(new BasicNameValuePair("country","Ҫ"));
		
		new Thread(new RequestRunnable(url_base+"goodsAddr/addAddr",list,post)).start();
	}
	public static void updateAddr(){
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("addr_id","13"));
		list.add(new BasicNameValuePair("addr","����·19��B��5654��"));
		list.add(new BasicNameValuePair("consignee","����Ů"));
		list.add(new BasicNameValuePair("phone","12311231345"));
		new Thread(new RequestRunnable(url_base+"goodsAddr/updateAddr",list,post)).start();
	}
	public static void deleteAddr(){
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("addr_id","10"));
		new Thread(new RequestRunnable(url_base+"goodsAddr/deleteAddr",list,post)).start();
	}
	public static void update(){
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("member_id","3"));
		list.add(new BasicNameValuePair("nick_name","�����û�"));
		//list.add(new BasicNameValuePair("sex","1"));
		//list.add(new BasicNameValuePair("email","liugui@qq.com"));
		new Thread(new RequestRunnable(url_base+"member/updateInfo",list,post)).start();
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
		new Thread(new RequestRunnable(url_base+"account/rebate",list,post)).start();
	
	}
	public static void rebateList(){
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("member_id","3"));
		list.add(new BasicNameValuePair("type","gw"));
		new Thread(new RequestRunnable(url_base+"account/rebateList",list,post)).start();
	
	}
	
	public static void salary(){
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("member_id","3"));
		new Thread(new RequestRunnable(url_base+"account/salary",list,post)).start();
	
	}
	public static void salaryDetails(){
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("salary_id","2"));
		new Thread(new RequestRunnable(url_base+"account/salaryDetails",list,post)).start();
	
	}
	public static void ecoupon(){
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("member_id","3"));
		list.add(new BasicNameValuePair("type","0"));
		new Thread(new RequestRunnable(url_base+"account/ecoupon",list,post)).start();
	
	}
	private static void advise() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("content","����Է��Ե��ر��"));
		list.add(new BasicNameValuePair("member_id","1"));
		new Thread(new RequestRunnable(url_base+"member/advise",list,post)).start();

	}
	private static void allTopic() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
	//	list.add(new BasicNameValuePair("page_size","1"));
		new Thread(new RequestRunnable(url_base+"topic/allTopic",list,post)).start();

	}
	private static void topicDetails() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		list.add(new BasicNameValuePair("topic_id","43"));
		list.add(new BasicNameValuePair("pagesize","10"));
		boolean post=true;
		new Thread(new RequestRunnable(url_base+"topic/topicDetails",list,post)).start();
	}
	private static void todayTopic() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("page_size","10"));
		new Thread(new RequestRunnable(url_base+"topic/todayTopic",list,post)).start();
	}
	private static void commentList() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("topic_id","1"));
		list.add(new BasicNameValuePair("id","31"));
		list.add(new BasicNameValuePair("page","-1"));
		list.add(new BasicNameValuePair("page_size","10"));
		new Thread(new RequestRunnable(url_base+"topic/commentList",list,post)).start();
	}
	private static void comment() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("topic_id","1"));
		list.add(new BasicNameValuePair("content","����һ��"));
		list.add(new BasicNameValuePair("member_id","1"));
		new Thread(new RequestRunnable(url_base+"topic/comment",list,post)).start();
	}
	private static void dutyTeacher() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		new Thread(new RequestRunnable(url_base+"teacher/dutyTeacher",list,post)).start();
	}
	private static void teacherList() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		new Thread(new RequestRunnable(url_base+"teacher/teacherList",list,post)).start();
	}
	private static void questions() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("member_id","3"));
		list.add(new BasicNameValuePair("is_finish","0"));
		new Thread(new RequestRunnable(url_base+"customMade/questions",list,post)).start();
	}
	private static void typeList() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		new Thread(new RequestRunnable(url_base+"product/typeList",list,post)).start();
	}
	private static void productList() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("type_id","1"));
		new Thread(new RequestRunnable(url_base+"product/productList",list,post)).start();
	}
	private static void productDetails() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("product_id","60"));
		new Thread(new RequestRunnable(url_base+"product/productDetails",list,post)).start();
	}
	private static void teacherDetails() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("teacher_id","2"));
		new Thread(new RequestRunnable(url_base+"teacher/teacherDetails",list,post)).start();
	}
	private static void askList() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
	//	list.add(new BasicNameValuePair("teacher_id","2"));
		new Thread(new RequestRunnable(url_base+"teacher/askList",list,post)).start();
	}
	private static void articleList() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("teacher_id","2"));
		new Thread(new RequestRunnable(url_base+"teacher/articleList",list,post)).start();
	}
	private static void articleDetails() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("article_id","3"));
		new Thread(new RequestRunnable(url_base+"teacher/articleDetails",list,post)).start();
	}
	private static void ask() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("member_id","3"));
		list.add(new BasicNameValuePair("title","��α�������"));
		list.add(new BasicNameValuePair("description","����ܳ��õı�������"));
		list.add(new BasicNameValuePair("teacher_id","2"));
		list.add(new BasicNameValuePair("province","����"));
		list.add(new BasicNameValuePair("city","����"));
		list.add(new BasicNameValuePair("age","һ���"));
		list.add(new BasicNameValuePair("sex","0"));
		
		new Thread(new RequestRunnable(url_base+"teacher/ask",list,post)).start();
	}
	private static void room_typeList() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		new Thread(new RequestRunnable(url_base+"room/typeList",list,post)).start();
	}
	private static void searchVideo() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		list.add(new BasicNameValuePair("key","��"));
		boolean post=true;
		new Thread(new RequestRunnable(url_base+"room/searchVideo",list,post)).start();
	}
	private static void recommend() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		//list.add(new BasicNameValuePair("page_size","2"));
		//list.add(new BasicNameValuePair("page","1"));
		//list.add(new BasicNameValuePair("id","25"));
		new Thread(new RequestRunnable(url_base+"room/recommend",list,post)).start();
	}
	private static void room_videoList() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		new Thread(new RequestRunnable(url_base+"room/videoList",list,post)).start();
	}
	private static void room_videoDetails() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		list.add(new BasicNameValuePair("video_id","2"));
		boolean post=true;
		new Thread(new RequestRunnable(url_base+"room/videoDetails",list,post)).start();
	}
	private static void information() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		new Thread(new RequestRunnable(url_base+"customMade/information",list,post)).start();
	}
	private static void type() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("type","1"));
		new Thread(new RequestRunnable(url_base+"customMade/type",list,post)).start();
	}
	private static void customMade_ask() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("member_id","3"));
		list.add(new BasicNameValuePair("title","��α��ֿ���"));
		list.add(new BasicNameValuePair("description","����ܱ�֤������Ҹ�"));
		list.add(new BasicNameValuePair("second_type","2"));
		list.add(new BasicNameValuePair("first_type","1"));
		list.add(new BasicNameValuePair("teacher_id","1"));
		new Thread(new RequestRunnable(url_base+"customMade/ask",list,post)).start();
	}
	private static void buy() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("member_id","3"));
		list.add(new BasicNameValuePair("list","[{\"product_id\":\"1\",\"num\":\"2\"},{\"product_id\":\"2\",\"num\":\"1\"}]"));	
		//String s=" [{\"product_id\":\"3\",\"num\":\"1\"},{\"product_id\":\"49\",\"num\":\"1\"},{\"product_id\":\"24\",\"num\":\"1\"},{\"product_id\":\"3\",\"num\":\"1\"},{\"product_id\":\"1\",\"num\":\"2\"},{\"product_id\":\"34\",\"num\":\"1\"},{\"product_id\":\"25\",\"num\":\"1\"},{\"product_id\":\"21\",\"num\":\"1\"},{\"product_id\":\"22\",\"num\":\"1\"},{\"product_id\":\"23\",\"num\":\"1\"},{\"product_id\":\"2\",\"num\":\"2\"},{\"product_id\":\"46\",\"num\":\"1\"},{\"product_id\":\"19\",\"num\":\"4\"},{\"product_id\":\"45\",\"num\":\"1\"}]";
		//list.add(new BasicNameValuePair("list",s));
		new Thread(new RequestRunnable(url_base+"product/buy",list,post)).start();
	}
	private static void myOrders() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("member_id","3"));	
		new Thread(new RequestRunnable(url_base+"product/myOrders",list,post)).start();
	}
	private static void orderDetails() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("order_id","1"));	
		new Thread(new RequestRunnable(url_base+"product/orderDetails",list,post)).start();
	}
	private static void pay() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("order_id","885"));	
		list.add(new BasicNameValuePair("member_id","3"));	
		list.add(new BasicNameValuePair("addr_id","90"));
		//list.add(new BasicNameValuePair("use_ecoupon_ids","4"));
		//list.add(new BasicNameValuePair("use_balance","1"));	
		new Thread(new RequestRunnable(url_base+"product/pay",list,post)).start();
	}
	private static void addGoodsCart() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("member_id","3"));	
		list.add(new BasicNameValuePair("goods_id","19"));
		list.add(new BasicNameValuePair("num","2"));
		new Thread(new RequestRunnable(url_base+"goodsCart/addGoods",list,post)).start();
	}
	private static void goodsList() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("member_id","3"));	
		new Thread(new RequestRunnable(url_base+"goodsCart/goodsList",list,post)).start();
	}
	private static void delGoods() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("goodsCart_id","1"));	
		new Thread(new RequestRunnable(url_base+"goodsCart/delGoods",list,post)).start();
	}
	private static void useBalance() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("member_id","3"));
		list.add(new BasicNameValuePair("order_id","110"));	
		list.add(new BasicNameValuePair("use_balance","1"));	
		new Thread(new RequestRunnable(url_base+"product/useBalance",list,post)).start();
	}
	private static void useEcoupon() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("member_id","3"));
		list.add(new BasicNameValuePair("order_id","110"));	
		list.add(new BasicNameValuePair("use_ecoupon_ids","4"));	
		new Thread(new RequestRunnable(url_base+"product/useEcoupon",list,post)).start();
	}
	private static void goodpoint() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("member_id","3"));
		list.add(new BasicNameValuePair("ask_id","210"));	
		new Thread(new RequestRunnable(url_base+"teacher/goodpoint",list,post)).start();
	}
	private static void membershipList() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		new Thread(new RequestRunnable(url_base+"product/membershipList",list,post)).start();
	}
	private static void membershipDetails() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("membership_id","13"));
		new Thread(new RequestRunnable(url_base+"product/membershipDetails",list,post)).start();
	}
	private static void buyMembership() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("membership_id","12"));
		list.add(new BasicNameValuePair("member_id","3"));
		new Thread(new RequestRunnable(url_base+"product/buyMembership",list,post)).start();
	}
	private static void payMembership() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("membership_id","12"));
		list.add(new BasicNameValuePair("member_id","3"));
		list.add(new BasicNameValuePair("order_id","857"));
		list.add(new BasicNameValuePair("addr_id","90"));
		new Thread(new RequestRunnable(url_base+"product/payMembership",list,post)).start();
	}
	private static void membership() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("member_id","3"));
		new Thread(new RequestRunnable(url_base+"product/membership",list,post)).start();
	}
	private static void reply() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("member_id","3"));
		list.add(new BasicNameValuePair("content","��ʦ������?"));
		list.add(new BasicNameValuePair("ask_id","210"));
		new Thread(new RequestRunnable(url_base+"teacher/reply",list,post)).start();
	}
	private static void custom_comment() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("member_id","3"));
		list.add(new BasicNameValuePair("content","лл��ʦ"));
		list.add(new BasicNameValuePair("ask_id","6"));
		list.add(new BasicNameValuePair("repl_id","4"));
		list.add(new BasicNameValuePair("is_sharing","0"));
		new Thread(new RequestRunnable(url_base+"customMade/comment",list,post)).start();
	}
	
	private static void myAskList() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("member_id","220"));
		new Thread(new RequestRunnable(url_base+"teacher/myAskList",list,post)).start();
	}
	private static void questionDetails() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("id","210"));
		new Thread(new RequestRunnable(url_base+"teacher/questionDetails",list,post)).start();
	}
	private static void sharing() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		new Thread(new RequestRunnable(url_base+"customMade/sharing",list,post)).start();
	}
	private static void topic_sharing() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("member_id","3"));
		list.add(new BasicNameValuePair("topic_id","4"));	
		new Thread(new RequestRunnable(url_base+"topic/sharing",list,post)).start();
	}
	private static void aboutus() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		new Thread(new RequestRunnable(url_base+"aboutus",list,post)).start();
	}
	private static void message() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("member_id","108"));
		new Thread(new RequestRunnable(url_base+"account/message",list,post)).start();
	}
	private static void changePassword() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("member_id","3"));
		list.add(new BasicNameValuePair("password",MD5.getMD5ofStr("123456")));
		list.add(new BasicNameValuePair("old_password",MD5.getMD5ofStr("123456")));
		new Thread(new RequestRunnable(url_base+"member/changePassword",list,post)).start();
	}
	private static void searchProductList() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("key","��ʪ"));
		list.add(new BasicNameValuePair("page_size","1"));
		list.add(new BasicNameValuePair("page","1"));
		list.add(new BasicNameValuePair("orderby","1"));
		list.add(new BasicNameValuePair("bytype","1"));
		new Thread(new RequestRunnable(url_base+"product/searchProductList",list,post)).start();
	}
	private static void recommendProductList() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		//list.add(new BasicNameValuePair("key","3"));
		new Thread(new RequestRunnable(url_base+"product/recommendProductList",list,post)).start();
	}
	private static void goodsCount() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("member_id","3"));
		new Thread(new RequestRunnable(url_base+"goodsCart/goodsCount",list,post)).start();
	}
	private static void history() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		//list.add(new BasicNameValuePair("page_size","2"));
		//list.add(new BasicNameValuePair("page","1"));
		//list.add(new BasicNameValuePair("id","25"));
		new Thread(new RequestRunnable(url_base+"room/history",list,post)).start();
	}
	private static void topList() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
	//	list.add(new BasicNameValuePair("teacher_id","2"));
		new Thread(new RequestRunnable(url_base+"teacher/topList",list,post)).start();
	}
	private static void heart() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("member_id","3"));
		list.add(new BasicNameValuePair("ask_id","210"));	
		new Thread(new RequestRunnable(url_base+"teacher/heart",list,post)).start();
	}
	private static void enshrine() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("member_id","3"));
		list.add(new BasicNameValuePair("ask_id","210"));	
		new Thread(new RequestRunnable(url_base+"teacher/enshrine",list,post)).start();
	}
	private static void searchAskList(){
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("key","年轻"));	
		new Thread(new RequestRunnable(url_base+"teacher/searchAskList",list,post)).start();

	}
	private static void videoList(){
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		//list.add(new BasicNameValuePair("key","年轻"));	
		new Thread(new RequestRunnable(url_base+"room/videoList",list,post)).start();

	}
	private static void room_comment() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("video_id","34"));
		list.add(new BasicNameValuePair("content","随便评论点儿什么吧"));
		list.add(new BasicNameValuePair("member_id","230"));
		new Thread(new RequestRunnable(url_base+"room/comment",list,post)).start();
	}
	private static void room_commentList() {
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=true;
		list.add(new BasicNameValuePair("video_id","34"));
		new Thread(new RequestRunnable(url_base+"room/commentList",list,post)).start();
	}
	public static void main(String[] args) {
		//goodpoint();
		//long l=1000L*60*60*24*365;
		//System.out.println(l);
		room_commentList();
	}
}
