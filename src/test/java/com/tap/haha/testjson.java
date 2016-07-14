package com.tap.haha;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class testjson {

	@Test
	public void testgson(){
		System.out.println("123");
		Map<String,String> messageMap = new HashMap<String, String>();
		messageMap.put("reqseq", "sda");
		messageMap.put("mobile", "18202732816");
		messageMap.put("msgsign", "123");
		messageMap.put("loginFlag", "0");
		Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
		
		String message = gson.toJson(messageMap);
		System.out.println(message);
		
		Type type = new TypeToken<Map<String, String>>() {}.getType();
		Map<String,String> map = new HashMap<String, String>();
		map = gson.fromJson(message, type);
		String reqseq = map.get("reqseq");
		System.out.println(reqseq);
	}
}
