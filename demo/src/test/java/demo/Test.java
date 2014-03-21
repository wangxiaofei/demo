package demo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Test {

	private static String sid = "831cc356921e4bb9ac1f15aca61f58d7";

	private static String domain = "http://localhost:8080/rad";

	private Logger logger = Logger.getLogger(Test.class);

	public void post(String url, List<NameValuePair> params) throws Exception {
		// 创建HttpClient实例
		HttpClient client = new DefaultHttpClient();
		// 根据URL创建HttpPost实例
		HttpPost post = new HttpPost(url);
		// 编码格式转换
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params);
		// 传入请求体
		post.setEntity(entity);
		// 发送请求，得到响应体
		HttpResponse response = client.execute(post);
		// 判断是否正常返回
		if (response.getStatusLine().getStatusCode() == 200) {
			// 解析数据
			HttpEntity resEntity = response.getEntity();
			String data = EntityUtils.toString(resEntity);
			logger.info(data);
		}
	}

	public void testLogin() {
		String url = domain + "/user/login";
		JSONObject obj = new JSONObject();
		String param = null;
		try {
			obj.put("username", "tianbo");
			obj.put("passwd", "tianbo");
			param = new String(Base64.encodeBase64(obj.toString().getBytes()));
			logger.info(param);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		// 构造post参数
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("params", param));
		try {
			post(url, params);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void testCreateReportRequest() {
		String url = domain + "/diag/createreportrequest";

		String param = null;
		JSONObject obj = new JSONObject();
		try {
			obj.put("sid", sid);
			obj.put("desc", "desc1");
			obj.put("tplid", "1000");
			obj.put("patuid", "11111");
			obj.put("patstudyid", "1111");
			obj.put("patname", "patname1");
			obj.put("patage", "11");
			obj.put("patpart", "patpart1");
			obj.put("modality", "modality1");
			obj.put("diaguid", "101260");
			obj.put("hasaid", "1");
			JSONArray array = new JSONArray();
			JSONObject o1 = new JSONObject();
			o1.put("patuid", "111");
			o1.put("patstudyid", "111");
			o1.put("patname", "patname1");
			o1.put("patage", "11");
			o1.put("patpart", "patpart1");
			o1.put("modality", "modality1");
			JSONObject o2 = new JSONObject();
			o2.put("patuid", "222");
			o2.put("patstudyid", "222");
			o2.put("patname", "patname2");
			o2.put("patage", "222");
			o2.put("patpart", "patpart2");
			o2.put("modality", "modality2");
			array.put(o1);
			array.put(o2);
			obj.put("aidlist", array);
			logger.info("JSON : " + obj.toString());
			param = new String(Base64.encodeBase64(obj.toString().getBytes()));
			logger.info("BASE64 : " + param);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		// 构造post参数
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("params", param));
		try {
			post(url, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testCreateTalkRequest() {
		String url = domain + "/diag/createtalkrequest";

		String param = null;
		JSONObject obj = new JSONObject();
		try {
			obj.put("sid", sid);
			obj.put("desc", "desc1");
			obj.put("tplid", "1000");
			obj.put("patuid", "11111");
			obj.put("patstudyid", "1111");
			obj.put("patname", "patname1");
			obj.put("patage", "11");
			obj.put("patpart", "patpart1");
			obj.put("modality", "modality1");
			obj.put("diaguid", "101260");
			obj.put("hasaid", "1");
			JSONArray array = new JSONArray();
			JSONObject o1 = new JSONObject();
			o1.put("patuid", "111");
			o1.put("patstudyid", "111");
			o1.put("patname", "patname1");
			o1.put("patage", "11");
			o1.put("patpart", "patpart1");
			o1.put("modality", "modality1");
			JSONObject o2 = new JSONObject();
			o2.put("patuid", "222");
			o2.put("patstudyid", "222");
			o2.put("patname", "patname2");
			o2.put("patage", "222");
			o2.put("patpart", "patpart2");
			o2.put("modality", "modality2");
			array.put(o1);
			array.put(o2);
			obj.put("aidlist", array);
			JSONObject o3 = new JSONObject();
			o3.put("partnerid", "101261");
			JSONObject o4 = new JSONObject();
			o4.put("partnerid", "101264");
			JSONArray array_partner = new JSONArray();
			array_partner.put(o3);
			array_partner.put(o4);
			obj.put("partnerlist", array_partner);
			logger.info("JSON : " + obj.toString());
			param = new String(Base64.encodeBase64(obj.toString().getBytes()));
			logger.info("BASE64 : " + param);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		// 构造post参数
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("params", param));
		try {
			post(url, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testCreateTalkRequestReply() {
		String url = domain + "/diag/createrequestreply";

		String param = null;
		JSONObject obj = new JSONObject();
		try {
			obj.put("sid", sid);
			obj.put("requestid", "103604");
			obj.put("content", "我回复我回复我回复我回复");

			logger.info("JSON : " + obj.toString());
			param = new String(Base64.encodeBase64(obj.toString().getBytes()));
			logger.info("BASE64 : " + param);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		// 构造post参数
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("params", param));
		try {
			post(url, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testCreateReport() {
		String url = domain + "/diag/createreport";

		String param = null;
		JSONObject obj = new JSONObject();
		try {
			obj.put("sid", sid);
			obj.put("requestid", "103604");
			obj.put("imagedesc", "影像表现、影像表现、影像表现、");
			obj.put("diagdesc", "诊断描述、诊断描述、诊断描述、");
			obj.put("diagret", "诊断结果、诊断结果、诊断结果、诊断结果、");

			logger.info("JSON : " + obj.toString());
			param = new String(Base64.encodeBase64(obj.toString().getBytes()));
			logger.info("BASE64 : " + param);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		// 构造post参数
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("params", param));
		try {
			post(url, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testGetReport() {
		String url = domain + "/diag/getreportinfo";

		String param = null;
		JSONObject obj = new JSONObject();
		try {
			obj.put("sid", sid);
			obj.put("requestid", "103604");

			logger.info("JSON : " + obj.toString());
			param = new String(Base64.encodeBase64(obj.toString().getBytes()));
			logger.info("BASE64 : " + param);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		// 构造post参数
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("params", param));
		try {
			post(url, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testGetReportRequestList() {
		String url = domain + "/diag/getreportrequestlist";

		String param = null;
		JSONObject obj = new JSONObject();
		try {
			obj.put("sid", sid);
			obj.put("requestid", "103603");
			obj.put("type", "1");
			obj.put("status", "2");
			obj.put("page", "1");
			obj.put("count", "100");
			logger.info("JSON : " + obj.toString());
			param = new String(Base64.encodeBase64(obj.toString().getBytes()));
			logger.info("BASE64 : " + param);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		// 构造post参数
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("params", param));
		try {
			post(url, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testGetTalkRequestList() {
		String url = domain + "/diag/gettalkrequestlist";

		String param = null;
		JSONObject obj = new JSONObject();
		try {
			obj.put("sid", sid);
			obj.put("requestid", "103604");
			obj.put("type", "1");
			obj.put("status", "2");
			obj.put("page", "1");
			obj.put("count", "100");

			logger.info("JSON : " + obj.toString());
			param = new String(Base64.encodeBase64(obj.toString().getBytes()));
			logger.info("BASE64 : " + param);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		// 构造post参数
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("params", param));
		try {
			post(url, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testGetRequestInfo() {
		String url = domain + "/diag/getrequestinfo";

		String param = null;
		JSONObject obj = new JSONObject();
		try {
			obj.put("sid", sid);
			obj.put("requestid", "103604");

			logger.info("JSON : " + obj.toString());
			param = new String(Base64.encodeBase64(obj.toString().getBytes()));
			logger.info("BASE64 : " + param);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		// 构造post参数
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("params", param));
		try {
			post(url, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testGetRequestAidInfo() {
		String url = domain + "/diag/getrequestaidinfo";

		String param = null;
		JSONObject obj = new JSONObject();
		try {
			obj.put("sid", sid);
			obj.put("requestid", "103604");

			logger.info("JSON : " + obj.toString());
			param = new String(Base64.encodeBase64(obj.toString().getBytes()));
			logger.info("BASE64 : " + param);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		// 构造post参数
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("params", param));
		try {
			post(url, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testGetTalkRequestInfo() {
		String url = domain + "/diag/gettalkrequestinfo";

		String param = null;
		JSONObject obj = new JSONObject();
		try {
			obj.put("sid", sid);
			obj.put("requestid", "103604");

			logger.info("JSON : " + obj.toString());
			param = new String(Base64.encodeBase64(obj.toString().getBytes()));
			logger.info("BASE64 : " + param);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		// 构造post参数
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("params", param));
		try {
			post(url, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testGetFriendList() {
		String url = domain + "/friend/getfriendlist";

		String param = null;
		JSONObject obj = new JSONObject();
		try {
			obj.put("sid", sid);

			logger.info("JSON : " + obj.toString());
			param = new String(Base64.encodeBase64(obj.toString().getBytes()));
			logger.info("BASE64 : " + param);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		// 构造post参数
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("params", param));
		try {
			post(url, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testGetFriendApplyList() {
		String url = domain + "/friend/getfriendapplylist";
		String param = null;
		JSONObject obj = new JSONObject();
		try {
			obj.put("sid", sid);
			obj.put("page", "1");
			obj.put("count", "100");
			logger.info("JSON : " + obj.toString());
			param = new String(Base64.encodeBase64(obj.toString().getBytes()));
			logger.info("BASE64 : " + param);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		// 构造post参数
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("params", param));
		try {
			post(url, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testGetFriendAuthList() {
		String url = domain + "/friend/getfriendauthlist";
		String param = null;
		JSONObject obj = new JSONObject();
		try {
			obj.put("sid", sid);
			obj.put("page", "1");
			obj.put("count", "100");
			logger.info("JSON : " + obj.toString());
			param = new String(Base64.encodeBase64(obj.toString().getBytes()));
			logger.info("BASE64 : " + param);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		// 构造post参数
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("params", param));
		try {
			post(url, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testAddFriend() {
		String url = domain + "/friend/addfriend";
		String param = null;
		JSONObject obj = new JSONObject();
		try {
			obj.put("sid", sid);
			obj.put("friendid", "101275");
			obj.put("applydesc", "测试添加好友");
			logger.info("JSON : " + obj.toString());
			param = new String(Base64.encodeBase64(obj.toString().getBytes()));
			logger.info("BASE64 : " + param);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		// 构造post参数
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("params", param));
		try {
			post(url, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testDelFriend() {
		String url = domain + "/friend/delfriend";
		String param = null;
		JSONObject obj = new JSONObject();
		try {
			obj.put("sid", sid);
			obj.put("friendid", "101275");
			logger.info("JSON : " + obj.toString());
			param = new String(Base64.encodeBase64(obj.toString().getBytes()));
			logger.info("BASE64 : " + param);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		// 构造post参数
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("params", param));
		try {
			post(url, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testAuthFriend() {
		String url = domain + "/friend/authfriend";
		String param = null;
		JSONObject obj = new JSONObject();
		try {
			obj.put("sid", sid);
			obj.put("applyuid", "101275");
			obj.put("status", "2");
			obj.put("authdesc", "测试拒绝信息");
			logger.info("JSON : " + obj.toString());
			param = new String(Base64.encodeBase64(obj.toString().getBytes()));
			logger.info("BASE64 : " + param);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		// 构造post参数
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("params", param));
		try {
			post(url, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Test test = new Test();
		test.testLogin();
		// test.testCreateReportRequest();
		// test.testCreateTalkRequest();
		// test.testCreateTalkRequestReply();
		// test.testCreateReport();
		// test.testGetReport();
		// test.testGetReportRequestList();
		// test.testGetTalkRequestList();
		// test.testGetRequestAidInfo();
		// test.testGetRequestInfo();
		// test.testGetTalkRequestInfo();
//		test.testGetFriendList();
		test.testGetFriendApplyList();
		test.testGetFriendAuthList();
//		test.testAddFriend();
//		test.testAuthFriend();
//		test.testDelFriend();
	}
}
