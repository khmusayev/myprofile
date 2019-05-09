package com.myprofile.restController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myprofile.entity.User;
import com.myprofile.entity.UserJob;
import com.myprofile.service.UserJobService;
import com.myprofile.service.UserService;

@RestController
@RequestMapping("/userapi/users/{userId}")
public class UserJobController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserJobService userJobService;

	@GetMapping("/jobs")
	public List<UserJob> getUser(@PathVariable int userId) {

		Optional<User> theUser = userService.findById((long) userId);

		if (!theUser.isPresent()) {
			throw new RuntimeException("User id not found - " + userId);
		}
		List<UserJob> jobs = userJobService.findAll(userId);
		return jobs;
	}

	@PostMapping("/jobs")
	public UserJob addUser(@PathVariable int userId, @RequestBody UserJob theJob) {
		Optional<User> theUser = userService.findById((long) userId);

		if (!theUser.isPresent()) {
			throw new RuntimeException("User id not found - " + userId);
		}
		theJob.setId((long) 0);
		theJob.setUser(theUser.get());
		userJobService.save(theJob);
		return theJob;
	}
	
	@PutMapping("/jobs/{jobId}")
	public UserJob updateUser(@PathVariable int userId, @PathVariable int jobId, @RequestBody UserJob theJob) {
		Optional<User> theUser = userService.findById((long) userId);

		if (!theUser.isPresent()) {
			throw new RuntimeException("User id not found - " + userId);
		}
		
		List<UserJob> jobs = userJobService.findAll(userId);
		if(jobId >= jobs.size()) {
			throw new RuntimeException("UserJob id not found - " + userId);
		}
		long edittedJobId = jobs.get((int) jobId).getId();
		theJob.setUser(theUser.get());
		theJob.setId(edittedJobId);
		userJobService.save(theJob);
		return theJob;
	}
	
	@DeleteMapping("/jobs/{jobId}")
	public String deleteUser(@PathVariable int userId, @PathVariable int jobId) {
		Optional<User> theUser = userService.findById((long) userId);

		if (!theUser.isPresent()) {
			throw new RuntimeException("User id not found - " + userId);
		}
		List<UserJob> jobs = userJobService.findAll(userId);
		if(jobId >= jobs.size()) {
			throw new RuntimeException("UserJob id not found - " + userId);
		}
		long deletedJobId = jobs.get((int) jobId).getId();
		userJobService.delete(jobs.get((int) jobId));
		return "Deleted userJob id - " + deletedJobId;
	}

}
