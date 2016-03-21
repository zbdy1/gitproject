package com.cxg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public final class UrlUtil {  
  
    private static HttpClient httpClient = new DefaultHttpClient();  
  
    /** 
     * @Title: getDataFromURL 
     * @Description: ���URL�����ȡ������֧��http 
     * @param strURL 
     *            Ҫ���ʵ�URL��ַ 
     * @param param 
     *            ���� 
     * @return ����ַ� 
     * @throws Exception 
     */  
    public static String getDataFromURL(String strURL, Map<String, String> param) throws Exception {  
        URL url = new URL(strURL);  
        URLConnection conn = url.openConnection();  
        conn.setDoOutput(true);  
  
        OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());  
        final StringBuilder sb = new StringBuilder(param.size() << 4); // 4�η�  
        final Set<String> keys = param.keySet();  
        for (final String key : keys) {  
            final String value = param.get(key);  
            sb.append(key); // ���ܰ������ַ�  
            sb.append('=');  
            sb.append(value);  
            sb.append('&');  
        }  
        // ������ '&' ȥ��  
        sb.deleteCharAt(sb.length() - 1);  
        writer.write(sb.toString());  
        writer.flush();  
        writer.close();  
  
        InputStreamReader reder = new InputStreamReader(conn.getInputStream(), "utf-8");  
        BufferedReader breader = new BufferedReader(reder);  
        // BufferedWriter w = new BufferedWriter(new FileWriter("d:/1.txt"));  
        String content = null;  
        String result = null;  
        while ((content = breader.readLine()) != null) {  
            result += content;  
        }  
  
        return result;  
    }  
  
    /** 
     * @Title: postMethod 
     * @Description: ���URL�����ȡ������֧��https 
     * @param url 
     *            Ҫ���ʵ�URL��ַ(http://www.xxx.com?) 
     * @param urlParm 
     *            ����(id=1212&pwd=2332) 
     * @return ����ַ� 
     */  
  /*  public static String postMethod(String url, String urlParm) {  
        if (null == url || "".equals(url)) {  
            // url = "http://www.baidu.com";  
            return null;  
        }  
        PostMethod post = new PostMethod(url); // new UTF8PostMethod(url);  
        if (null != urlParm && !"".equals(urlParm)) {  
            String[] arr = urlParm.split("&");  
            NameValuePair[] data = new NameValuePair[arr.length];  
            for (int i = 0; i < arr.length; i++) {  
                String name = arr[i].substring(0, arr[i].lastIndexOf("="));  
                String value = arr[i].substring(arr[i].lastIndexOf("=") + 1);  
                data[i] = new NameValuePair(name, value);  
            }  
            post.setRequestBody(data);  
        }  
        int statusCode = 0;  
        String pageContent = "";  
        try {  
            statusCode = httpClient.executeMethod(post);  
            if (statusCode == HttpStatus.SC_OK || statusCode == HttpStatus.SC_MOVED_TEMPORARILY) {  
                pageContent = post.getResponseBodyAsString();  
                return pageContent;  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        } finally {  
            post.releaseConnection();  
        }  
        return null;  
    }  */
  
  /*  public static String doPost(String url, String json) throws Exception {  
        PostMethod postMethod = new PostMethod(url);  
        StringRequestEntity requestEntity = new StringRequestEntity(json, "application/json", "UTF-8");  
        postMethod.setRequestEntity(requestEntity);  
         �������󣬲���ȡ��Ӧ����   
        int statusCode = httpClient.executeMethod(postMethod);  
        String result = null;  
        if (statusCode == HttpStatus.SC_OK) {  
            result = postMethod.getResponseBodyAsString();  
        } else {  
            System.out.println("Method failed: " + postMethod.getStatusLine());  
        }  
        return result;  
    }  */
  
    public static String post(String url, Map<String, String> params) {  
        DefaultHttpClient httpclient = new DefaultHttpClient();  
        String body = null;  
        HttpPost post = postForm(url, params);  
        body = invoke(httpclient, post);  
        httpclient.getConnectionManager().shutdown();  
        return body;  
    }  
  
    private static HttpPost postForm(String url, Map<String, String> params) {  
        HttpPost httpost = new HttpPost(url);  
        List<BasicNameValuePair> nvps = new ArrayList<BasicNameValuePair>();  
        Set<String> keySet = params.keySet();  
        for (String key : keySet) {  
            BasicNameValuePair basicNameValuePair = new BasicNameValuePair(key, params.get(key));  
            nvps.add(basicNameValuePair);  
        }  
        try {  
            httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        }  
        return httpost;  
    }  
  
    private static String invoke(DefaultHttpClient httpclient, HttpUriRequest httpost) {  
        HttpResponse response = sendRequest(httpclient, httpost);  
        String body = paseResponse(response);  
        return body;  
    }  
  
    private static HttpResponse sendRequest(DefaultHttpClient httpclient, HttpUriRequest httpost) {  
        HttpResponse response = null;  
        try {  
            response = httpclient.execute(httpost);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return response;  
    }  
  
    private static String paseResponse(HttpResponse response) {  
        HttpEntity entity = response.getEntity();  
        String body = null;  
        try {  
            body = EntityUtils.toString(entity);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return body;  
    }  
    public  String unicode2Str(String str) {
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
    public static void main(String[] args) throws Exception {  
        String url = "http://xy2.gm.163.com/cgi-bin/csa/csa_sprite.py";  
        Map<String, String> map = new HashMap<String, String>();  
        map.put("act","ask");
        map.put("question","今天周几");
        map.put("product_name","xy2");
        String msg = post(url, map);  
        
     System.out.println(msg);  
    }  
}