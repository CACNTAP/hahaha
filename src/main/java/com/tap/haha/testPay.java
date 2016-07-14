package com.tap.haha;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class testPay {

	public static void main(String []args){
		Map<String,String> messageMap = new HashMap<String, String>();
		messageMap.put("reqseq", "sda");
		messageMap.put("mobile", "18202732816");
		messageMap.put("msgsign", "123");
		messageMap.put("loginFlag", "0");
		
		Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
		String message = gson.toJson(messageMap);
		String result="";
		String urlStr="http://10.222.4.12:8180/HzsmkManage/PayPlatInterface";
		try{
			
			
			
			URL url = new URL(urlStr);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-type", "application/json;charset=UTF-8");
			connection.connect();
			PrintWriter conOut = new PrintWriter(new BufferedOutputStream(connection.getOutputStream()));
			conOut.write(message);
			conOut.flush();
			conOut.close();
		
			result = changeInputStreamToString(connection.getInputStream(), "UTF-8");
	} catch (Exception e) {
		e.printStackTrace();
		result="FAILED!";
	}
		System.out.println(result);
	}
	
	private static String changeInputStreamToString(InputStream is, String charsetName)
			throws UnsupportedEncodingException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(is, charsetName));

		StringBuffer sb = new StringBuffer();
		String str = null;

		while ((str = br.readLine()) != null) {
			sb.append(str);
		}
		br.close();

		return sb.toString();
	}
	
}
