package demo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
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

	private static String sid = "4d411202eea24ae2bd186a207295fd7c";

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
			obj.put("username", "wxf");
			String passwd = "123456";
			passwd=DigestUtils.md5Hex(passwd);
//			logger.info("password="+passwd);
			obj.put("passwd", passwd);
			obj.put("appid", "website");
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

	public void testReg() {
		String url = domain + "/user/register";
		JSONObject obj = new JSONObject();
		String param = null;
		try {
			obj.put("username", "wangxiaofei");
			obj.put("passwd", "wangxiaofei");
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

	public void testUpdateUser() {
		String url = domain + "/user/updateuser";
		JSONObject obj = new JSONObject();
		String param = null;
		try {
			obj.put("sid", sid);
			obj.put("email", "wangxiaofei340@163.com");
			obj.put("tel", "18511549100");
			obj.put("institutionid", "10000");
			// obj.put("institutionname", "北大第三医院");
			obj.put("title", "泌尿科专家");
			obj.put("sex", "1");
			obj.put("birthday", "1986-04-26");
			obj.put("age", "45");
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

	public void testGetUser() {
		String url = domain + "/user/getuser";
		JSONObject obj = new JSONObject();
		String param = null;
		try {
			obj.put("sid", sid);
			obj.put("userid", "22");
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

	public void testGetUser4Friend() {
		String url = domain + "/user/queryuser";
		JSONObject obj = new JSONObject();
		String param = null;
		try {
			obj.put("sid", sid);
			obj.put("name", "单");
			obj.put("page", "1");
			obj.put("count", "100");
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

	public void testDelReport() {
		String url = domain + "/diag/delrequest";

		String param = null;
		JSONObject obj = new JSONObject();
		try {
			obj.put("sid", sid);
			obj.put("requestid", "103311");
			obj.put("type", "2");
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
			// obj.put("requestid", "103603");
			obj.put("type", "1");
			obj.put("status", "1");
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

	public void testSearchReportRequestList() {
		String url = domain + "/diag/searchreportrequestlist";

		String param = null;
		JSONObject obj = new JSONObject();
		try {
			obj.put("sid", sid);
			// obj.put("requestid", "103603");
			// obj.put("patname", "a");
			obj.put("type", "1");
			obj.put("status", "1");
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

	public void testQueryReportRequestList() {
		String url = domain + "/diag/queryreportrequestlist";
		String param = null;
		JSONObject obj = new JSONObject();
		try {
			obj.put("sid", sid);
			// obj.put("requestid", "103603");
			obj.put("keywords", "a");
			// obj.put("patname", "11");
			obj.put("requestbegintime", "2014-05-05");
			obj.put("type", "2");
			obj.put("status", "0");
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
			// obj.put("requestid", "103604");
			obj.put("type", "1");
			obj.put("status", "0,1,2");
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

	public void testDelMessage() {
		String url = domain + "/mess/delmess";
		String param = null;
		JSONObject obj = new JSONObject();
		try {
			obj.put("sid", sid);
			obj.put("messid", "107360");
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

	public void testGetInstitutionsByName() {
		String url = domain + "/ins/getbyname";
		String param = null;
		JSONObject obj = new JSONObject();
		try {
			obj.put("sid", sid);
			obj.put("name", "医");
			obj.put("page", "1");
			obj.put("count", "10");
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

	public void testUploadCallback() {
		String url = domain + "/cloud/uploadcallback";
		String param = null;
		JSONObject obj = new JSONObject();
		try {
			obj.put("sid", sid);
			obj.put("ret", "2");
			obj.put("entitytype", "1");
			obj.put("entityid", "103438");
			JSONArray array = new JSONArray();
			JSONObject o1 = new JSONObject();
			o1.put("filename", "filename");
			o1.put("key", "abfdjfklasdjfjaslfjlas;f");
			o1.put("domain", "domain.qiniu.com");
			o1.put("size", "123456789");
			o1.put("filetype", "1");

			JSONObject o2 = new JSONObject();
			o2.put("filename", "filename2");
			o2.put("key", "fasdfadsfdasdfasdfasfd;f");
			o2.put("domain", "domain.qiniu.com");
			o2.put("size", "987654321");
			o2.put("filetype", "2");
			array.put(o1);
			array.put(o2);
			// obj.put("uplist", array);
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

	public void testFindPassword() {
		String url = domain + "/user/findpass";
		String param = null;
		JSONObject obj = new JSONObject();
		try {
			obj.put("username", "wangxiaofei");
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

	public void testGetDownloadURL() {
		String url = domain + "/cloud/getdownloadurl";
		String param = null;
		JSONObject obj = new JSONObject();
		try {
			obj.put("sid", sid);
			obj.put("id", "105761");
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

	public void testGetMessageCount() {
		String url = domain + "/mess/getmesscount";
		String param = null;
		JSONObject obj = new JSONObject();
		try {
			obj.put("sid", sid);
			obj.put("status", "0");
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

	public void testAuth() {
		String url = domain + "/auth/authaction";
		String param = null;
		JSONObject obj = new JSONObject();
		try {
			obj.put("sid", sid);
			obj.put("action", "2");
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

	public void testCreateRepo() {
		String url = domain + "/repo/create";
		String param = null;
		JSONObject obj = new JSONObject();
		try {
			obj.put("sid", sid);
			obj.put("pid", "1004");
			obj.put("userid", "-1");
			obj.put("name", "根节点1-子节点1-子节点1");
			obj.put("imgdesc", "根节点1-子节点1-子节点1影像描述");
			obj.put("diagdesc", "根节点1-子节点1-子节点1诊断描述");
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

	public void testUpdateRepo() {
		String url = domain + "/repo/update";
		String param = null;
		JSONObject obj = new JSONObject();
		try {
			obj.put("sid", sid);
			obj.put("id", "1006");
			obj.put("pid", "0");
			obj.put("userid", "-1");
			obj.put("name", "根节点5");
			obj.put("imgdesc", "根节点5影像描述");
			obj.put("diagdesc", "根节点5诊断描述");
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

	public void testDelRepo() {
		String url = domain + "/repo/delete";
		String param = null;
		JSONObject obj = new JSONObject();
		try {
			obj.put("sid", sid);
			obj.put("id", "1000");
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

	public void testGetRepo() {
		String url = domain + "/repo/get";
		String param = null;
		JSONObject obj = new JSONObject();
		try {
			obj.put("sid", sid);
			obj.put("pid", "1004");
			obj.put("status", "-1,0");
			// obj.put("userid", "");
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

	public void testAuthUser() {
		String url = domain + "/user/authuser";
		String param = null;
		JSONObject obj = new JSONObject();
		try {
			obj.put("sid", sid);
			obj.put("approveid", "101380");
			obj.put("ispass", "1");
			obj.put("approvedesc", "Test ApproveDesc");
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

	public void testCheckUpdate() {
		String url = domain + "/app/checkupdate";
		String param = null;
		JSONObject obj = new JSONObject();
		try {
			// obj.put("sid", sid);
			obj.put("version", "1.0.0");
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
	
	public void testBugReport() {
		String url = domain + "/app/bugreport";
		String param = null;
		JSONObject obj = new JSONObject();
		try {
			 obj.put("msg", "abcdefg");
			obj.put("version", "1.0.0");
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
	public void testCreateFeedBack() {
		String url = domain + "/app/createfeedback";
		String param = null;
		JSONObject obj = new JSONObject();
		try {
			obj.put("content", "abcdefg");
			obj.put("userid", "1000");
			obj.put("product", "1");
			obj.put("email", "aaaaa@aa.com");
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
	
	public void testGetMessTypeAndCount(){
		String url = domain + "/mess/getmesstypeandcount";
		String param = null;
		JSONObject obj = new JSONObject();
		try {
			obj.put("sid", sid);
			obj.put("status", "0,1");			
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
	
	public void testGetApproveInfoByUser(){
		String url = domain + "/approve/getapproveinfobyuser";
		String param = null;
		JSONObject obj = new JSONObject();
		try {
			obj.put("sid", sid);
			obj.put("userid", "1");			
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
	
	public void testGetNoReadCount(){
		String url = domain + "/diag/getnoreadcount";
		String param = null;
		JSONObject obj = new JSONObject();
		try {
			obj.put("sid", sid);
			obj.put("userid", "1");			
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
	
	public void testGetNoProcessCount(){
		String url = domain + "/diag/getnoprocesscount";
		String param = null;
		JSONObject obj = new JSONObject();
		try {
			obj.put("sid", sid);
			obj.put("userid", "1");			
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
	
	public void testSetReaded(){
		String url = domain + "/diag/setreaded";
		String param = null;
		JSONObject obj = new JSONObject();
		try {
			obj.put("sid", sid);
			obj.put("requestid", "1009");			
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
	
	public void testQueryUser(){
		String url = domain + "/user/queryuser";
		String param = null;
		JSONObject obj = new JSONObject();
		try {
			obj.put("sid", sid);
			obj.put("name", "王");	
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
	public void testGetRecommendUser(){
		String url = domain + "/user/getrecommendlist";
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

	public static void main(String[] args) {
		Test test = new Test();
//		 test.testLogin();
		// test.testCreateReportRequest();
		// test.testCreateTalkRequest();
		// test.testCreateTalkRequestReply();
		// test.testCreateReport();
		// test.testGetReport();
		// test.testGetReportRequestList();
		// test.testSearchReportRequestList();
		// test.testGetTalkRequestList();
		// test.testGetRequestAidInfo();
		// test.testGetRequestInfo();
		// test.testGetTalkRequestInfo();
		// test.testGetFriendList();
		// test.testGetFriendApplyList();
		// test.testGetFriendAuthList();
		// test.testAddFriend();
		// test.testAuthFriend();
		// test.testDelFriend();
		// test.testDelMessage();
		// test.testGetInstitutionsByName();
		// test.testReg();
		// test.testUpdateUser();
		// test.testGetUser();
		// test.testGetUser4Friend();
		// test.testUploadCallback();
		// test.testFindPassword();
		// test.testGetDownloadURL();
		// test.testDelReport();
		// test.testGetMessageCount();
		// test.testAuth();
		// test.testSearchReportRequestList();
		// test.testQueryReportRequestList();
		// test.testCreateRepo();
		// test.testUpdateRepo();
		// test.testGetRepo();
		// test.testDelRepo();
//		test.testCheckUpdate();
//		 test.testAuthUser();
//		for(int i =0;i< 1000;i++){
//			test.testBugReport();
//		}
//		test.testCreateFeedBack();
//		 test.testGetMessTypeAndCount();
//		 test.testGetApproveInfoByUser();
//		test.testGetNoReadCount();
//		test.testGetNoProcessCount();
//		test.testSetReaded();
//		test.testQueryUser();
//		test.testGetUser();
		test.testGetRecommendUser();
	}
}
