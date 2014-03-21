package demo;

import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.shawn.demo.business.UserService;
import com.shawn.demo.business.model.User;

public class UserServiceTest extends BaseTest{

	@Autowired
	private UserService userSerivce;
	
	private Logger logger = Logger.getLogger(getClass());
	
	@Test
	@Rollback(value=false)
	public void testCreateUser(){
		User user =new User();
		user.setUserName("testUserName");
		user.setLoginName("testLoginName");
		user.setIsDeleted(1);
		user.setPassword("testPassword");
		user.setAuth("testAuth");
		user.setEmail("testEmail");
		user.setTelephone("testTel");
		logger.info("------------------------------BEGIN----------------------------------");
		Date begin = new Date();
		int count  = 10000000;
		for(int i =0 ;i < count;i++){
			userSerivce.add(user);	
		}
		Date end = new Date();
		double time =  (end.getTime()-begin.getTime())/1000.00;
		logger.info("------Insert "+count+" Time :  " + time +"s");
		logger.info("------------------------------END------------------------------------");
		
	}
}
