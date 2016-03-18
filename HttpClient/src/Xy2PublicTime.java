import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.cxg.httpclient.RequestRunnable;


public class Xy2PublicTime {
	public static String baseUrl="http://xy2.gm.163.com/cgi-bin/csa/csa_sprite.py";
	public static String serverName="蓬莱仙境,普陀仙境,水晶宫,太初幻境,太初幻境,雾隐云居,星河云海,烟雨斜阳,一生所爱,玉堂春,再爱一次,珠联璧合,百鸟朝凤,乘风破浪,尘缘未了,汉乐府,河北新区,鹤舞云天,雷动九天,六桥烟柳,怒海龙吟,齐云灵脉,山西新区,生如夏花,仙履奇缘,洗剑录,缘定三生,紫芝仙苑,傲雪凌霜,翠微山,花间月,华山论剑,剑烛沧海,佳期良年,龙的传人,南窗幽梦,琼树芳华,陕西专区,踏雪寻芳,天上人间,烟雨楼台,忆长安,易水歌,一叶知秋,一战顷城,月牙泉,碧波潭,钓鱼岛,风雨同舟,红颜知己,花前月下,剑胆琴心,剑侠风骨,开元盛世,凌烟阁,情人岛,似水流年,天若有情,一生一世,一生有你,月光爱人,月下爱人";
	public static void query(String servername){
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=false;
		list.add(new BasicNameValuePair("act","ask"));
		list.add(new BasicNameValuePair("question",servername+"最早开服时间"));
		list.add(new BasicNameValuePair("product_name","xy2"));
		new Thread(new RequestRunnable(baseUrl,list,post)).start();
	}
	public static void main(String[] args) throws InterruptedException {
		/*try {
			System.setOut(new PrintStream(new File("d:/5.txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		String serverArr[]=serverName.split(",");
		for(int i=0;i<serverArr.length;i++){
			String serverName=serverArr[i];
			//System.out.println(serverName);
			query(serverName);
			Thread.sleep(500);
		}
	}
	/**
	 * Unicode转串
	 * @param str
	 * @return
	 */
	public static String unicode2Str(String str) {

		StringBuffer sb = new StringBuffer();
		String[] arr = str.split("\\\\u");
		int len = arr.length;
		sb.append(arr[0]);
		for (int i = 1; i < len; i++) {
			String tmp = arr[i];
			char c = (char) Integer.parseInt(tmp.substring(0, 4), 16);
			sb.append(c);
			sb.append(tmp.substring(4));
		}
		return sb.toString();
	}
	/**
	 * 串转unicode
	 * @param str
	 * @return
	 */
	public static String str2Unicode(String str) {
		StringBuffer sb = new StringBuffer();
		char[] charArr = str.toCharArray();
		for (char ch : charArr) {
			if (ch > 128) {
				sb.append("\\u" + Integer.toHexString(ch));
			} else {
				sb.append(ch);
			}
		}
		return sb.toString();
	}
}
