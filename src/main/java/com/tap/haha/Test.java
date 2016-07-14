package com.tap.haha;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;



public class Test  {

	public static void main(String[] a) {
		sendMessage();
		/*try {
			String jg = sendMsg();
			System.out.println("jg:"+jg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
	
	
	public static void sendMessage3(){  
	} 
	
	public static void sendMessage() {
		//String requestJson="{\"checktime\":\"20151124\",\"channelid\":\"003\",\"merchantid\":\"330100802001,330100802002,330100802003,330100802004,330100802005,330100802006,330100802007,330100802008\",\"txntype\": \"1006\"}";
		//String requestJson="{\"checktime\":\"20151124\",\"channelid\":\"003\",\"merchantid\":\"300100810001,300100810002,300100810003,300100810004,300100810005,300100810006,300100810007,300100810008\",\"txntype\": \"1006\"}";
		//String requestJson="{\"checktime\":\"20151203\",\"channelid\":\"003\",\"merchantid\":\"330100602001\",\"txntype\": \"1006\"}";
		//String requestJson="{\"checktime\":\"20151013\",\"merchantid\":\"330100802003\",\"txntype\": \"1006\"}";
		//String requestJson="{\"checktime\":\"20150130\",\"channelid\":\"1\",\"merchantid\":\"330100600001\",\"txntype\": \"1006\"}";
		//String requestJson="checktime=20140901&merchantid=000002&txntype=1006";
		String requestJson="{\"reqseq\":\"123456\",\"startTime\":\"20151118000000\"," +
				"\"endTime\":\"20151118235959\",\"merchantId\":\"330100830002\"," +
				"\"txStatus\":\"1\",\"txnType\": \"3016\",\"msgSign\": \"4CD607E34CA0307D57C9455BCC07C6F0\"}";
//		String requestJson="{\"FunCode\":\"1018\",\"ReqSeq\":\"123456\"," +
//				"\"BeginDate\":\"20160711\",\"EndDate\":\"20160711\",\"CurrPage\":\"1\",\"PageSize\":\"10000\"}";
		
//		String requestJson="requestData={\"app_id\":\"zyyy_android\",\"app_key\":\"ZW5sNWVWOWhibVJ5YjJsaw==\"," +
//				"\"user_type\":\"2\",\"api_name\":\"api.hzpt.citizenapp.login\"," +
//				"\"params\":{\"id_card_type\":\"SFZ\",\"login_name\":\"330102199112132717\"," +
//				"\"password\":\"8B39A8192CD5A961\"}}";
		
//		String requestJson="{\"txntype\": \"1006\",\"reqseq\":\"20160531151112123456\"," +
//				"\"checktime\":\"20160531\"," +
//				"\"merchantid\":\"000002\",\"channelid\":\"002\"}";
		
		try {
			PostMethod //postMethod = new PostMethod("http://192.168.23.192:8010/ESBWeb/servlets/PrepaidRecharge");
			//postMethod = new PostMethod("http://10.10.10.4:8010/ESBWeb/servlets/PrepaidRecharge");
			//postMethod = new PostMethod("http://10.222.9.13:8010/ESBWeb/servlets/PrepaidRecharge");
			//postMethod = new PostMethod("http://10.222.4.14:8010/ESBWeb/servlets/PrepaidRecharge");
			//postMethod = new PostMethod("http://10.10.10.5:8080/HzsmkManage/PayPlatInterface");  //���ǻ�����
			postMethod = new PostMethod("http://10.222.4.22:8010/ESBWeb/servlets/PrepaidRecharge");  //���ǻ����������ԣ�
			//postMethod = new PostMethod("http://10.222.4.22:8010/ESBWeb/servlets/BDBasicBusiness");
			//postMethod = new PostMethod("http://10.222.9.13:8010/ESBWeb/servlets/BDBasicBusiness");  //����Ǯ����������
			//postMethod = new PostMethod("http://10.10.10.18:8082/hzrecharge/servlet/ServiceServlet");   //����Ǯ��(����)
			//postMethod = new PostMethod("http://10.222.4.22:8010/ESBWeb/servlets/BDBasicBusiness");   //����Ǯ��(����)
			//postMethod = new PostMethod("http://10.101.200.201:8080/hzrecharge/servlet/ServiceServlet");  //����Ǯ��
			//http://192.168.80.201:8080/hzrecharge/servlet/ServiceServlet
			//postMethod = new PostMethod("http://10.222.9.13:8010/ESBWeb/servlets/E_purse");  //���ǻ�������������
			
			//postMethod = new PostMethod("http://ucmed.7766.org:28080/api/exec.htm");  //����ҽԺ��¼�����ԣ�
			//postMethod = new PostMethod("http://10.222.4.12:8180/HzsmkManage/PayPlatformInterface");  //�̻�/�����г�
			System.out.println("requestJson:" + requestJson);
			
			postMethod.setRequestEntity(new StringRequestEntity(requestJson,"text/xml", "utf-8"));
			postMethod.setRequestHeader("Content-type","text/xml; charset=utf-8");
			//postMethod.setRequestHeader("Content-type","application/xml; charset=utf-8");
			postMethod.getParams().setContentCharset("UTF-8");

//			postMethod.setRequestEntity(new StringRequestEntity(requestJson,"application/json", "utf-8"));
//			postMethod.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=utf-8");
//			//postMethod.setRequestHeader("Accept","application/xml,application/xhtml+xml," +
//					//"text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
//			//postMethod.setRequestHeader("Content-type","text/xml; charset=utf-8");
//			postMethod.getParams().setContentCharset("UTF-8");


			HttpClient httpClient = new HttpClient();
			// httpClient.executeMethod(postMethod);

			int resultint = httpClient.executeMethod(postMethod);
			
			// log.info("resultint====="+resultint);
			System.out.println("resultint=======" + resultint);

			// msg ��Ϊ���󷵻ص���Ϣ���������Ǽ������󷵻ص���Ϣ��xml��ʽ��

			// ��ô��msg����һ��xml��ʽ���ַ�������
			//System.out.println(postMethod.getResponseBodyAsString());
			//responseXml = new String(postMethod.getResponseBody());
			String responseStr = postMethod.getResponseBodyAsString();
			// log.info("msg=========="+msg);

			System.out.println("responseStr:" + responseStr);

			postMethod.releaseConnection();

		} catch (Exception ex) {
			// log.info("Post�����쳣��"+ex.getMessage());
			System.out.print("exception message:" + ex.getMessage());
			ex.printStackTrace();
		}
		return ;
	}

	public static void sendMessage2() {
		//String requestJson="{\"checktime\":\"20140901\",\"channelid\":\"1\",\"merchantid\":\"000002\",\"txntype\": \"1006\"}";
		String requestJson="";
		try {
			//PostMethod postMethod = new PostMethod("http://192.168.23.171:8020/HzsmkManage/PayPlatformInterface?checktime=20141218&channelid=1&merchantid=000002&txntype=1006");
			/*PostMethod postMethod = new PostMethod("http://10.10.10.5:8080/HzsmkManage/PayPlatInterface?" +
					"reqseq=123456&starttime=20151124101112&endtime=20151124202122&" +
					"merchantid=330100830002&txstatus=1&chanelid=1&txntype=3016&msgsign=23d8f619cdb95de6");*/
			//PostMethod postMethod = new PostMethod("http://10.10.10.5:8080/HzsmkManage/PayPlatformInterface?checktime=20141230&channelid=1&merchantid=330100450002&txntype=1006");
			//PostMethod postMethod = new PostMethod("http://10.10.10.5:8080/HzsmkManage/PayPlatformInterface?checktime=20141219&channelid=1&merchantid=000002&txntype=1006");
			//PostMethod postMethod = new PostMethod("http://10.10.10.5:8080/HzsmkManage/PayPlatformInterface?checktime=20150109&channelid=1&merchantid=MOB000002&txntype=1006");
			//PostMethod postMethod = new PostMethod("http://ucmed.7766.org:28080/api/exec.htm?app_id=zyyy_android");
			PostMethod postMethod = new PostMethod("http://10.222.4.12:8180/HzsmkManage/PayPlatformInterface?" +
					"txntype=1006&reqseq=20160531151112123456&checktime=20160530&merchantid=000002&channelid=002");
			
			System.out.println("requestJson:" + requestJson);

			postMethod.setRequestEntity(new StringRequestEntity(requestJson,"text/xml", "utf-8"));
			postMethod.setRequestHeader("Content-type","application/xml; charset=utf-8");
			postMethod.getParams().setContentCharset("UTF-8");


			HttpClient httpClient = new HttpClient();
			// httpClient.executeMethod(postMethod);

			int resultint = httpClient.executeMethod(postMethod);
			
			// log.info("resultint====="+resultint);
			System.out.println("resultint=======" + resultint);

			// msg ��Ϊ���󷵻ص���Ϣ���������Ǽ������󷵻ص���Ϣ��xml��ʽ��

			// ��ô��msg����һ��xml��ʽ���ַ�������
			//System.out.println(postMethod.getResponseBodyAsString());
			//responseXml = new String(postMethod.getResponseBody());
			String responseStr = postMethod.getResponseBodyAsString();
			// log.info("msg=========="+msg);

			System.out.println("responseStr:" + responseStr);

			postMethod.releaseConnection();

		} catch (Exception ex) {
			// log.info("Post�����쳣��"+ex.getMessage());
			System.out.print("exception message:" + ex.getMessage());
			ex.printStackTrace();
		}
		return ;
	}
	
	public static String sendMsg() throws IOException { 
		String json = "{\"app_id\":\"zyyy_android\",\"app_key\":\"ZW5sNWVWOWhibVJ5YjJsaw==\"," +
		"\"user_type\":\"2\",\"api_name\":\"api.hzpt.citizenapp.login\"," +
		"\"params\":{\"id_card_type\":\"SFZ\",\"login_name\":\"330102199112132717\"," +
		"\"password\":\"8B39A8192CD5A961\"}}";
		String sendURL = "http://ucmed.7766.org:28080/api/exec.htm";
		URL url = null; 
		HttpURLConnection httpConn = null; 
		OutputStream output = null; 
		OutputStreamWriter outr = null; 
		url = new URL(sendURL); 
		httpConn = (HttpURLConnection) url.openConnection(); 
		HttpURLConnection.setFollowRedirects(true); 
		httpConn.setDoOutput(true); 
		httpConn.setRequestMethod("POST"); 
		//httpConn.setRequestProperty("Accept", "application/json"); // ���ý������ݵĸ�ʽ 
		//httpConn.setRequestProperty("Content-Type", "application/json"); // ���÷������ݵĸ�ʽ
		httpConn.setRequestProperty("Accept","application/xml,application/xhtml+xml," +
				"text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
		httpConn.setRequestProperty("Content-type","application/x-www-form-urlencoded;charset=utf-8");
		httpConn.connect(); 
		output = httpConn.getOutputStream(); 
		outr = new OutputStreamWriter(output); 
		// д��������� 
		outr.write(json.toCharArray(), 0, json.length()); 
		outr.flush(); 
		outr.close(); 
		System.out.println("send ok"); 
		int code = httpConn.getResponseCode(); 
		System.out.println("code " + code); 
		System.out.println(httpConn.getResponseMessage()); 
		// ��ȡ��Ӧ���� 
		String sCurrentLine = ""; 
		String sTotalString = ""; 
		if (code == 200) { 
		java.io.InputStream is = httpConn.getInputStream(); 
		BufferedReader reader = new BufferedReader(new InputStreamReader(is)); 
		while ((sCurrentLine = reader.readLine()) != null) 
		if (sCurrentLine.length() > 0) 
		sTotalString = sTotalString + sCurrentLine.trim(); 
		} else { 
		sTotalString = "Զ�̷���������ʧ��,�������:" + code; 
		} 
		System.out.println("response:" + sTotalString); 
		return sTotalString; 
	}
	
	public static void sendMessage4() {
		String requestJson = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
				"<UPS xmlns=\"http://pay.1-ka.com/project/ups\">" +
				"    <Request id=\"20160527134434692001000000079247\">" +
				"        <Version>1.0</Version>" +
				"        <TxType>TQ33</TxType>" +
				"        <TxInfo>" +
				"            <OrgTxTraceNo/>" +
				"        </TxInfo>" +
				"        <Merchant>" +
				"            <MerchantID>000002</MerchantID>" +
				"        </Merchant>" +
				"    </Request>" +
				"    <Signature xmlns=\"http://www.w3.org/2000/09/xmldsig#\">" +
				"        <SignedInfo>" +
				"            <CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/>" +
				"            <SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\"/>" +
				"            <Reference URI=\"#20160527134434692001000000079247\">" +
				"                <Transforms>" +
				"                    <Transform Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/>" +
				"                </Transforms>" +
				"                <DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\"/>" +
				"                <DigestValue>4aFv+cPVa2t0rzs7av5AescMFvo=</DigestValue>" +
				"            </Reference>" +
				"        </SignedInfo>" +
				"        <SignatureValue>P9N+aFafWCiI" +
				"/aXgi+64BGvCV1d7OVFeyWgBct1zRwObfbR9bEeqLMfHaruWPnCDyCNE" +
				"/nabuWxZJ8LU/bW/DunsdpGotaKIpxzlTbKZQyvqcfKGPINPjoQY4T15Khsb2wkCcvZCCN/+eghVmWDMW2IQNY6f2HTi" +
				"//9Za5ct3yU=</SignatureValue>" +
				"        <KeyInfo>" +
				"            <X509Data>" +
				"                <X509IssuerSerial>" +
				"                    <X509IssuerName>O=CFCA Operation CA2, C=CN</X509IssuerName>" +
				"                    <X509SerialNumber>126178786211447548696050163190962336119</X509SerialNumber>" +
				"                </X509IssuerSerial>" +
				"            </X509Data>" +
				"        </KeyInfo>" +
				"    </Signature>" +
				"</UPS>";
		
		
		
			//String requestJson = "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz4KPFVQUyB4bWxucz0iaHR0cDovL3BheS4xLWthLmNvbS9wcm9qZWN0L3VwcyI+CiAgICA8UmVxdWVzdCBpZD0iMjAxNjA1MjcwOTE0MDk2ODMwMDEwMDAwMDAwNzkwMjciPgogICAgICAgIDxWZXJzaW9uPjEuMDwvVmVyc2lvbj4KICAgICAgICA8VHhUeXBlPlRRMzQ8L1R4VHlwZT4KICAgICAgICA8VHhJbmZvPgogICAgICAgICAgICA8Q29tcGFyZURhdGU+MjAxNjA1Mjc8L0NvbXBhcmVEYXRlPgogICAgICAgIDwvVHhJbmZvPgogICAgICAgIDxNZXJjaGFudD4KICAgICAgICAgICAgPE1lcmNoYW50SUQ+MDAwMDAyPC9NZXJjaGFudElEPgogICAgICAgIDwvTWVyY2hhbnQ+CiAgICA8L1JlcXVlc3Q+CiAgICA8U2lnbmF0dXJlIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwLzA5L3htbGRzaWcjIj4KICAgICAgICA8U2lnbmVkSW5mbz4KICAgICAgICAgICAgPENhbm9uaWNhbGl6YXRpb25NZXRob2QgQWxnb3JpdGhtPSJodHRwOi8vd3d3LnczLm9yZy9UUi8yMDAxL1JFQy14bWwtYzE0bi0yMDAxMDMxNSIvPgogICAgICAgICAgICA8U2lnbmF0dXJlTWV0aG9kIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMC8wOS94bWxkc2lnI3JzYS1zaGExIi8+CiAgICAgICAgICAgIDxSZWZlcmVuY2UgVVJJPSIjMjAxNjA1MjcwOTE0MDk2ODMwMDEwMDAwMDAwNzkwMjciPgogICAgICAgICAgICAgICAgPFRyYW5zZm9ybXM+CiAgICAgICAgICAgICAgICAgICAgPFRyYW5zZm9ybSBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnL1RSLzIwMDEvUkVDLXhtbC1jMTRuLTIwMDEwMzE1Ii8+CiAgICAgICAgICAgICAgICA8L1RyYW5zZm9ybXM+CiAgICAgICAgICAgICAgICA8RGlnZXN0TWV0aG9kIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMC8wOS94bWxkc2lnI3NoYTEiLz4KICAgICAgICAgICAgICAgIDxEaWdlc3RWYWx1ZT5xY2IzTWlBWGo2NkZTekJRK2dKbk5EdTE2azQ9PC9EaWdlc3RWYWx1ZT4KICAgICAgICAgICAgPC9SZWZlcmVuY2U+CiAgICAgICAgPC9TaWduZWRJbmZvPgogICAgICAgIDxTaWduYXR1cmVWYWx1ZT4KWUQwTHBDMmJoNnhENmQrQzJYaXlEODVYajlBMjB1WEFzL291L0xmb0gzaE9rcnE1QjRQdURaN2dLK0hLdG1WNElPT3NzYStiT3RabApsNld5YWE0SENqek9jVWx6NWZqNE9HNGtMZWlzaGc1QnQ4eGVhalZJSTdBMmRmejJCdWdrdUFMVVZJZm5Kek5QVm53N3hkSFowaldUClBrcWp0OFlxR1N4eXFUMFJPK2M9CjwvU2lnbmF0dXJlVmFsdWU+CiAgICAgICAgPEtleUluZm8+CiAgICAgICAgICAgIDxYNTA5RGF0YT4KICAgICAgICAgICAgICAgIDxYNTA5SXNzdWVyU2VyaWFsPgogICAgICAgICAgICAgICAgICAgIDxYNTA5SXNzdWVyTmFtZT5PPUNGQ0EgT3BlcmF0aW9uIENBMiwgQz1DTjwvWDUwOUlzc3Vlck5hbWU+CiAgICAgICAgICAgICAgICAgICAgPFg1MDlTZXJpYWxOdW1iZXI+MTI2MTc4Nzg2MjExNDQ3NTQ4Njk2MDUwMTYzMTkwOTYyMzM2MTE5PC9YNTA5U2VyaWFsTnVtYmVyPgogICAgICAgICAgICAgICAgPC9YNTA5SXNzdWVyU2VyaWFsPgogICAgICAgICAgICA8L1g1MDlEYXRhPgogICAgICAgIDwvS2V5SW5mbz4KICAgIDwvU2lnbmF0dXJlPgo8L1VQUz4K";
		
		try {
			PostMethod postMethod = new PostMethod("http://10.222.4.12:8080/Simulator/MerchantTxControl");  //�̻�/�����г�
			System.out.println("requestJson:" + requestJson);
			
			postMethod.setRequestEntity(new StringRequestEntity(requestJson,"application/xml", "utf-8"));
			//postMethod.setRequestHeader("Content-type","application/json");
			//postMethod.setRequestHeader("Content-Length",Integer.valueOf(requestJson.length()).toString());
			postMethod.setRequestHeader("Content-type","application/xml; charset=utf-8");
			postMethod.getParams().setContentCharset("UTF-8");



			HttpClient httpClient = new HttpClient();
			// httpClient.executeMethod(postMethod);

			int resultint = httpClient.executeMethod(postMethod);
			
			// log.info("resultint====="+resultint);
			System.out.println("resultint=======" + resultint);

			// msg ��Ϊ���󷵻ص���Ϣ���������Ǽ������󷵻ص���Ϣ��xml��ʽ��

			// ��ô��msg����һ��xml��ʽ���ַ�������
			//System.out.println(postMethod.getResponseBodyAsString());
			//responseXml = new String(postMethod.getResponseBody());
			String responseStr = postMethod.getResponseBodyAsString();
			// log.info("msg=========="+msg);

			System.out.println("responseStr:" + responseStr);

			postMethod.releaseConnection();

		} catch (Exception ex) {
			// log.info("Post�����쳣��"+ex.getMessage());
			System.out.print("exception message:" + ex.getMessage());
			ex.printStackTrace();
		}
		return ;
	}
}
