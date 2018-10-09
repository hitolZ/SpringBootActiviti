package com.hitol.springbootactiviti;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.identity.User;
import org.activiti.engine.test.ActivitiRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivitiTest {

	@Autowired
	ProcessEngine processEngine;
	
	@Test
	public void testUser() {
		IdentityService identityService =processEngine.getIdentityService();
		User user = identityService.newUser("hitol");
		user.setFirstName("hitol");
		user.setLastName("zhu");
		user.setEmail("i@hitol.me");
		identityService.saveUser(user);
		
		User userInDb = identityService.createUserQuery().userId("hitol").singleResult();
		System.out.println(userInDb);
	}

}
