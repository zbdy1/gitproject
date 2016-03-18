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
	public static String serverName="�����ɾ�,�����ɾ�,ˮ����,̫���þ�,̫���þ�,�����ƾ�,�Ǻ��ƺ�,����б��,һ������,���ô�,�ٰ�һ��,����赺�,���񳯷�,�˷�����,��Եδ��,���ָ�,�ӱ�����,��������,�׶�����,��������,ŭ������,��������,ɽ������,�����Ļ�,������Ե,ϴ��¼,Ե������,��֥��Է,��ѩ��˪,��΢ɽ,������,��ɽ�۽�,����׺�,��������,���Ĵ���,�ϴ�����,��������,����ר��,̤ѩѰ��,�����˼�,����¥̨,�䳤��,��ˮ��,һҶ֪��,һս���,����Ȫ,�̲�̶,���㵺,����ͬ��,����֪��,��ǰ����,��������,�������,��Ԫʢ��,���̸�,���˵�,��ˮ����,��������,һ��һ��,һ������,�¹Ⱞ��,���°���";
	public static void query(String servername){
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=false;
		list.add(new BasicNameValuePair("act","ask"));
		list.add(new BasicNameValuePair("question",servername+"���翪��ʱ��"));
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
	 * Unicodeת��
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
	 * ��תunicode
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
