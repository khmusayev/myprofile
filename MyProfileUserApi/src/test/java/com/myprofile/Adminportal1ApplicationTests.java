package com.myprofile;

import com.myprofile.entity.User;
import com.myprofile.entity.UserContact;
import com.myprofile.entity.UserEducation;
import com.myprofile.entity.UserJob;
import com.myprofile.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Adminportal1ApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void contextLoads() {
		assertNotNull(userRepository);
	}


	@Test
	public void testUserRepository() {
		User user = userRepository.findByUsername("niag");
		UserContact userContact = user.getUserContact();
		assertThat(userContact.getPhone(), is("+491234"));
		assertThat(userContact.getEmail(), is("niag@gmail.com"));
		assertThat(userContact.getAddress(), is("Address 1"));
		Set<UserJob> userJobs = user.getUserJobs();
		assertThat(userJobs.size(), is(2));
		Set<UserEducation> userEducations = user.getUserEdus();
		assertThat(userEducations.size(), is(3));
	}

}
