package com.tap.haha;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;  
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.omg.DynamicAny.NameValuePairSeqHelper;

import net.sf.json.JSONObject; 

public class TestSendSMS {
	
	public static void main(String[] args)
	{
		String uid="12345678";
		String title="test";
		String content ="test a haha";
		
	}
	
	public static String sendSms(String uid,String title,String content){
		HttpClient httpclient = new DefaultHttpClient();
		String smsUrl="http://192.168.0.1/service/sendsms";
		HttpPost httppost = new HttpPost(smsUrl);
		String strResult = "";
		
		try{
			List<NameValuePair> nameValue = new ArrayList<NameValuePair>();
			JSONObject jobj = new JSONObject();
			jobj.put("uid", uid);
			jobj.put("title", title);
			jobj.put("content", content);
			
//			nameValue.add(new BasicNameValueP)
		}
		catch(Exception e){
			
		}
		return null;
	}
}
