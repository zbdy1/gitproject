package com.cxg.httpclient;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;



public class RequestRunnable_2 implements Runnable{
	private String path = "";
	List<NameValuePair> params=null;
	boolean postFlag;
	private HttpContext httpContext=null;
	boolean imageFlag=false;
	public RequestRunnable_2(String path,List<NameValuePair> params,boolean postFlag,boolean isImage){
		this.path=path;
		this.params=params;
		this.postFlag=postFlag;
		this.imageFlag=isImage;
	}
	public RequestRunnable_2(String path,List<NameValuePair> params,boolean postFlag){
		this.path=path;
		this.params=params;
		this.postFlag=postFlag;
	}
	public void setHttpContext(HttpContext httpContext){
		this.httpContext=httpContext;
	}
	public HttpContext getHttpContext(){
		return httpContext;
	}
	public void run() {
			HttpClient client = new DefaultHttpClient();
			HttpUriRequest post=null;
			if(postFlag){
				post = new HttpPost(path);		
				try {
					((HttpPost)post).setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				if(params.size()>0){
					path+="?"+params.get(0).getName()+"="+params.get(0).getValue();
					for(int i=1;i<params.size();i++){
						path+="&"+params.get(i).getName()+"="+params.get(i).getValue();
					}
				}
				 post=new HttpGet(path);
			}		
			try {
				if(httpContext==null){
					httpContext=HttpContextCenter.getContext();
				}
				HttpResponse response = client.execute(post,httpContext);
				HttpEntity resEntity = response.getEntity();
		          if (resEntity != null) {
		        	  
		        	  if(imageFlag){
		        		  FileOutputStream fileOutputStream =new FileOutputStream(new File("D:/5.jpg"));
		        		  byte[] buffer=new byte[1024];
		        		  InputStream is=resEntity.getContent();
		        		  int length=1024;
		        		  while((length=is.read(buffer))!=-1){
		        			  fileOutputStream.write(buffer, 0, length);
		        		  }
		        		  fileOutputStream.close();
		        		  
		        	  }else{
		        		  String basePath="D:/stock/"+params.get(0).getValue();
		        		  File f=new File(basePath);
		        		  if(f.exists()){
		        			  
		        		  }else{
		        			  f.mkdirs();
		        		  }
		        		  String fileName=params.get(0).getValue()+"_½»Ò×Ã÷Ï¸_"+params.get(1).getValue();
		        		  FileOutputStream fileOutputStream =new FileOutputStream(new File(basePath+"/"+fileName+".xls"));
		        		  byte[] buffer=new byte[1024];
		        		  InputStream is=resEntity.getContent();
		        		  int length=1024;
		        		  while((length=is.read(buffer))!=-1){
		        			  fileOutputStream.write(buffer, 0, length);
		        		  }
		        		  fileOutputStream.close();
		        		 
		        		 /* InputStreamReader isr=  new InputStreamReader(resEntity.getContent());
			        	  BufferedReader br=new BufferedReader(isr);
			        	  StringBuffer sb=new StringBuffer();
			        	  String s=null;
			        	  while((s=br.readLine())!=null){
			        		  sb.append(new String(s.getBytes("utf-8")));
			        	  }
			        	  System.out.println(sb.toString());*/
			        	  
		        	  }
		          }
		          if (resEntity != null) {
		            	resEntity.consumeContent();  
		            }  
			} catch (IOException e) {
				e.printStackTrace();
			} 
	
		}
}
