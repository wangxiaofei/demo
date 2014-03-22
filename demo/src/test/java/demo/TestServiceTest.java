package demo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.shawn.demo.business.TestService;
import com.shawn.demo.business.UserService;

public class TestServiceTest extends BaseTest {

	@Autowired
	private TestService testService;
	@Autowired
	private UserService userService;

	@Test
	@Rollback(value = false)
	public void test() {

		com.shawn.demo.business.model.Test test = new com.shawn.demo.business.model.Test();
		// test.setName("aaa");

		try {
			testService.createTest(test);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
