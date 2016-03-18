package com;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.cxg.httpclient.RequestRunnable_2;

public class DownloadStockDate {
	public static String url="http://market.finance.sina.com.cn/downxls.php";
	public static void downloadDate(String date,String code){
		//symbol,date
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		boolean post=false;
		list.add(new BasicNameValuePair("symbol",code));
		list.add(new BasicNameValuePair("date",date));
		new Thread(new RequestRunnable_2(url,list,post)).start();
	}
	public static void main(String[] args) throws ParseException, InterruptedException {
		File f=new File("C:/Users/Administrator/Desktop/export");
		String[] list=f.list();
		for(String code:list){
			String symbol=code.substring(0, 8).toLowerCase();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date d=sdf.parse("2014-06-12");
			Calendar can=Calendar.getInstance();
			for(int i=0;i<3650;i++){
				can.setTime(d);
				if(can.get(Calendar.DAY_OF_WEEK)!=Calendar.SATURDAY&&can.get(Calendar.DAY_OF_WEEK)!=Calendar.SUNDAY){
					downloadDate(sdf.format(d),symbol);
					Thread.sleep(2000);
				}
				d.setTime(d.getTime()-1000*60*60*24);
			}
		}
	}
}
