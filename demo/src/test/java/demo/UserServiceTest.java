package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.shawn.demo.business.UserService;
import com.shawn.demo.business.model.PageVO;
import com.shawn.demo.business.model.User;

public class UserServiceTest extends BaseTest {

	@Autowired
	private UserService userSerivce;

	private Logger logger = Logger.getLogger(getClass());

	 @Test
	@Rollback(value = false)
	public void testCreateUser() {
		User user = new User();
		user.setUserName("testUserName");
		user.setLoginName("testLogin");
		//user.setIsDeleted(1);
		user.setPassword("testPassword");
		user.setAuth("testAuth");
		user.setEmail("testEmail");
		user.setTelephone("testTel");
		int count = 1000000;
		List<User> userList = new ArrayList<User>();
		User[] userArray = new User[count];

		// for (int i = 0; i < count; i++) {
		// userList.add(user);
		// }
		// logger.info("------------------------------BEGIN----------------------------------");
		// Date begin = new Date();
		// try {
		// userSerivce.addUserList(userList);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// Date end = new Date();
		// double time = (end.getTime() - begin.getTime()) / 1000.00;
		// logger.info("------Insert " + count + " Time :  " + time + "s");
		// logger.info("------------------------------END------------------------------------");

		// for (int i = 0; i < count; i++) {
		// userArray[i] = user;
		// }
		// logger.info("------------------------------BEGIN----------------------------------");
		// Date begin = new Date();
		// try {
		// userSerivce.addUserArray(userArray);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// Date end = new Date();
		// double time = (end.getTime() - begin.getTime()) / 1000.00;
		// logger.info("------Insert " + count + " Time :  " + time + "s");
		// logger.info("------------------------------END------------------------------------");

		// logger.info("------------------------------BEGIN----------------------------------");
		// Date begin = new Date();
		// try {
		// for (int i = 0; i < count; i++) {
		// userSerivce.add(user);
		// }
		//
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// Date end = new Date();
		// double time = (end.getTime() - begin.getTime()) / 1000.00;
		// logger.info("------Insert " + count + " Time :  " + time + "s");
		// logger.info("------------------------------END------------------------------------");

		logger.info("------------------------------BEGIN----------------------------------");
		Date begin = new Date();
		userSerivce.add(user);
		Date end = new Date();
		double time = (end.getTime() - begin.getTime()) / 1000.00;
		logger.info("------Insert " + count + " Time :  " + time + "s");
		logger.info("------------------------------END------------------------------------");

	}

//	@Test
	public void testGetUser() {

		logger.info("------------------------getUserBegin-----------------------");
		User user = userSerivce.getUserById(10000);
		logger.info("userJSON : " + JSONObject.fromObject(user).toString());
		logger.info("------------------------getUserEnd-------------------------");
	}
}
